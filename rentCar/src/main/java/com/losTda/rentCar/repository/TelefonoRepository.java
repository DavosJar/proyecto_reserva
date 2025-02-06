package com.losTda.rentCar.repository;

import com.losTda.rentCar.model.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TelefonoRepository extends JpaRepository<Telefono, Long> {
    Optional<Telefono> findByDescripcion(String descripcion);
}
