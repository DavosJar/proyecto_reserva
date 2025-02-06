package com.losTda.rentCar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.tags.MessageTag;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cuenta")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuenta")
    private Long id;

    private String nombreUsuario;
    private String correo;
    private String contrasena;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;


    /*@OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario; */

}
