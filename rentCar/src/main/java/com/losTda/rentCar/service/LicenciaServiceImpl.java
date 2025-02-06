package com.losTda.rentCar.service;
import com.losTda.rentCar.model.Licencia;
import com.losTda.rentCar.repository.LicenciaRepository;
import com.losTda.rentCar.utils.LicenciaValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicenciaServiceImpl implements LicenciaService {
    private final LicenciaRepository licenciaRepository;

    public LicenciaServiceImpl(LicenciaRepository licenciaRepository) {
        this.licenciaRepository = licenciaRepository;
    }

    @Override
    public List<Licencia> findAll() {
        return licenciaRepository.findAll();
    }

    @Override
    public Optional<Licencia> findByCodigo(String codigo) {
        try{
            return licenciaRepository.findByCodigo(codigo);
        }catch (IllegalArgumentException e){
            throw new RuntimeException();
        }
    }

    @Override
    public Licencia save(Licencia licencia) {
        if (!LicenciaValidator.esLicenciaValida(licencia.getCodigo())) {
            throw new RuntimeException("El código de licencia no es válido. Debe tener el formato: una letra seguida de 9 números.");
        }

        Optional<Licencia> licenciaExistente = licenciaRepository.findByCodigo(licencia.getCodigo());
        if (licenciaExistente.isPresent()) {
            throw new RuntimeException("Ya existe una licencia con el código: " + licencia.getCodigo());
        }

        return licenciaRepository.save(licencia);
    }


    @Override
    public Optional<Licencia> update(Licencia licencia) {
        if (!LicenciaValidator.esLicenciaValida(licencia.getCodigo())) {
            throw new RuntimeException("El código de licencia no es válido. Debe tener el formato: una letra seguida de 9 números.");
        }

        Optional<Licencia> licenciaToUpdate = licenciaRepository.findById(licencia.getId());
        if (licenciaToUpdate.isPresent()) {
            Licencia existingLicencia = licenciaToUpdate.get();
            existingLicencia.setCodigo(licencia.getCodigo());
            existingLicencia.setFechaCaducidad(licencia.getFechaCaducidad());
            existingLicencia.setFechaExpedicion(licencia.getFechaExpedicion());
            Licencia updatedLicencia = licenciaRepository.save(existingLicencia);
            return Optional.of(updatedLicencia);
        }
        return Optional.empty();
    }

}
