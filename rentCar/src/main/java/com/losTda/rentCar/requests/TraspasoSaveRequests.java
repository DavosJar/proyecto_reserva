package com.losTda.rentCar.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TraspasoSaveRequests {
    @NotBlank(message = "tipo")
    private String tipo;

    @NotBlank(message = "responsable")
    private String responsable;

    @NotBlank(message = "fecha")
    private String fecha;

}
