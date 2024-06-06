package com.arevalo.paola.netby.controller;

import com.arevalo.paola.netby.routers.ServiceRouter;
import com.arevalo.paola.netby.service.ExerciseOneService;
import com.arevalo.paola.netby.service.ExerciseThreeService;
import com.arevalo.paola.netby.service.ExerciseTwoService;
import com.arevalo.paola.netby.util.RqConfig;
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
        return ResponseEntity.ok(exerciseOneService.solveExerciseOne(RqConfig.RQ_1));
    }

    @GetMapping(ServiceRouter.EXERCISE_TWO)
    public ResponseEntity<?> resultExerciseTwo() {
        return ResponseEntity.ok(exerciseTwoService.solveExerciseTwo(RqConfig.RQ_2));
    }

    @GetMapping(ServiceRouter.EXERCISE_THREE)
    public ResponseEntity<?> resultExerciseThree() {
        return ResponseEntity.ok(exerciseThreeService.solveExerciseThree(RqConfig.RQ_3));
    }

}
