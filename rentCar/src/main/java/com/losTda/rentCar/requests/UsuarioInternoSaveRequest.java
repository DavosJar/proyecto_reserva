package com.losTda.rentCar.requests;

import com.losTda.rentCar.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioInternoSaveRequest {
    private Long id;
    @NotBlank(message = "El idUsuario es obligatorio")
    private Long idUsuario;
    @NotBlank(message = "El departamento es obligatorio")
    private String departamento;
    @NotBlank(message = "El puesto es obligatorio")
    private String puesto;
    @NotBlank(message = "El usuario es obligatorio")
    private Usuario usuario;
}
