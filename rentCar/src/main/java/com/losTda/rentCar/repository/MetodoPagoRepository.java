package com.losTda.rentCar.repository;

import com.losTda.rentCar.model.MetodoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Long> {
    Optional<MetodoPago> findByTipo(String tipo); // Cambiado para devolver un Optional
}