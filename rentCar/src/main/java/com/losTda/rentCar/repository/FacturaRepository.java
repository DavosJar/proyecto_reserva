package com.losTda.rentCar.repository;

import com.losTda.rentCar.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
    Optional<Factura> findByNumeroFactura(Integer numeroFactura);
    List<Factura> findByFechaEmision(LocalDate fechaEmision);
}
