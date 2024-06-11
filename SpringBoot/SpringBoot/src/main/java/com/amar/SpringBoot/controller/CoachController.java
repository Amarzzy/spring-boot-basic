package com.amar.SpringBoot.controller;

import com.amar.SpringBoot.service.Coach;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CoachController {

    public Coach coachService;

    public CoachController(@Qualifier("badmintonCoach") Coach coachService) {
        this.coachService = coachService;
    }

    @GetMapping("/workout")
    public ResponseEntity<String> getWorkout(){
        return ResponseEntity.ok().body(coachService.giveWorkout());
    }
}
