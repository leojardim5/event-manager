package com.leonardo.eventosManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardo.eventosManager.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


}
