package com.losTda.rentCar.model.enums;

import lombok.Getter;

@Getter
public enum TipoTransmision {
    AUTOMATICA("Automatica"),
    MANUAL("Manual");

    private final String tipoTransmision;

    TipoTransmision(String tipoTransmision){
        this.tipoTransmision = tipoTransmision;
    }

}
