package com.losTda.rentCar.service;

import com.losTda.rentCar.model.Direccion;
import com.losTda.rentCar.repository.DireccionRepository;
import com.losTda.rentCar.requests.DireccionSaveRequest;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class DireccionServiceImpl implements DireccionService {

    public final DireccionRepository direccionRepository;

    public DireccionServiceImpl(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }

    public List<Direccion> findAll() {
        return direccionRepository.findAll();
    }

    public Direccion findById(Long id) {
        return direccionRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró la dirección con el id: " + id));
    }


    public Optional<Direccion> save(DireccionSaveRequest direccion) {
        Direccion direccionToSave = new Direccion();
        direccionToSave.setCalle(direccion.getCalle());
        direccionToSave.setNumero(direccion.getNumero());
        direccionToSave.setCiudad(direccion.getCiudad());

        return Optional.of(direccionRepository.save(direccionToSave));
    }

    public Optional<Direccion> update(DireccionSaveRequest direccion) {
        Optional<Direccion> direccionToUpdate = direccionRepository.findById(direccion.getId());
        if (direccionToUpdate.isPresent()) {
            direccionToUpdate.get().setId(direccion.getId());
            direccionToUpdate.get().setCalle(direccion.getCalle());
            direccionToUpdate.get().setNumero(direccion.getNumero());
            direccionToUpdate.get().setCiudad(direccion.getCiudad());
            return Optional.of(direccionRepository.save(direccionToUpdate.get()));
        } else {
            throw new RuntimeException("No se encontró la dirección con el id: " + direccion.getId());
        }
    }

    public void delete(Long id) {
        direccionRepository.deleteById(id);
    }

    public List<Direccion> findByCalle(String calle) {
        try {
            return direccionRepository.findByCalle(calle);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("No se encontraron direcciones con la calle: " + calle);
        }
    }

    public List<Direccion> findByNumero(String numero) {
        try {
            return direccionRepository.findByNumero(numero);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("No se encontraron direcciones con el número: " + numero);
        }
    }

    public List<Direccion> findByCiudad(String ciudad) {
        try {
            return direccionRepository.findByCiudad(ciudad);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("No se encontraron direcciones con la ciudad: " + ciudad);
        }
    }

}
