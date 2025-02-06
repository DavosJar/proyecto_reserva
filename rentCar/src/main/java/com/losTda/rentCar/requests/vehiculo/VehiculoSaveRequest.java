package com.losTda.rentCar.requests.vehiculo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoSaveRequest {


    @NotBlank(message = "La marca es obligatoria")
    private String marca;

    @NotBlank(message = "El modelo es obligatorio")
    private String modelo;

    @NotBlank(message = "La matrícula es obligatoria")
    private String matricula;

    @NotNull(message = "El año de fabricación es obligatorio")
    @Min(value = 1900, message = "El año de fabricación no puede ser menor a 1900")
    @Max(value = 2100, message = "El año de fabricación no puede ser mayor a 2100")
    private Integer yearFabricacion;

    @NotNull(message = "La capacidad de pasajeros es obligatoria")
    @Positive(message = "La capacidad de pasajeros debe ser un número positivo")
    @Min(value = 1, message = "La capacidad de pasajeros no puede ser menor a 1")
    @Max(value = 10, message = "La capacidad de pasajeros no puede ser mayor a 100")
    private Integer capacidadPersonas;

    @NotNull(message = "El estado del vehículo es obligatorio")
    private String estadoVehiculo;


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getYearFabricacion() {
        return yearFabricacion;
    }

    public void setYearFabricacion(Integer yearFabricacion) {
        this.yearFabricacion = yearFabricacion;
    }

    public Integer getCapacidadPersonas() {
        return capacidadPersonas;
    }

    public void setCapacidadPersonas(Integer capacidadPersonas) {
        this.capacidadPersonas = capacidadPersonas;
    }

    public String getEstadoVehiculo() {
        return estadoVehiculo;
    }

    public void setEstadoVehiculo(String estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }
}
