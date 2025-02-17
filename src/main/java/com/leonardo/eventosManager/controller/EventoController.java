package com.leonardo.eventosManager.controller;

import java.util.List;
import java.util.Optional;

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

import com.leonardo.eventosManager.model.Evento;
import com.leonardo.eventosManager.service.EventoService;

@RestController
@RequestMapping("/eventos")
public class EventoController implements ControllerInterface<Evento, Long> {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Evento>> getAll() {
        List<Evento> eventos = eventoService.findALL();
        return ResponseEntity.ok(eventos); // Retorna 200 OK com a lista de eventos
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Evento> getById(@PathVariable Long id) {
        Optional<Evento> evento = eventoService.findById(id);
        if (evento.isPresent()) {
            return ResponseEntity.ok(evento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Evento> register(@RequestBody Evento entity) {
        try {
            Evento novoEvento = eventoService.save(entity);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoEvento); // Retorna 201 Created
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Retorna 400 Bad Request
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Evento> update(@PathVariable Long id, @RequestBody Evento entity) {
        Optional<Evento> eventoExistente = eventoService.findById(id);
        if (!eventoExistente.isPresent()) {
            return ResponseEntity.notFound().build(); // Retorna 404 se o evento não existir
        }
        try {
            Evento eventoAtualizado = eventoExistente.get();
            eventoAtualizado.setNome(entity.getNome());
            eventoAtualizado.setDescricao(entity.getDescricao());
            eventoAtualizado.setData(entity.getData());
            eventoAtualizado.setLocalizacao(entity.getLocalizacao());
            // Adicione outros campos conforme necessário
            Evento atualizado = eventoService.update(eventoAtualizado);
            return ResponseEntity.ok(atualizado); // Retorna 200 OK com o evento atualizado
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Retorna 400 se houver erro
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!eventoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build(); // Retorna 404 se não existir
        }
        try {
            eventoService.delete(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content ao excluir com sucesso
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Retorna 500 em erro inesperado
        }
    }
}
