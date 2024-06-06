package com.arevalo.paola.netby.model.exerciseThree;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Paola Arevalo <p.arevaloq@hotmail.com>
 * @version 1.0
 * @date 04/06/2024
 */
@Builder
@Getter
@Setter
public class Galaxy {

    private Map<String, String> tokenRomanValueMapping = new HashMap<String, String>();
    private Map<String, Float> tokenIntegerValue = new HashMap<String, Float>(); //{pish=10.0, tegj=50.0, prok=5.0, glob=1.0}
    private Map<String, String> questionAndReply = new HashMap<String, String>();  //{how much is pish tegj glob glob ?, how many Credits is glob prok Iron ?}
    private ArrayList<String> missingValues = new ArrayList<String>(); // [glob glob Silver is 34 Credits, glob prok Gold is 57800 Credits, pish pish Iron is 3910 Credits]
    private Map<String, Float> elementValueList = new HashMap<String, Float>(); //{Gold=14450.0, Iron=195.5, Silver=17.0}

}
