package com.pruebatecnica.prueba.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class Ticket {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String usuario;
        private LocalDateTime fechaCreacion;
        private LocalDateTime fechaActualizacion;
        @Enumerated(EnumType.STRING)
        private Estatus estatus;

        public String getUsuario() {
                return usuario;
        }

        public void setUsuario(String usuario) {
                this.usuario = usuario;
        }

        public LocalDateTime getFechaCreacion() {
                return fechaCreacion;
        }

        public void setFechaCreacion(LocalDateTime fechaCreacion) {
                this.fechaCreacion = fechaCreacion;
        }

        public LocalDateTime getFechaActualizacion() {
                return fechaActualizacion;
        }

        public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
                this.fechaActualizacion = fechaActualizacion;
        }

        public Estatus getEstatus() {
                return estatus;
        }

        public void setEstatus(String estatus) {
                this.estatus = Estatus.valueOf(estatus);
        }

    }

