package com.pruebatecnica.prueba.service;

import com.pruebatecnica.prueba.model.Estatus;
import com.pruebatecnica.prueba.model.Ticket;
import com.pruebatecnica.prueba.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TicketService {


    private final TicketRepository repository;

    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket crearTicket(Ticket ticket) {
        ticket.setFechaCreacion(LocalDateTime.now());
        ticket.setFechaActualizacion(LocalDateTime.now());
        return repository.save(ticket);
    }

    public Optional<Ticket> obtenerTicketPorId(Long id) {
        return repository.findById(id);
    }

    public Page<Ticket> obtenerTodosLosTickets(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Ticket> obtenerTicketsPorEstatus(Estatus estatus, Pageable pageable) {
        return repository.findByEstatus(estatus, pageable);
    }

    public Ticket actualizarTicket(Long id, Ticket ticketActualizado) {
        return repository.findById(id)
                .map(ticket -> {
                    ticket.setUsuario(ticketActualizado.getUsuario());
                    ticket.setEstatus(ticketActualizado.getEstatus().toString());
                    ticket.setFechaActualizacion(LocalDateTime.now());
                    return repository.save(ticket);
                }).orElseThrow(() -> new RuntimeException("Ticket no encontrado"));
    }

    public void eliminarTicket(Long id) {
        repository.deleteById(id);
    }
}
