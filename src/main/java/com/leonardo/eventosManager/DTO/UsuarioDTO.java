package com.leonardo.eventosManager.DTO;

import com.leonardo.eventosManager.model.TipoInscricao;
import com.leonardo.eventosManager.model.Usuario;

public class UsuarioDTO {

    private long id;
    private String nome;
    private String email;
    private TipoInscricao tipoInscricao;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }

    public UsuarioDTO(Usuario usuario, TipoInscricao tipoInscricao) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.tipoInscricao = tipoInscricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoInscricao getTipoInscricao() {
        return tipoInscricao;
    }

    public void setTipoInscricao(TipoInscricao tipoInscricao) {
        this.tipoInscricao = tipoInscricao;
    }

}
