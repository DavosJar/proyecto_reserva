package com.losTda.rentCar.service;

import com.losTda.rentCar.model.Licencia;

import java.util.List;
import java.util.Optional;

public interface LicenciaService {
    List<Licencia> findAll();
    Optional<Licencia> findByCodigo(String codigo);
    Licencia save(Licencia licencia);
    Optional<Licencia> update(Licencia licencia);
}
