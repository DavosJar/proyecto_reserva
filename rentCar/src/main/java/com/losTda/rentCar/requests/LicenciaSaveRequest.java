package com.losTda.rentCar.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LicenciaSaveRequest {

    @NotBlank(message = "El código es obligatorio")
    private String codigo;

    @NotNull(message = "La fecha de caducidad es obligatoria")
    private LocalDate fechaCaducidad;

    @NotNull(message = "La fecha de expedición es obligatoria")
    private LocalDate fechaExpedicion;

    @NotNull(message = "El usuario es obligatorio")
    private Long idUsuario;
}
