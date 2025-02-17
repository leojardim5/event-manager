package com.leonardo.eventosManager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.leonardo.eventosManager.model.Usuario;
import com.leonardo.eventosManager.service.UsuarioService;

@Controller
public class UsuarioController implements ControllerInterface<Usuario, Long> {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        List<Usuario> listaUsuarios = usuarioService.findALL();
        return ResponseEntity.ok(listaUsuarios);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id) {
        Optional<Usuario> optionalUsuario = usuarioService.findById(id);
        return optionalUsuario.isPresent() ? ResponseEntity.ok(optionalUsuario.get()) : ResponseEntity.notFound().build();
    }

    @Override
    @PostMapping
    public ResponseEntity<Usuario> register(@RequestBody Usuario entity) {
        try {
            Usuario novoUsuario = usuarioService.save(entity);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }

    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario entity) {
        Optional<Usuario> usuarioExistente = usuarioService.findById(id);
        if (!usuarioExistente.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        try {
            Usuario usuarioAtualizado = usuarioExistente.get();
            usuarioAtualizado.setNome(entity.getNome());
            usuarioAtualizado.setEmail(entity.getEmail());
            // Adicione outros campos conforme necessário
            Usuario atualizado = usuarioService.update(usuarioAtualizado);
            return ResponseEntity.ok(atualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        if (!usuarioService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        try {
            usuarioService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
