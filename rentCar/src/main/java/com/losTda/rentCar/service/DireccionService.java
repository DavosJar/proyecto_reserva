package com.losTda.rentCar.service;

import com.losTda.rentCar.model.Direccion;
import com.losTda.rentCar.requests.DireccionSaveRequest;

import java.util.List;
import java.util.Optional;

public interface DireccionService {
    List<Direccion> findAll();
    Direccion findById(Long id);
    Optional<Direccion> save(DireccionSaveRequest direccion);
    Optional<Direccion> update(DireccionSaveRequest direccion);
    void delete(Long id);
    List<Direccion> findByCalle(String calle);
    List<Direccion> findByNumero(String numero);
    List<Direccion> findByCiudad(String ciudad);

}
