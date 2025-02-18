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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leonardo.eventosManager.DTO.InscricaoDTO;
import com.leonardo.eventosManager.model.Evento;
import com.leonardo.eventosManager.model.Inscricao;
import com.leonardo.eventosManager.model.TipoInscricao;
import com.leonardo.eventosManager.model.Usuario;
import com.leonardo.eventosManager.service.EventoService;
import com.leonardo.eventosManager.service.InscricaoService;
import com.leonardo.eventosManager.service.UsuarioService;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {

    private final InscricaoService inscricaoService;
    private final UsuarioService usuarioService;
    private final EventoService eventoService;

    public InscricaoController(InscricaoService inscricaoService, UsuarioService usuarioService, EventoService eventoService) {
        this.inscricaoService = inscricaoService;
        this.usuarioService = usuarioService;
        this.eventoService = eventoService;
    }

    @GetMapping
    public ResponseEntity<List<InscricaoDTO>> getAll() {
        List<InscricaoDTO> listaIncricoes = inscricaoService.findALL()
                .stream().map(inscricao -> new InscricaoDTO(inscricao)).collect(Collectors.toList());
        return ResponseEntity.ok(listaIncricoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscricao> getById(@PathVariable Long id) {
        Optional<Inscricao> inscricao = inscricaoService.findById(id);
        return inscricao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public ResponseEntity<Inscricao> register(@RequestParam Long usuarioId, @RequestParam Long eventoId, @RequestParam String tipo) {
        Optional<Usuario> usuario = usuarioService.findById(usuarioId);
        Optional<Evento> evento = eventoService.findById(eventoId);

        if (usuario.isEmpty() || evento.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        try {
            Inscricao inscricao = new Inscricao();
            inscricao.setUsuario(usuario.get());
            inscricao.setEvento(evento.get());
            inscricao.setTipoInscricao(tipo.equalsIgnoreCase("ORGANIZADOR") ? TipoInscricao.ORGANIZADOR : TipoInscricao.CONVIDADO);
            Inscricao novaInscricao = inscricaoService.save(inscricao);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaInscricao);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inscricao> update(@PathVariable Long id, @RequestBody Inscricao entity) {
        Optional<Inscricao> inscricaoExistente = inscricaoService.findById(id);
        if (inscricaoExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        try {
            Inscricao inscricaoAtualizada = inscricaoExistente.get();
            inscricaoAtualizada.setUsuario(entity.getUsuario());
            inscricaoAtualizada.setEvento(entity.getEvento());
            inscricaoAtualizada.setTipoInscricao(entity.getTipoInscricao());
            Inscricao atualizado = inscricaoService.update(inscricaoAtualizada);
            return ResponseEntity.ok(atualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!inscricaoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        try {
            inscricaoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
