package cl.iplacex.logistica_gps.repository;

import cl.iplacex.logistica_gps.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    // Métodos personalizados para evitar duplicados
    Optional<Vehiculo> findByPatente(String patente);
    Optional<Vehiculo> findByImei(String imei);
}
