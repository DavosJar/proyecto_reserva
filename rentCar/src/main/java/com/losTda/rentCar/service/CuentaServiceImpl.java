package com.losTda.rentCar.service;

import com.losTda.rentCar.model.Cuenta;
import com.losTda.rentCar.repository.CuentaRepository;
import com.losTda.rentCar.requests.CuentaSaveRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaServiceImpl implements CuentaService {

    private final CuentaRepository cuentaRepository;

    public CuentaServiceImpl(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public Optional<Cuenta> findByCorreo(String correo) {
        try {
            return cuentaRepository.findByCorreo(correo);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("No se encontró la cuenta con el correo: " + correo);
        }
    }

    @Override
    public List<Cuenta> findByNombreUsuario(String nombreUsuario) {
        try {
            return cuentaRepository.findByNombreUsuario(nombreUsuario);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("No se encontraron cuentas con el nombre de usuario: " + nombreUsuario);
        }
    }

    @Override
    public List<Cuenta> findAll() {
        return cuentaRepository.findAll();
    }

    @Override
    public Optional<Cuenta> findById(Long id) {
        return Optional.of(cuentaRepository.findById(id).orElseThrow(() -> new RuntimeException("Cuenta no encontrada")));
    }

    @Override
    public Optional<Cuenta> save(CuentaSaveRequest cuenta) {
        Cuenta cuentaToSave = new Cuenta();
        cuentaToSave.setNombreUsuario(cuenta.getNombreUsuario());
        cuentaToSave.setCorreo(cuenta.getCorreo());
        return Optional.of(cuentaRepository.save(cuentaToSave));
    }

    @Override
    public Optional<Cuenta> update(CuentaSaveRequest cuenta) {
        Cuenta cuentaToUpdate = new Cuenta();
        cuentaToUpdate.setId(cuenta.getId());
        cuentaToUpdate.setNombreUsuario(cuenta.getNombreUsuario());
        cuentaToUpdate.setCorreo(cuenta.getCorreo());
        return Optional.of(cuentaRepository.save(cuentaToUpdate));
    }

    @Override
    public void delete(Long id) {
        cuentaRepository.deleteById(id);
    }
}
