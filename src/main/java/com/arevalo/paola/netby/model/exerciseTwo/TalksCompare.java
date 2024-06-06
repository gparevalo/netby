package com.arevalo.paola.netby.model.exerciseTwo;

import lombok.*;

import java.util.Comparator;

/**
 * @author Paola Arevalo <p.arevaloq@hotmail.com>
 * @version 1.0
 * @date 04/06/2024
 */
public class TalksCompare implements Comparator<Talks> {

    @Override
    public int compare(Talks t1, Talks t2) {
        if(t1.getMinutes() < t2.getMinutes()){
            return 1;
        } else {
            return -1;
        }
    }
}