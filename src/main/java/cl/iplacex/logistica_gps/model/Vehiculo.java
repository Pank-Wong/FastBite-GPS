package cl.iplacex.logistica_gps.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 15)
    private String patente;

    @Column(nullable = false, unique = true, length = 50)
    private String imei; // Conector con el GPS-Server

    public Vehiculo() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPatente() { return patente; }
    public void setPatente(String patente) { this.patente = patente; }
    public String getImei() { return imei; }
    public void setImei(String imei) { this.imei = imei; }
}
