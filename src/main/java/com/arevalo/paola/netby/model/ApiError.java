package com.arevalo.paola.netby.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * @author Paola Arevalo <p.arevaloq@hotmail.com>
 * @version 1.0
 * @date 04/06/2024
 */
@Getter
@Setter
public class ApiError {
    private String mensaje;
    private String codigo;

    public ApiError(String messages) {
        this.mensaje = messages;
        this.codigo = "-1";
    }

    public ApiError(String messages, String codigo) {
        this.mensaje = messages;
        this.codigo = Objects.isNull(codigo) ? "-1" : codigo;
    }

}
