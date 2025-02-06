package com.losTda.rentCar.service;

import com.losTda.rentCar.model.MetodoPago;
import com.losTda.rentCar.model.Usa;
import com.losTda.rentCar.model.Usuario;
import com.losTda.rentCar.repository.UsaRepository;
import com.losTda.rentCar.requests.UsaSaveRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsaServiceImpl implements UsaService {

    private final UsaRepository usaRepository;

    public UsaServiceImpl(UsaRepository usaRepository) {
        this.usaRepository = usaRepository;
    }

    @Override
    public List<Usa> findAll() {
        return usaRepository.findAll();
    }

    @Override
    public Optional<Usa> findByUsuario(Usuario usuario) {
        return usaRepository.findByUsuario(usuario);
    }

    @Override
    public Optional<Usa> findById(Long id) {
        return usaRepository.findById(id);
    }

    @Override
    public Optional<Usa> save(UsaSaveRequest usa) {
        Usa usaToSave = new Usa();
        usaToSave.setUsuario(usa.getUsuario());
        usaToSave.setMetodoPago(usa.getMetodoPago());

        return Optional.of(usaRepository.save(usaToSave));
    }

    @Override
    public Optional<Usa> update(UsaSaveRequest usa) {
        Usa usaToUpdate = new Usa();
        usaToUpdate.setId(usa.getId());
        usaToUpdate.setUsuario(usa.getUsuario());
        usaToUpdate.setMetodoPago(usa.getMetodoPago());

        return Optional.of(usaRepository.save(usaToUpdate));
    }

    @Override
    public void deleteById(Long id) {
        usaRepository.deleteById(id);
    }

    @Override
    public Optional<Usa> findByMetodoPago(MetodoPago metodoPago) {
        return usaRepository.findByMetodoPago(metodoPago);
    }

}
