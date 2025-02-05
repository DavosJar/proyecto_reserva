package com.losTda.rentCar.model.enums;

import lombok.Getter;

@Getter
public enum TipoVehiculo {
    SEDAN("Sedan"),
    SUV("SUV"),
    PICKUP("Pickup"),
    HATCHBACK("Hatchback"),
    CONVERTIBLE("Convertible");

    private final String tipoVehiculo;

    TipoVehiculo(String tipoVehiculo){
        this.tipoVehiculo = tipoVehiculo;
    }

    public static TipoVehiculo fromString(String value) {
        try {
            return TipoVehiculo.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Tipo de vehículo inválido: " + value);
        }
    }
}
