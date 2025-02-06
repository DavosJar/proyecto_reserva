package com.losTda.rentCar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Long id;

    private Integer numeroFactura;
    private LocalDate fechaEmision;
    private Double subtotal;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "id_alquiler")
    private Alquiler alquiler;
}
