package com.losTda.rentCar.requests;

import com.losTda.rentCar.model.Direccion;
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

    @NotBlank(message = "El campo de Dirección no puede estar vacio")
    private Direccion direccion;
}