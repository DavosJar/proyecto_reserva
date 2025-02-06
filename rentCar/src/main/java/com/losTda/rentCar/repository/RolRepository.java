package com.losTda.rentCar.repository;

import com.losTda.rentCar.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long> {

    List<Rol> findAllByNombreRol(String nombre);
    Rol findByNombreRol(String nombre);
    List<Rol> findAll();
    Boolean existsByNombreRol(String nombre);

}
