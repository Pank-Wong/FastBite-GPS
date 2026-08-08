package cl.iplacex.logistica_gps.config;

import cl.iplacex.logistica_gps.model.Perfil;
import cl.iplacex.logistica_gps.model.Usuario;
import cl.iplacex.logistica_gps.repository.PerfilRepository;
import cl.iplacex.logistica_gps.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(PerfilRepository perfilRepository, UsuarioRepository usuarioRepository) {
        return args -> {
            // 1. Verificar y crear el perfil ADMINISTRADOR
            Perfil adminPerfil;
            if (perfilRepository.findByNombre("ADMINISTRADOR").isEmpty()) {
                adminPerfil = new Perfil("ADMINISTRADOR");
                perfilRepository.save(adminPerfil);
                System.out.println("Perfil ADMINISTRADOR creado con éxito.");
            } else {
                adminPerfil = perfilRepository.findByNombre("ADMINISTRADOR").get();
            }

            // 2. Verificar y crear el perfil REPARTIDOR
            if (perfilRepository.findByNombre("REPARTIDOR").isEmpty()) {
                Perfil repartidorPerfil = new Perfil("REPARTIDOR");
                perfilRepository.save(repartidorPerfil);
                System.out.println("Perfil REPARTIDOR creado con éxito.");
            }

            // 3. Crear el Usuario Administrador por defecto
            if (usuarioRepository.findByEmail("admin@fastbite.cl").isEmpty()) {
                Usuario adminUser = new Usuario();
                adminUser.setNombreCompleto("Administrador Principal");
                adminUser.setEmail("admin@fastbite.cl");
                adminUser.setPassword("admin123"); // Contraseña base para iniciar sesión
                adminUser.setPerfil(adminPerfil);

                usuarioRepository.save(adminUser);
                System.out.println("Usuario Administrador por defecto ('admin@fastbite.cl') creado con éxito.");
            }
        };
    }
}
