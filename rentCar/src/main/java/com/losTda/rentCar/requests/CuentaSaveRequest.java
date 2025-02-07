package com.losTda.rentCar.requests;

import com.losTda.rentCar.model.Rol;
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

    @NotBlank(message = "El Rol no puede estar vacío")
    private Rol rol;

    @NotBlank(message = "La contraseña no puede estar vacía")
    private String contrasena;

    @NotBlank(message = "El Usuario no puede estar vacío")
    private Long usuario;
}
