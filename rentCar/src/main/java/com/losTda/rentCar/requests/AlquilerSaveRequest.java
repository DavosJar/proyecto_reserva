package com.losTda.rentCar.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlquilerSaveRequest {
    private Long id;

    @NotBlank(message = "La fecha de inicio no puede estar vacía")
    private String fechaInicio;

    @NotBlank(message = "La fecha de devolución no puede estar vacía")
    private String fechaDevolucion;

    @NotBlank(message = "El costo por día no puede estar vacío")
    private String costoDia;

    @NotBlank(message = "El estado del alquiler no puede estar vacío")
    private String estadoAlquiler;

    @NotBlank(message = "El usuario no puede estar vacío")
    private Long usuario;
}
