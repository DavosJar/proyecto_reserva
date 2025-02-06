package com.losTda.rentCar.requests;

import jakarta.validation.constraints.NotBlank;

public class RolSaveRequests {
    @NotBlank(message = "El nombre es obligatoria")
    private String nombreRol;
    @NotBlank(message = "La descripcion es obligatoria")
    private String descripcion;

    public String getNombreRol() {
        return nombreRol;
    }
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
