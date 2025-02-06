package com.losTda.rentCar.service;

import com.losTda.rentCar.model.Factura;
import com.losTda.rentCar.repository.FacturaRepository;
import com.losTda.rentCar.requests.FacturaSaveRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService {

    private final FacturaRepository facturaRepository;

    public FacturaServiceImpl(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    public List<Factura> findAll() {
        return facturaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        facturaRepository.deleteById(id);
    }

    @Override
    public Optional<Factura> save(FacturaSaveRequest factura) {
        Factura facturaToSave = new Factura();
        facturaToSave.setFechaEmision(factura.getFechaEmision());
        facturaToSave.setNumeroFactura(factura.getNumeroFactura());
        facturaToSave.setTotal(factura.getTotal());
        facturaToSave.setSubtotal(factura.getSubtotal());

        return Optional.of(facturaRepository.save(facturaToSave));
    }

    @Override
    public Optional<Factura> update(FacturaSaveRequest factura) {
        Factura facturaToUpdate = new Factura();
        facturaToUpdate.setId(factura.getId());
        facturaToUpdate.setFechaEmision(factura.getFechaEmision());
        facturaToUpdate.setNumeroFactura(factura.getNumeroFactura());
        facturaToUpdate.setTotal(factura.getTotal());
        facturaToUpdate.setSubtotal(factura.getSubtotal());

        return Optional.of(facturaRepository.save(facturaToUpdate));
    }

    @Override
    public Optional<Factura> findById(Long id) {
        return facturaRepository.findById(id);
    }

    @Override
    public List<Factura> findByFechaEmision(LocalDate fechaEmision) {
        return facturaRepository.findByFechaEmision(fechaEmision);
    }

    @Override
    public Optional<Factura> findByNumeroFactura(Integer numeroFactura) {
        return Optional.of(facturaRepository.findByNumeroFactura(numeroFactura).orElseThrow(() -> new RuntimeException("Factura no encontrada")));
    }
}
