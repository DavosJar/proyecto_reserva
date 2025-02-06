package com.losTda.rentCar.service;

import com.losTda.rentCar.model.Traspaso;

import java.util.List;
import java.util.Optional;

public interface TraspasoService {
    List<Traspaso> findAll();
    Optional<Traspaso> findByResponsable(String responsable);
    Optional<Traspaso> findByTipo(String tipo);
    Traspaso save(Traspaso traspaso);
    Optional<Traspaso> update(Traspaso traspaso);
}
