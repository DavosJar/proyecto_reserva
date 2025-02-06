package com.losTda.rentCar.service;

import com.losTda.rentCar.model.Rol;
import com.losTda.rentCar.repository.RolRepository;
import com.losTda.rentCar.requests.RolSaveRequests;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {
    private final RolRepository rolRepository;
    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    @Override
    public Optional<Rol> save(RolSaveRequests requests) {
        Rol rolSave = new Rol();
        if(rolRepository.existsByNombreRol(requests.getNombreRol())) return Optional.empty();
        rolSave.setNombreRol(requests.getNombreRol());
        rolSave.setDescripcion(requests.getDescripcion());
        return Optional.of(rolRepository.save(rolSave));
    }

    @Override
    public Optional<Rol> save(Rol rol) {
        return Optional.of(rolRepository.save(rol));
    }

    @Override
    public Optional<Rol> update(RolSaveRequests requests) {
        Rol rolUpdate = rolRepository.findByNombreRol(requests.getNombreRol());
        if(rolUpdate == null) return Optional.empty();
        rolUpdate.setNombreRol(requests.getNombreRol());
        rolUpdate.setDescripcion(requests.getDescripcion());
        return Optional.of(rolRepository.save(rolUpdate));
    }

    @Override
    public Optional<Rol> findById(Long id) {
        return rolRepository.findById(id);
    }
}