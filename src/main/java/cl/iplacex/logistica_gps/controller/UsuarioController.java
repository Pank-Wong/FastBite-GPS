package cl.iplacex.logistica_gps.controller;

import cl.iplacex.logistica_gps.model.Perfil;
import cl.iplacex.logistica_gps.model.Usuario;
import cl.iplacex.logistica_gps.repository.PerfilRepository;
import cl.iplacex.logistica_gps.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;

    public UsuarioController(UsuarioRepository usuarioRepository, PerfilRepository perfilRepository) {
        this.usuarioRepository = usuarioRepository;
        this.perfilRepository = perfilRepository;
    }

    // 1. Método para LISTAR todos los usuarios (GET)
    @GetMapping
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    // 2. Método para INICIAR SESIÓN (POST)
    @PostMapping("/login")
    public ResponseEntity<?> loginUsuario(@RequestBody Usuario credenciales) {
        // Buscamos al usuario por su correo
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByEmail(credenciales.getEmail());

        // Verificamos si existe y si la contraseña coincide
        if (usuarioEncontrado.isPresent() && usuarioEncontrado.get().getPassword().equals(credenciales.getPassword())) {
            // Si todo está correcto, devolvemos los datos del usuario (para que el frontend sepa quién entró)
            return ResponseEntity.ok(usuarioEncontrado.get());
        }

        // Si falla, devolvemos un error 401 (No autorizado)
        return ResponseEntity.status(401).body("Error: Correo o contraseña incorrectos.");
    }

    // 3. Método para REGISTRAR un nuevo usuario (POST)
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarUsuario(@RequestBody Usuario nuevoUsuario) {
        if (usuarioRepository.findByEmail(nuevoUsuario.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Error: El correo ya está registrado.");
        }

        Optional<Perfil> perfilObtenido = perfilRepository.findById(nuevoUsuario.getPerfil().getId());
        if (perfilObtenido.isEmpty()) {
            return ResponseEntity.badRequest().body("Error: El perfil especificado no existe.");
        }

        nuevoUsuario.setPerfil(perfilObtenido.get());
        usuarioRepository.save(nuevoUsuario);
        
        return ResponseEntity.ok("Usuario registrado con éxito en el sistema.");
    }
}
