package com.amar.SpringBoot.configuration;

import com.amar.SpringBoot.service.Coach;
import com.thirdParty.BadmintonCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach badmintonCoach(){
        return new BadmintonCoach();
    }
}
