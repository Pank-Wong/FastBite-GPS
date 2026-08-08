package cl.iplacex.logistica_gps.controller;

import cl.iplacex.logistica_gps.model.Vehiculo;
import cl.iplacex.logistica_gps.repository.VehiculoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoController(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    // 1. Método para LISTAR todos los vehículos (GET)
    @GetMapping
    public List<Vehiculo> obtenerVehiculos() {
        return vehiculoRepository.findAll();
    }

    // 2. Método para REGISTRAR un nuevo vehículo (POST)
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarVehiculo(@RequestBody Vehiculo nuevoVehiculo) {
        
        // Regla de negocio: La patente no se puede repetir
        if (vehiculoRepository.findByPatente(nuevoVehiculo.getPatente()).isPresent()) {
            return ResponseEntity.badRequest().body("Error: La patente ya está registrada en el sistema.");
        }

        // Regla de negocio: El IMEI no se puede repetir
        if (vehiculoRepository.findByImei(nuevoVehiculo.getImei()).isPresent()) {
            return ResponseEntity.badRequest().body("Error: Este IMEI de GPS ya está asignado a otro vehículo.");
        }

        // Guardar el vehículo en la base de datos
        vehiculoRepository.save(nuevoVehiculo);
        return ResponseEntity.ok("Vehículo registrado con éxito.");
    }
}
