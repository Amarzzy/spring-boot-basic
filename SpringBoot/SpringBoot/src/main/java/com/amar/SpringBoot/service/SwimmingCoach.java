package com.amar.SpringBoot.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach{

    SwimmingCoach(){
        System.out.println("Creating Object of Swimming Coach");
    }

    @PostConstruct
    public void doInitStuff(){
        System.out.println("In Swimming Coach before Bean");
    }

    @PreDestroy
    public void doDestroyStuff(){
        System.out.println("In Swimming Coach before Bean Delete");
    }
    @Override
    public String giveWorkout() {
        return "Swim 1000 meters";
    }
}
