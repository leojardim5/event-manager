package com.leonardo.eventosManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardo.eventosManager.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
