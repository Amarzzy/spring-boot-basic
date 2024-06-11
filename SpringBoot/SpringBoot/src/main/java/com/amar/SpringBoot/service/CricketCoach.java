package com.amar.SpringBoot.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CricketCoach implements Coach {

    CricketCoach(){
        System.out.println("Creating object of Cricket Coach");
    }
    @Override
    public String giveWorkout() {
        return "Hit 50 century";
    }
}
