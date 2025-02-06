package com.losTda.rentCar.service;

import com.losTda.rentCar.model.Telefono;
import com.losTda.rentCar.repository.TelefonoRepository;
import com.losTda.rentCar.requests.TelefonoSaveRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelefonoServiceImpl implements TelefonoService {

    private final TelefonoRepository telefonoRepository;

    public TelefonoServiceImpl(TelefonoRepository telefonoRepository) {
        this.telefonoRepository = telefonoRepository;
    }

    @Override
    public Optional<Telefono> findByDescripcion(String descripcion) {
        return telefonoRepository.findByDescripcion(descripcion);
    }

    @Override
    public Optional<Telefono> findById(Long id) {
        return telefonoRepository.findById(id);
    }

    @Override
    public Optional<Telefono> save(TelefonoSaveRequest telefono) {
        Telefono telefonoToSave = new Telefono();
        telefonoToSave.setDescripcion(telefono.getDescripcion());
        return Optional.of(telefonoRepository.save(telefonoToSave));
    }

    @Override
    public Optional<Telefono> update(TelefonoSaveRequest telefono) {
        Telefono telefonoToUpdate = new Telefono();
        telefonoToUpdate.setId(telefono.getId());
        telefonoToUpdate.setDescripcion(telefono.getDescripcion());

        return Optional.of(telefonoRepository.save(telefonoToUpdate));
    }

    @Override
    public void deleteById(Long id) {
        telefonoRepository.deleteById(id);
    }

    @Override
    public List<Telefono> findAll() {
        return telefonoRepository.findAll();
    }


}
