package com.losTda.rentCar.service;

import com.losTda.rentCar.model.MetodoPago;
import com.losTda.rentCar.model.Usa;
import com.losTda.rentCar.model.Usuario;
import com.losTda.rentCar.requests.UsaSaveRequest;

import java.util.List;
import java.util.Optional;

public interface UsaService {
    Optional<Usa> findByUsuario(Usuario usuario);
    Optional<Usa> findByMetodoPago(MetodoPago metodoPago);
    List<Usa> findAll();
    Optional<Usa> findById(Long id);
    Optional<Usa> save(UsaSaveRequest usa);
    Optional<Usa> update(UsaSaveRequest usa);
    void deleteById(Long id);
}
