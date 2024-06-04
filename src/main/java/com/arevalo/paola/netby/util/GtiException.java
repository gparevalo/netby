package com.arevalo.paola.netby.util;

/**
 * @author Paola Arevalo <p.arevaloq@hotmail.com>
 * @version 1.0
 * @date 04/06/2024
 */
public class GtiException extends RuntimeException {
    private String codigoError;

    /**
     * @param message
     */
    public GtiException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param codigoError
     */
    public GtiException(String message, String codigoError) {
        super(message);
        this.codigoError = codigoError;
    }

    /**
     * @return
     */
    public String getCodigoError() {
        return codigoError;
    }
}
