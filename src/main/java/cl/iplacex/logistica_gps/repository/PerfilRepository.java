package cl.iplacex.logistica_gps.repository;

import cl.iplacex.logistica_gps.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    // Este método personalizado nos permitirá buscar un perfil por su nombre (ej: "ADMINISTRADOR")
    Optional<Perfil> findByNombre(String nombre);
}
