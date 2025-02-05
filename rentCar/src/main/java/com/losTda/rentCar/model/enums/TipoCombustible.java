package com.losTda.rentCar.model.enums;

import lombok.Getter;

@Getter
public enum TipoCombustible {

    GASOLINA("Gasolina"),
    DIESEL("Diesel"),
    HIBRIDO("Hibrido"),
    ELECTRICO("Electrico");

    private final String tipoCombustible;

    TipoCombustible(String tipoCombustible){
        this.tipoCombustible = tipoCombustible;
    }

}

