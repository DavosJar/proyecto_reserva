package com.losTda.rentCar.service;

import com.losTda.rentCar.model.MetodoPago;
import com.losTda.rentCar.repository.MetodoPagoRepository;
import com.losTda.rentCar.requests.MetodoPagoSaveRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService{

    private final MetodoPagoRepository metodoPagoRepository;

    public MetodoPagoServiceImpl(MetodoPagoRepository metodoPagoRepository) {
        this.metodoPagoRepository = metodoPagoRepository;
    }

    @Override
    public List<MetodoPago> findAll() {
        return metodoPagoRepository.findAll();
    }

    @Override
    public Optional<MetodoPago> findByTipo(String tipo) {
        return metodoPagoRepository.findByTipo(tipo);
    }

    @Override
    public MetodoPago save(MetodoPagoSaveRequest request){
        MetodoPago metodoPagoToSave = new MetodoPago();
        metodoPagoToSave.setTipo(request.getTipo());
        return metodoPagoRepository.save(metodoPagoToSave);
    }

    @Override
    public Optional<MetodoPago> update(MetodoPagoSaveRequest metodoPago) {
        Optional<MetodoPago> metodoPagoToUpdate = metodoPagoRepository.findById(metodoPago.getId());
        if (metodoPagoToUpdate.isPresent()) {
            MetodoPago existingMetodoPago = metodoPagoToUpdate.get();
            existingMetodoPago.setTipo(metodoPago.getTipo());
            MetodoPago updatedMetodoPago = metodoPagoRepository.save(existingMetodoPago);
            return Optional.of(updatedMetodoPago);
        }
        return Optional.empty();
    }

}
