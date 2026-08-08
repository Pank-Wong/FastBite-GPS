package cl.iplacex.logistica_gps.repository;

import cl.iplacex.logistica_gps.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
