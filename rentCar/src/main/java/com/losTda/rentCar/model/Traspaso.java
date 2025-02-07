package com.losTda.rentCar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "traspaso")
public class Traspaso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_licencia")
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "responsable")
    private String responsable;

    @Column(name = "fecha")
    private LocalDate fecha;

}
