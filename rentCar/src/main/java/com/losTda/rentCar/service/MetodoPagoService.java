package com.losTda.rentCar.service;

import com.losTda.rentCar.model.MetodoPago;
import com.losTda.rentCar.requests.MetodoPagoSaveRequest;

import java.util.List;
import java.util.Optional;

public interface MetodoPagoService {
    List<MetodoPago> findAll();
    Optional<MetodoPago> findByTipo(String tipo);
    MetodoPago save(MetodoPagoSaveRequest metodoPago);
    Optional<MetodoPago> update(MetodoPagoSaveRequest metodoPago);
}
