package com.pruebatecnica.prueba.controller;

import com.pruebatecnica.prueba.model.Estatus;
import com.pruebatecnica.prueba.model.Ticket;
import com.pruebatecnica.prueba.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Ticket> crear(@RequestBody Ticket ticket) {
        return ResponseEntity.ok(service.crearTicket(ticket));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> obtenerPorId(@PathVariable Long id) {
        return service.obtenerTicketPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Page<Ticket> obtenerTodos(Pageable pageable) {
        return service.obtenerTodosLosTickets(pageable);
    }

    @GetMapping("/estatus/{estatus}")
    public Page<Ticket> obtenerPorEstatus(@PathVariable Estatus estatus, Pageable pageable) {
        return service.obtenerTicketsPorEstatus(estatus, pageable);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> actualizar(@PathVariable Long id, @RequestBody Ticket ticket) {
        return ResponseEntity.ok(service.actualizarTicket(id, ticket));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminarTicket(id);
        return ResponseEntity.noContent().build();
    }

}
