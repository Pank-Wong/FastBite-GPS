package cl.iplacex.logistica_gps.controller;

import cl.iplacex.logistica_gps.model.Pedido;
import cl.iplacex.logistica_gps.repository.ClienteRepository;
import cl.iplacex.logistica_gps.repository.PedidoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    public PedidoController(PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    // 1. Método para LISTAR todos los pedidos (GET)
    @GetMapping
    public List<Pedido> obtenerPedidos() {
        return pedidoRepository.findAll();
    }

    // 2. Método para REGISTRAR un nuevo pedido y su cliente (POST)
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarPedido(@RequestBody Pedido nuevoPedido) {
        
        // Si el cliente es nuevo (no tiene ID), lo guardamos primero en la base de datos
        if (nuevoPedido.getCliente() != null && nuevoPedido.getCliente().getId() == null) {
            clienteRepository.save(nuevoPedido.getCliente());
        }

        // Guardamos el pedido asignándole un estado inicial
        nuevoPedido.setEstado("PENDIENTE"); 
        pedidoRepository.save(nuevoPedido);
        
        return ResponseEntity.ok("Pedido y cliente registrados con éxito en el sistema.");
    }
}
