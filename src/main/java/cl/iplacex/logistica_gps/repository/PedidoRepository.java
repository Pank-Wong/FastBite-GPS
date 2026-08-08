package cl.iplacex.logistica_gps.repository;

import cl.iplacex.logistica_gps.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
