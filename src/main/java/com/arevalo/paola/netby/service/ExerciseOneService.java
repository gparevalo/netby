package com.arevalo.paola.netby.service;

import com.arevalo.paola.netby.model.exerciseOne.Graph;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author Paola Arevalo <p.arevaloq@hotmail.com>
 * @version 1.0
 * @date 04/06/2024
 */
@Service
public class ExerciseOneService {
    private static final Logger log = LogManager.getLogger(ExerciseOneService.class);


    /**
     * Total distancia
     * Numero de rutas entre 2 ciuidades
     * Ruta mas corta
     *
     * @return
     */
    public String solveExerciseOne(String inputData) {

        Graph g = new Graph(inputData);
        String result = "==> DATA EXERCISE ONE:\n" + inputData + "\n"
                + "<== RESULT EXERCISE ONE:\n"
                + "Output #1: " + g.displayDistance("ABC") + "\n"
                + "Output #2: " + g.displayDistance("AD") + "\n"
                + "Output #3: " + g.displayDistance("ADC") + "\n"
                + "Output #4: " + g.displayDistance("AEBCD") + "\n"
                + "Output #5: " + g.displayDistance("AED") + "\n"
                + "Output #6: " + g.calculateTripsCount("C", "C", t -> t <= 3, 3) + "\n"
                + "Output #7: " + g.calculateTripsCount("A", "C", t -> t == 4, 4) + "\n"
                + "Output #8: " + g.calculateShortestPath("A", "C") + "\n"
                + "Output #9: " + g.calculateShortestPath("B", "B") + "\n"
                + "Output #10: " + g.calculateRoutesCount("C", "C", 30);

        log.info(result);

        return result;
    }

}
