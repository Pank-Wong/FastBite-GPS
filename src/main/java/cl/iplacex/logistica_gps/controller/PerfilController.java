package cl.iplacex.logistica_gps.controller;

import cl.iplacex.logistica_gps.model.Perfil;
import cl.iplacex.logistica_gps.repository.PerfilRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/perfiles")
public class PerfilController {

    private final PerfilRepository perfilRepository;

    // Inyección de dependencias: Spring nos entrega el repositorio automáticamente
    public PerfilController(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    // Este endpoint responderá cuando alguien entre a la URL con el método GET
    @GetMapping
    public List<Perfil> obtenerTodosLosPerfiles() {
        return perfilRepository.findAll();
    }
}
