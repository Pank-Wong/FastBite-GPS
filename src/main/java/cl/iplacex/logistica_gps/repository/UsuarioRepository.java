package cl.iplacex.logistica_gps.repository;

import cl.iplacex.logistica_gps.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Nos servirá para el login: buscar al usuario por su correo exacto
    Optional<Usuario> findByEmail(String email);
}
