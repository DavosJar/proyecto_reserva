package com.losTda.rentCar.service;

import com.losTda.rentCar.model.Telefono;
import com.losTda.rentCar.requests.TelefonoSaveRequest;

import java.util.List;
import java.util.Optional;

public interface TelefonoService {
    Optional<Telefono> findByDescripcion(String descripcion);
    Optional<Telefono> findById(Long id);
    List<Telefono> findAll();
    Optional<Telefono> save(TelefonoSaveRequest telefono);
    Optional<Telefono> update(TelefonoSaveRequest telefono);
    void deleteById(Long id);
}
