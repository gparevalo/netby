package com.arevalo.paola.netby.controller;

import com.arevalo.paola.netby.routers.ServiceRouter;
import com.arevalo.paola.netby.service.ExerciseOneService;
import com.arevalo.paola.netby.service.ExerciseThreeService;
import com.arevalo.paola.netby.service.ExerciseTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Paola Arevalo <p.arevaloq@hotmail.com>
 * @version 1.0
 * @date 04/06/2024
 */
@RestController
public class ServiceController {

    @Autowired
    ExerciseOneService exerciseOneService;

    @Autowired
    ExerciseTwoService exerciseTwoService;

    @Autowired
    ExerciseThreeService exerciseThreeService;

    @GetMapping(ServiceRouter.EXERCISE_ONE)
    public ResponseEntity<?> resultExerciseOne() {
        String inputData = "AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";

        return ResponseEntity.ok(exerciseOneService.solveExerciseOne(inputData));
    }

    @GetMapping(ServiceRouter.EXERCISE_TWO)
    public ResponseEntity<?> resultExerciseTwo() {
        String inputData = "Writing Fast Tests Against Enterprise Rails 60min," +
                "Overdoing it in Python 45min," +
                "Lua for the Masses 30min," +
                "Ruby Errors from Mismatched Gem Versions 45min," +
                "Common Ruby Errors 45min," +
                "Rails for Python Developers lightning," +
                "Communicating Over Distance 60min," +
                "Accounting-Driven Development 45min," +
                "Woah 30min," +
                "Sit Down and Write 30min," +
                "Pair Programming vs Noise 45min," +
                "Rails Magic 60min," +
                "Ruby on Rails: Why We Should Move On 60min," +
                "Clojure Ate Scala (on my project) 45min," +
                "Programming in the Boondocks of Seattle 30min," +
                "Ruby vs. Clojure for Back-End Development 30min," +
                "Ruby on Rails Legacy App Maintenance 60min," +
                "A World Without HackerNews 30min," +
                "User Interface CSS in Rails Apps 30min";

        return ResponseEntity.ok(exerciseTwoService.solveExerciseTwo(inputData));
    }

    @GetMapping(ServiceRouter.EXERCISE_THREE)
    public ResponseEntity<?> resultExerciseThree() {
        String inputData = "glob is I," +
                "prok is V," +
                "pish is X," +
                "tegj is L," +
                "glob glob Silver is 34 Credits," +
                "glob prok Gold is 57800 Credits," +
                "pish pish Iron is 3910 Credits," +
                "how much is pish tegj glob glob ?," +
                "how many Credits is glob prok Silver ?," +
                "how many Credits is glob prok Gold ?," +
                "how many Credits is glob prok Iron ?," +
                "how much wood could a woodchuck chuck if a woodchuck could chuck= wood ?";

        return ResponseEntity.ok(exerciseThreeService.solveExerciseThree(inputData));
    }

}
