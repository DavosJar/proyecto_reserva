package com.losTda.rentCar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "alquiler")
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alquiler")
    private Long id;

    private String estadoAlquiler = "disponible";
    private LocalDate fechaInicio;
    private LocalDate fechaDevolucion;
    private String costoDia;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
