package com.leonardo.eventosManager.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonardo.eventosManager.DTO.EventoDTO;
import com.leonardo.eventosManager.DTO.EventoInscricaoDTO;
import com.leonardo.eventosManager.model.Evento;
import com.leonardo.eventosManager.service.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public ResponseEntity<List<EventoDTO>> getAll() {
        List<EventoDTO> eventos = eventoService.findALL()
                .stream()
                .map(EventoDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoDTO> getById(@PathVariable Long id) {
        Optional<Evento> evento = eventoService.findById(id);
        return evento.map(e -> ResponseEntity.ok(new EventoDTO(e)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EventoDTO> register(@RequestBody Evento entity) {
        try {
            Evento novoEvento = eventoService.save(entity);
            return ResponseEntity.status(HttpStatus.CREATED).body(new EventoDTO(novoEvento));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoDTO> update(@PathVariable Long id, @RequestBody Evento entity) {
        Optional<Evento> eventoExistente = eventoService.findById(id);
        if (eventoExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        try {
            Evento eventoAtualizado = eventoExistente.get();
            eventoAtualizado.setNome(entity.getNome());
            eventoAtualizado.setDescricao(entity.getDescricao());
            eventoAtualizado.setData(entity.getData());
            eventoAtualizado.setLocalizacao(entity.getLocalizacao());
            Evento atualizado = eventoService.update(eventoAtualizado);
            return ResponseEntity.ok(new EventoDTO(atualizado));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!eventoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        try {
            eventoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}/inscritos")
    public ResponseEntity<EventoInscricaoDTO> getInscritosPorEvento(@PathVariable Long id) {
        Optional<Evento> evento = eventoService.findById(id);
        if (evento.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new EventoInscricaoDTO(evento.get()));
    }
}
