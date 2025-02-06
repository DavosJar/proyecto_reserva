package com.losTda.rentCar.service;

import com.losTda.rentCar.model.Accidente;
import com.losTda.rentCar.repository.AccidenteRepository;
import com.losTda.rentCar.requests.AccidenteSaveRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccidenteServiceImpl implements AccidenteService {

    private final AccidenteRepository accidenteRepository;

    public AccidenteServiceImpl(AccidenteRepository accidenteRepository) {
        this.accidenteRepository = accidenteRepository;
    }

    @Override
    public List<Accidente> findAll() {
        return accidenteRepository.findAll();
    }

    @Override
    public Optional<Accidente> findById(Long id) {
        return Optional.of(accidenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Accidente no encontrado")));
    }

    @Override
    public Optional<Accidente> save(AccidenteSaveRequest request) {
        Accidente accidente = new Accidente();
        accidente.setFecha(request.getFecha());
        accidente.setVehiculo(request.getVehiculo());

        return Optional.of(accidenteRepository.save((accidente)));
    }

    @Override
    public Optional<Accidente> update(AccidenteSaveRequest request) {
        Accidente accidente = new Accidente();
        accidente.setId(request.getId());
        accidente.setFecha(request.getFecha());
        accidente.setVehiculo(request.getVehiculo());

        return Optional.of(accidenteRepository.save(accidente));
    }

    @Override
    public void delete(Long id) {
        accidenteRepository.deleteById(id);
    }
}
