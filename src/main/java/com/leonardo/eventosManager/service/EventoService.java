package com.leonardo.eventosManager.service;

import java.util.List;
import java.util.Optional;

import com.leonardo.eventosManager.model.Evento;
import com.leonardo.eventosManager.repository.EventoRepository;

public class EventoService implements ServiceInterface<Evento> {

    private EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @Override
    public Evento save(Evento entity) {
        return eventoRepository.save(entity);
    }

    @Override
    public List<Evento> findALL() {
        return eventoRepository.findAll();
    }

    @Override
    public Evento update(Evento entity) {
        return eventoRepository.save(entity);
    }

    @Override
    public Optional<Evento> findById(long id) {
        return eventoRepository.findById(id);
    }

    @Override
    public void delete(long id) {
        eventoRepository.deleteById(id);
    }

}
