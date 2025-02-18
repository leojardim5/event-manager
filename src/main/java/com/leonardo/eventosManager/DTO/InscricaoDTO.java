package com.leonardo.eventosManager.DTO;

import com.leonardo.eventosManager.model.Inscricao;
import com.leonardo.eventosManager.model.TipoInscricao;

public class InscricaoDTO {

    private Long id;
    private String evento;
    private Long id_evento;
    private String usuario;
    private Long id_usuario;
    private TipoInscricao tipoInscricao;

    public InscricaoDTO(Inscricao inscricao) {
        this.evento = inscricao.getEvento().getNome();
        this.id = inscricao.getId();
        this.tipoInscricao = inscricao.getTipoInscricao();
        this.usuario = inscricao.getUsuario().getNome();
        this.id_evento = inscricao.getEvento().getId();
        this.id_usuario = inscricao.getUsuario().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public TipoInscricao getTipoInscricao() {
        return tipoInscricao;
    }

    public void setTipoInscricao(TipoInscricao tipoInscricao) {
        this.tipoInscricao = tipoInscricao;
    }

    public Long getId_evento() {
        return id_evento;
    }

    public void setId_evento(Long id_evento) {
        this.id_evento = id_evento;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

}
