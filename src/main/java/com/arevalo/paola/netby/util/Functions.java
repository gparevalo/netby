package com.arevalo.paola.netby.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.NamingException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author Paola Arevalo <p.arevaloq@hotmail.com>
 * @version 1.0
 * @date 04/06/2024
 */
public class Functions {
    private static final Logger log = LogManager.getLogger(Functions.class);

    /**
     * @param o
     * @return
     */
    public static String asString(Object o) {
        ObjectMapper objM = new ObjectMapper();
        try {
            return objM.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            return "That object can not be deserialized";
        }
    }

    /**
     * @param e
     * @return
     */
    public static String getErrorComplete(Exception e) {
        String str = "";
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        e.printStackTrace(new PrintStream(out));
        str = new String(out.toByteArray());
        if ((e instanceof GtiException) || (e instanceof NamingException))
            str = str.substring(0, 500);
        return "SERVICE ERROR : " + str;
    }

}
