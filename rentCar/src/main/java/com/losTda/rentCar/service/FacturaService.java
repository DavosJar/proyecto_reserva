package com.losTda.rentCar.service;

import com.losTda.rentCar.model.Factura;
import com.losTda.rentCar.requests.FacturaSaveRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FacturaService {
    void delete(Long id);
    List<Factura> findAll();
    List<Factura> findByFechaEmision(LocalDate fechaFactura);
    Optional<Factura> findByNumeroFactura(Integer numeroFactura);
    Optional<Factura> findById(Long id);
    Optional<Factura> save(FacturaSaveRequest factura);
    Optional<Factura> update(FacturaSaveRequest factura);
}
