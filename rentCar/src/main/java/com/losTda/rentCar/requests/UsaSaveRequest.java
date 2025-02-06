package com.losTda.rentCar.requests;

import com.losTda.rentCar.model.MetodoPago;
import com.losTda.rentCar.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsaSaveRequest {
    private Long id;

    @NotBlank(message = "El campo de usuario no puede estar vacio")
    private Usuario usuario;

    @NotBlank(message = "El campo de metodo de pago no puede estar vacio")
    private MetodoPago metodoPago;
}
