package com.thirdParty;

import com.amar.SpringBoot.service.Coach;

public class BadmintonCoach implements Coach {
    @Override
    public String giveWorkout() {
        return "Smash Shot Practice";
    }
}
