package cl.iplacex.logistica_gps.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "asignaciones")
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fechaAsignacion;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "repartidor_id", nullable = false)
    private Usuario repartidor;

    public Asignacion() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getFechaAsignacion() { return fechaAsignacion; }
    public void setFechaAsignacion(LocalDateTime fechaAsignacion) { this.fechaAsignacion = fechaAsignacion; }
    public Pedido getPedido() { return pedido; }
    public void setPedido(Pedido pedido) { this.pedido = pedido; }
    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }
    public Usuario getRepartidor() { return repartidor; }
    public void setRepartidor(Usuario repartidor) { this.repartidor = repartidor; }
}
