package com.losTda.rentCar.service;

import com.losTda.rentCar.model.Traspaso;
import com.losTda.rentCar.repository.TraspasoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraspasoServiceImpl implements TraspasoService {
    private final TraspasoRepository traspasoRepository;

    public TraspasoServiceImpl(TraspasoRepository traspasoRepository) {
        this.traspasoRepository = traspasoRepository;
    }

    @Override
    public List<Traspaso> findAll() {
        return traspasoRepository.findAll();
    }

    @Override
    public Optional<Traspaso> findByResponsable(String responsable) {
        return traspasoRepository.findByResponsable(responsable);
    }

    @Override
    public Optional<Traspaso> findByTipo(String tipo) {
        return traspasoRepository.findByTipo(tipo);
    }

    @Override
    public Traspaso save(Traspaso traspaso) {
        return traspasoRepository.save(traspaso);
    }

    @Override
    public Optional<Traspaso> update(Traspaso traspaso) {
        Optional<Traspaso> traspasoExistente = traspasoRepository.findById(traspaso.getId());
        if (traspasoExistente.isPresent()) {
            Traspaso traspasoActualizado = traspasoExistente.get();
            traspasoActualizado.setTipo(traspaso.getTipo());
            traspasoActualizado.setResponsable(traspaso.getResponsable());
            traspasoActualizado.setFecha(traspaso.getFecha());
            return Optional.of(traspasoRepository.save(traspasoActualizado));
        }
        return Optional.empty();
    }
}
