package com.losTda.rentCar.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseBuilder {

    private final Map<String, Object> response;
    private HttpStatus status;

    public ResponseBuilder() {
        this.response = new HashMap<>();
    }

    public ResponseBuilder status(HttpStatus status) {
        this.status = status;
        return this;
    }

    public ResponseBuilder idObject(Object idObject) {
        if (idObject != null) {
            response.put("idObject", idObject);
        }
        return this;
    }

    public ResponseBuilder data(Object data) {
        if (data != null) {
            response.put("data", data);
        }
        return this;
    }

    public ResponseBuilder message(String message) {
        if (message != null) {
            response.put("message", message);
        }
        return this;
    }

    public ResponseBuilder info(String info) {
        if (info != null) {
            response.put("info", info);
        }
        return this;
    }

    public ResponseEntity<Map<String, Object>> build() {
        response.put("status", status.value());
        return ResponseEntity.status(status).body(response);
    }

    // Métodos rápidos para respuestas comunes
    public static ResponseEntity<Map<String, Object>> success(Object data, String message, Object idObject) {
        return new ResponseBuilder()
                .status(HttpStatus.OK)
                .idObject(idObject)
                .data(data)
                .message(message)
                .info("Operación exitosa")
                .build();
    }

    public static ResponseEntity<Map<String, Object>> error(HttpStatus status, String message, Object idObject) {
        return new ResponseBuilder()
                .status(status)
                .idObject(idObject)
                .message(message)
                .info("Error en la operación")
                .build();
    }
}
