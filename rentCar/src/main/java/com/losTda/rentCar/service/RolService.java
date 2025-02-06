package com.losTda.rentCar.service;

import com.losTda.rentCar.model.Rol;
import com.losTda.rentCar.requests.RolSaveRequests;

import java.util.List;
import java.util.Optional;

public interface RolService {
    List<Rol> findAll();
    Optional<Rol> save(RolSaveRequests rolSaveRequests);
    Optional<Rol> save(Rol rol);
    Optional<Rol> update(RolSaveRequests rolSaveRequests);
    Optional<Rol> findById(Long id);
}