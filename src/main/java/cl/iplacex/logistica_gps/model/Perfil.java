package cl.iplacex.logistica_gps.model;

import jakarta.persistence.*;

@Entity
@Table(name = "perfiles")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String nombre; // Ej: "ADMINISTRADOR", "REPARTIDOR"

    // Constructor vacío exigido por Spring
    public Perfil() {}

    public Perfil(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
