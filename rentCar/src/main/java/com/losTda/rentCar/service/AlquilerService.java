package com.losTda.rentCar.service;

import com.losTda.rentCar.model.Alquiler;
import com.losTda.rentCar.requests.AlquilerSaveRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AlquilerService {
    void delete(Long id);
    List<Alquiler> findAll();
    List<Alquiler> findByFechaInicio(LocalDate fechaInicio);
    List<Alquiler> findByFechaDevolucion(LocalDate fechaDevolucion);
    List<Alquiler> findByCostoDia(String costoDia);
    List<Alquiler> findByEstadoAlquiler(String estadoAlquiler);
    Optional<Alquiler> findById(Long id);
    Optional<Alquiler> save(AlquilerSaveRequest alquiler);
    Optional<Alquiler> update(AlquilerSaveRequest alquiler);

}
