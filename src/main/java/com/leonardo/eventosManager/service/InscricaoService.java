package com.leonardo.eventosManager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.leonardo.eventosManager.model.Inscricao;
import com.leonardo.eventosManager.repository.InscricaoRepository;

@Service
public class InscricaoService implements ServiceInterface<Inscricao> {

    private final InscricaoRepository inscricaoRepository;

    public InscricaoService(InscricaoRepository inscricãoRepository) {
        this.inscricaoRepository = inscricãoRepository;
    }

    @Override
    public Inscricao save(Inscricao entity) {
        return inscricaoRepository.save(entity);
    }

    @Override
    public List<Inscricao> findALL() {
        return inscricaoRepository.findAll();
    }

    @Override
    public Inscricao update(Inscricao entity) {
        return inscricaoRepository.save(entity);
    }

    @Override
    public Optional<Inscricao> findById(long id) {
        return inscricaoRepository.findById(id);
    }

    @Override
    public void delete(long id) {
        inscricaoRepository.deleteById(id);
    }

}
