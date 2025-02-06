package com.losTda.rentCar.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelefonoSaveRequest {
    private Long id;

    @NotBlank(message = "La descripcion no puede estar vacia")
    private String descripcion;

    /*@NotBlank(message = "usuario no puede estar vacio")
    private Usuario usuario;*/
}
