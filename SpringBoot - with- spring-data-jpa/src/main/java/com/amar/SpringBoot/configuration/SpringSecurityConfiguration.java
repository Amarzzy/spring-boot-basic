package com.amar.SpringBoot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}abc123")
                .roles("EMPLOYEE")
                .build();

        UserDetails sam = User.builder()
                .username("sam")
                .password("{noop}abc123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails ken = User.builder()
                .username("ken")
                .password("{noop}abc123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, sam, ken);
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize ->
                authorize
                        .requestMatchers(HttpMethod.GET,"api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT,"api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST,"api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"api/employees/**").hasRole("ADMIN")
        );

        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

}
