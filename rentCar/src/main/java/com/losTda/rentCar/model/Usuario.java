package com.losTda.rentCar.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "dni", nullable = false, unique = true)
    @NotBlank(message = "El DNI es obligatorio")
    private String dni;

    @Column(name = "nombres", nullable = false)
    @NotBlank(message = "Los nombres son obligatorios")
    private String nombres;

    @ManyToOne
    @JoinColumn(name = "id_direccion", nullable = false)
    private Direccion direccion;
}