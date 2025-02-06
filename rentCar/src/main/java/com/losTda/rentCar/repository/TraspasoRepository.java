package com.losTda.rentCar.repository;

import com.losTda.rentCar.model.Traspaso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TraspasoRepository extends JpaRepository<Traspaso, Long> {
    List<Traspaso> findAll();
    Optional<Traspaso> findByResponsable(String responsable);
    Optional<Traspaso> findByTipo(String tipo);
}
