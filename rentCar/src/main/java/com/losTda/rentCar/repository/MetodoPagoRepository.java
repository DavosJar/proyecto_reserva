package com.losTda.rentCar.repository;

import com.losTda.rentCar.model.MetodoPago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Long> {
    List<MetodoPago> findByTipo(String tipo);
}
