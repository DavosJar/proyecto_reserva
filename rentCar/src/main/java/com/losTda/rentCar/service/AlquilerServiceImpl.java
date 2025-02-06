package com.losTda.rentCar.service;

import com.losTda.rentCar.model.Alquiler;
import com.losTda.rentCar.repository.AlquilerRepository;
import com.losTda.rentCar.requests.AlquilerSaveRequest;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AlquilerServiceImpl implements AlquilerService {

    private final AlquilerRepository alquilerRepository;

    public AlquilerServiceImpl(AlquilerRepository alquilerRepository) {
        this.alquilerRepository = alquilerRepository;
    }

    @Override
    public List<Alquiler> findAll() {
        return alquilerRepository.findAll();
    }

    @Override
    public List<Alquiler> findByFechaInicio(LocalDate fechaInicio) {
        try {
            return alquilerRepository.findByFechaInicio(fechaInicio);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("No se encontraron alquileres con la fecha de inicio: " + fechaInicio);
        }
    }

    @Override
    public List<Alquiler> findByFechaDevolucion(LocalDate fechaDevolucion) {
        try {
            return alquilerRepository.findByFechaDevolucion(fechaDevolucion);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("No se encontraron alquileres con la fecha de devolución: " + fechaDevolucion);
        }
    }

    @Override
    public List<Alquiler> findByCostoDia(String costoDia) {
        try {
            return alquilerRepository.findByCostoDia(costoDia);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("No se encontraron alquileres con el costo por día: " + costoDia);
        }
    }

    @Override
    public List<Alquiler> findByEstadoAlquiler(String estadoAlquiler) {
        try {
            return alquilerRepository.findByEstadoAlquiler(estadoAlquiler);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("No se encontraron alquileres con el estado de alquiler: " + estadoAlquiler);
        }
    }

    @Override
    public void delete(Long id) {
        alquilerRepository.deleteById(id);
    }

    @Override
    public Optional<Alquiler> findById(Long id) {
        return Optional.of(alquilerRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró el alquiler con el id: " + id)));
    }

    @Override
    public Optional<Alquiler> save(AlquilerSaveRequest alquiler) {
        Alquiler alquilerToSave = new Alquiler();
        alquilerToSave.setFechaInicio(LocalDate.parse(alquiler.getFechaInicio()));
        alquilerToSave.setFechaDevolucion(LocalDate.parse(alquiler.getFechaDevolucion()));
        alquilerToSave.setCostoDia(alquiler.getCostoDia());
        alquilerToSave.setEstadoAlquiler(alquiler.getEstadoAlquiler());
        alquilerToSave.setUsuario(alquiler.getUsuario());
        return Optional.of(alquilerRepository.save(alquilerToSave));
    }

    @Override
    public Optional<Alquiler> update(AlquilerSaveRequest alquilerSaveRequest) {
        Alquiler alquilerToUpdate = new Alquiler();
        alquilerToUpdate.setId(alquilerSaveRequest.getId());
        alquilerToUpdate.setFechaInicio(LocalDate.parse(alquilerSaveRequest.getFechaInicio()));
        alquilerToUpdate.setFechaDevolucion(LocalDate.parse(alquilerSaveRequest.getFechaDevolucion()));
        alquilerToUpdate.setCostoDia(alquilerSaveRequest.getCostoDia());
        alquilerToUpdate.setEstadoAlquiler(alquilerSaveRequest.getEstadoAlquiler());
        alquilerToUpdate.setUsuario(alquilerSaveRequest.getUsuario());

        return Optional.of(alquilerRepository.save(alquilerToUpdate));
    }
}
