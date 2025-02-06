package com.losTda.rentCar.service;

import com.losTda.rentCar.model.Sucursal;
import com.losTda.rentCar.requests.SucursalSaveRequest;

import java.util.List;
import java.util.Optional;

public interface SucursalService {
    List<Sucursal> findByNombreSucursal(String nombreSucursal);
    List<Sucursal> findAll();
    Optional<Sucursal> findByTelefono(String telefono);
    Optional<Sucursal> save(SucursalSaveRequest request);
    Optional<Sucursal> findById(Long id);
    void deleteById(Long id);
}
