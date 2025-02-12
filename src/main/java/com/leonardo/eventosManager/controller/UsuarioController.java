package com.leonardo.eventosManager.controller;

import org.springframework.stereotype.Controller;

import com.leonardo.eventosManager.service.UsuarioService;

@Controller
public class UsuarioController {

    public UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }



}
