package com.leonardo.eventosManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.eventosManager.model.Usuario;
import com.leonardo.eventosManager.repository.UsuarioRepository;

@Service
public class UsuarioService implements ServiceInterface<Usuario> {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario register(Usuario usuario) {

    }

}
