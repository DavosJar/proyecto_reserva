package com.losTda.rentCar.service;

import com.losTda.rentCar.model.Vehiculo;
import com.losTda.rentCar.requests.vehiculo.VehiculoSaveRequest;

import java.util.List;
import java.util.Optional;


public interface VehiculoService {

    List<Vehiculo> findAll();
    Optional<Vehiculo> findByMatricula(String matricula);
    List<Vehiculo> findByMarca(String marca);
    List<Vehiculo> findByModelo(String modelo);
    List<Vehiculo> findByEstadoVehiculo(String estadoVehiculo);
    List<Vehiculo> findByMarcaAndModelo(String marca, String modelo);
    Optional<Vehiculo> save(VehiculoSaveRequest vehiculo);
    Boolean existsByMatricula(String matricula);
    Optional<Vehiculo> update(VehiculoSaveRequest vehiculo);

}