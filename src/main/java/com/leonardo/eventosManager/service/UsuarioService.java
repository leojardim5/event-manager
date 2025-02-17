package com.leonardo.eventosManager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.leonardo.eventosManager.model.Usuario;
import com.leonardo.eventosManager.repository.UsuarioRepository;

@Service
public class UsuarioService implements ServiceInterface<Usuario> {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario save(Usuario entity) {
        return usuarioRepository.save(entity);
    }

    @Override
    public List<Usuario> findALL() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario update(Usuario entity) {

        return usuarioRepository.save(entity);

    }

    @Override
    public Optional<Usuario> findById(long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public void delete(long id) {
        usuarioRepository.deleteById(id);

    }

}
