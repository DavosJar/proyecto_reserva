package com.losTda.rentCar.service;

import com.losTda.rentCar.model.Sucursal;
import com.losTda.rentCar.repository.SucursalRepository;
import com.losTda.rentCar.requests.SucursalSaveRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalServiceImpl implements SucursalService{

    private final SucursalRepository sucursalRepository;

    public SucursalServiceImpl(SucursalRepository sucursalRepository){
        this.sucursalRepository = sucursalRepository;
    }

    @Override
    public List<Sucursal> findAll(){
        return sucursalRepository.findAll();
    }

    @Override
    public Optional<Sucursal> update(SucursalSaveRequest request){
        Sucursal sucursalActualizada = new Sucursal();
        sucursalActualizada.setId(request.getId());
        sucursalActualizada.setNombreSucursal(request.getNombreSucursal());
        sucursalActualizada.setTelefono(request.getTelefono());
        sucursalActualizada.setDireccion(request.getDireccion());

        return Optional.of(sucursalRepository.save(sucursalActualizada));

    }

    @Override
    public List<Sucursal> findByNombreSucursal(String nombreSucursal){
        return sucursalRepository.findByNombreSucursal(nombreSucursal);
    }

    @Override
    public Optional<Sucursal> findByTelefono(String telefono){
        return sucursalRepository.findByTelefono(telefono);
    }

    @Override
    public Optional<Sucursal> findById(Long id){
        return sucursalRepository.findById(id);
    }

    @Override
    public Optional<Sucursal> save(SucursalSaveRequest request){
        Sucursal sucursalToSave = new Sucursal();
        sucursalToSave.setNombreSucursal(request.getNombreSucursal());
        sucursalToSave.setTelefono(request.getTelefono());
        sucursalToSave.setDireccion(request.getDireccion());

        return Optional.of(sucursalRepository.save(sucursalToSave));
    }

    @Override
    public void deleteById(Long id){
        sucursalRepository.deleteById(id);
    }
}
