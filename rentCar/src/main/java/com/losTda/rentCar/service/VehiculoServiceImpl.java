    package com.losTda.rentCar.service;

    import com.losTda.rentCar.model.Vehiculo;

    import com.losTda.rentCar.repository.VehiculoRepository;
    import com.losTda.rentCar.requests.vehiculo.VehiculoSaveRequest;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Optional;


    @Service
    public class VehiculoServiceImpl implements VehiculoService {

        private final VehiculoRepository vehiculoRepository;

        public VehiculoServiceImpl(VehiculoRepository vehiculoRepository) {
            this.vehiculoRepository = vehiculoRepository;
        }

        @Override
        public List<Vehiculo> findAll() {
            return vehiculoRepository.findAll();
        }

        public  Optional<Vehiculo> findByMatricula(String matricula) {
            return vehiculoRepository.findByMatricula(matricula);
        }

        @Override
        public List<Vehiculo> findByMarca(String marca) {
            try {
                return vehiculoRepository.findByMarca(marca);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("No se encontraron vehículos con la marca: " + marca);
            }
        }

        @Override
        public List<Vehiculo> findByModelo(String modelo) {
            try {
                return vehiculoRepository.findByModelo(modelo);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("No se encontraron vehículos con el modelo: " + modelo);
            }
        }

    @Override
    public Optional<Vehiculo> save(VehiculoSaveRequest request) {
        Vehiculo vehiculoToSave = new Vehiculo();
        vehiculoToSave.setMarca(request.getMarca());
        vehiculoToSave.setModelo(request.getModelo());
        vehiculoToSave.setMatricula(request.getMatricula());
        vehiculoToSave.setEstadoVehiculo(request.getEstadoVehiculo());
        vehiculoToSave.setYearFabricacion(request.getYearFabricacion());
        vehiculoToSave.setCapacidadPersonas(request.getCapacidadPersonas());

        return Optional.of(vehiculoRepository.save(vehiculoToSave));
    }

        @Override
        public List<Vehiculo> findByEstadoVehiculo(String estado) {
            try {
                return vehiculoRepository.findByEstadoVehiculo(estado);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("No se encontraron vehículos con el estado: " + estado);
            }
        }

        @Override
        public List<Vehiculo> findByMarcaAndModelo(String marca, String modelo) {
            try {
                return vehiculoRepository.findByMarcaAndModelo(marca, modelo);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("No se encontraron vehículos con la marca: " + marca + " y modelo: " + modelo);
            }
        }

    @Override
    public Optional<Vehiculo> update(VehiculoSaveRequest vehiculo) {
        Optional<Vehiculo> vehiculoToUpdate = vehiculoRepository.findByMatricula(vehiculo.getMatricula());
        if (vehiculoToUpdate.isPresent()) {
            Vehiculo existingVehiculo = vehiculoToUpdate.get();
            existingVehiculo.setMarca(vehiculo.getMarca());
            existingVehiculo.setModelo(vehiculo.getModelo());
            existingVehiculo.setEstadoVehiculo(vehiculo.getEstadoVehiculo());
            existingVehiculo.setYearFabricacion(vehiculo.getYearFabricacion());
            existingVehiculo.setCapacidadPersonas(vehiculo.getCapacidadPersonas());


            return Optional.of(vehiculoRepository.save(existingVehiculo));
        }
        return Optional.empty();
    }


    @Override
    public Optional<Vehiculo> findById(Long id) {
        return vehiculoRepository.findById(id);
    }
    @Override
    public Boolean existsByMatricula(String matricula) {
        return vehiculoRepository.existsByMatricula(matricula);
    }
}