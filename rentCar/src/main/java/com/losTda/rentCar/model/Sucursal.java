package com.losTda.rentCar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "sucursal")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private Long id;

    private String telefono;
    private String nombreSucursal;

    @OneToOne
    @JoinColumn(name = "id_direccion")
    private Direccion direccion;

}
