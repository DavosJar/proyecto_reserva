package com.losTda.rentCar.requests;

import com.losTda.rentCar.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteSaveRequest {

    private Usuario usuario;
    @NotBlank(message = "El campo de habilitado no puede estar vacio")
    private String estaHabilitado = "10";
}
