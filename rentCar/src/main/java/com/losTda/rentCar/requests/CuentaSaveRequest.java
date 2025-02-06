package com.losTda.rentCar.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaSaveRequest {
    private Long id;

    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    private String nombreUsuario;

    @NotBlank(message = "El correo no puede estar vacío")
    private String correo;
}
