package com.arevalo.paola.netby.service;

import com.arevalo.paola.netby.model.exerciseThree.InputProcessor;
import com.arevalo.paola.netby.model.exerciseThree.OutputProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author Paola Arevalo <p.arevaloq@hotmail.com>
 * @version 1.0
 * @date 04/06/2024
 */
@Service
public class ExerciseThreeService {
    private static final Logger log = LogManager.getLogger(ExerciseThreeService.class);

    public String solveExerciseThree(String inputData) {

        String[] inputArr = inputData.split(",");
        InputProcessor.processFile(inputArr);
        InputProcessor.mapTokentoIntegerValue();
        OutputProcessor.processReplyForQuestion();

        return "ok";
    }

}
