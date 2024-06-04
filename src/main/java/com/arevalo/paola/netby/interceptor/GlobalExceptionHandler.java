package com.arevalo.paola.netby.interceptor;

import com.arevalo.paola.netby.model.ApiError;
import com.arevalo.paola.netby.util.Functions;
import com.arevalo.paola.netby.util.GtiException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

import java.net.SocketTimeoutException;


/**
 * @author Paola Arevalo <p.arevaloq@hotmail.com>
 * @version 1.0
 * @date 04/06/2024
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LogManager.getLogger(GlobalExceptionHandler.class);
    private static final String STANDARD_ERROR = "Error interno, por favor intenta de nuevo";

    /**
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler({Exception.class})
    public final ResponseEntity<ApiError> handleException(Exception ex, WebRequest request) {
        ex.printStackTrace();
        LOGGER.error("ERROR: " + ex.getClass().getSimpleName() + " [DETALLE] " + Functions.getErrorComplete(ex));
        HttpHeaders headers = new HttpHeaders();

        if (ex instanceof GtiException) {
            HttpStatus status = HttpStatus.NOT_FOUND;
            GtiException ue = (GtiException) ex;
            return handleUserException(ue, headers, status, request);
        } else if (ex instanceof SocketTimeoutException) {
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            SocketTimeoutException ue = (SocketTimeoutException) ex;
            return handleSocketTimeoutException(ue, headers, status, request);
        } else {
            HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            return handleExceptionInternal(ex, new ApiError(STANDARD_ERROR), headers, status, request);
        }
    }

    /**
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    protected ResponseEntity<ApiError> handleUserException(GtiException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, new ApiError(ex.getMessage(), ex.getCodigoError()), headers, status, request);
    }

    /**
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    protected ResponseEntity<ApiError> handleSocketTimeoutException(SocketTimeoutException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, new ApiError("No existe conexion a servicios externos."), headers, status, request);
    }

    /**
     * @param ex
     * @param body
     * @param headers
     * @param status
     * @param request
     * @return
     */
    protected ResponseEntity<ApiError> handleExceptionInternal(Exception ex, ApiError body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        return new ResponseEntity(body, headers, status);
    }

}
