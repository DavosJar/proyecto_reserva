package com.losTda.rentCar.service;

import com.losTda.rentCar.model.Cuenta;
import com.losTda.rentCar.requests.CuentaSaveRequest;

import java.util.List;
import java.util.Optional;

public interface CuentaService {
    List<Cuenta> findAll();
    Optional<Cuenta> findByCorreo(String correo);
    List<Cuenta> findByNombreUsuario(String nombreUsuario);
    Optional<Cuenta> findById(Long id);
    Optional<Cuenta> save(CuentaSaveRequest cuenta);
    Optional<Cuenta> update(CuentaSaveRequest cuenta);
    void delete(Long id);
}
