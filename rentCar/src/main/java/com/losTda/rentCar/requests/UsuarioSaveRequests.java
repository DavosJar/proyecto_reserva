package com.losTda.rentCar.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioSaveRequests {
    private Long id;

    @NotBlank(message = "El dni es obligatorio")
    private String dni;

    @NotBlank(message = "Los nombres son obligatorios")
    private String nombres;
}