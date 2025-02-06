package com.losTda.rentCar.repository;

import com.losTda.rentCar.model.Licencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LicenciaRepository extends JpaRepository<Licencia, Long> {
    Optional<Licencia> findByCodigo(String codigo);
}
