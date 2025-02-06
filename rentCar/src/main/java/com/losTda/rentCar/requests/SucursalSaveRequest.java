package com.losTda.rentCar.requests;

import com.losTda.rentCar.model.Direccion;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SucursalSaveRequest {
    private Long id;
    @NotBlank(message = "El teléfono es requerido")
    private String telefono;
    @NotBlank(message = "El nombre de la sucursal es requerido")
    private String nombreSucursal;
    @NotBlank(message = "La dirección es requerida")
    private Direccion direccion;
}
