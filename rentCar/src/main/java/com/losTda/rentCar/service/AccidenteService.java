package com.losTda.rentCar.service;

import com.losTda.rentCar.model.Accidente;
import com.losTda.rentCar.requests.AccidenteSaveRequest;

import java.util.List;
import java.util.Optional;

public interface AccidenteService {
    Optional<Accidente> save(AccidenteSaveRequest request);
    void delete(Long id);
    List<Accidente> findAll();
    Optional<Accidente> findById(Long id);
    Optional<Accidente> update(AccidenteSaveRequest request);
}
