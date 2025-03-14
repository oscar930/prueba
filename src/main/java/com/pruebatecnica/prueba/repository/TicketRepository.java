package com.pruebatecnica.prueba.repository;

import com.pruebatecnica.prueba.model.Estatus;
import com.pruebatecnica.prueba.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Page<Ticket> findAll(Pageable pageable);
    Optional<Ticket> findByUsuario(String usuario);
    Page<Ticket> findByEstatus(Estatus estatus, Pageable pageable);
}
