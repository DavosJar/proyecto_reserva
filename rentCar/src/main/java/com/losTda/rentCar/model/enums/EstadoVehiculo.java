package com.losTda.rentCar.model.enums;


import lombok.Getter;

@Getter
public enum EstadoVehiculo {
    DISPONIBLE("Disponible"),
    RESERVADO("Reservado"),
    RENTADO("Rentado"),
    MANTENIMIENTO("Mantenimiento"),
    INACTIVO("Inactivo");

    private final String estadoVehiculo;

    EstadoVehiculo(String estadoVehiculo){
        this.estadoVehiculo = estadoVehiculo;
    }

    public static EstadoVehiculo fromString(String value) {
        try {
            return EstadoVehiculo.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Estado de vehículo inválido: " + value);
        }
    }
}

