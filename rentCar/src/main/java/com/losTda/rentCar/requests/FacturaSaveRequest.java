package com.losTda.rentCar.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaSaveRequest {
    private Long id;

    @NotBlank(message = "El número de factura no puede estar vacío")
    private Integer numeroFactura;
    @NotBlank(message = "La fecha no puede estar vacía")
    private LocalDate fechaEmision;
    @NotBlank(message = "El subtotal no puede estar vacío")
    private Double subtotal;
    @NotBlank(message = "El total no puede estar vacío")
    private Double total;
    @NotBlank(message = "El id del alquiler no puede estar vacío")
    private Long idAlquiler;
}
