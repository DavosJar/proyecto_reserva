package com.losTda.rentCar.service;

import com.losTda.rentCar.model.UsuarioInterno;
import com.losTda.rentCar.requests.UsuarioInternoSaveRequest;

import java.util.List;
import java.util.Optional;

public interface UsuarioInternoService {
    Optional<UsuarioInterno> save(UsuarioInternoSaveRequest request);
    List<UsuarioInterno> findByDepartamento(String departamento);
    List<UsuarioInterno> findAll();
    List<UsuarioInterno> findByPuesto(String puesto);
    Optional<UsuarioInterno> findById(Long id);
    void deleteById(Long id);
}