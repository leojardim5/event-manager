package com.leonardo.eventosManager.DTO;

import java.util.List;
import java.util.stream.Collectors;

import com.leonardo.eventosManager.model.Evento;

public class EventoInscricaoDTO {

    private long id;
    private String nome;
    private String descricao;
    private String data;
    private String localizacao;
    private List<UsuarioDTO> inscritos;

    public EventoInscricaoDTO(Evento evento) {
        this.id = evento.getId();
        this.nome = evento.getNome();
        this.descricao = evento.getDescricao();
        this.data = evento.getData().toString();
        this.localizacao = evento.getLocalizacao();
        this.inscritos = evento.getIncricoes().stream()
                .map(inscricao -> new UsuarioDTO(inscricao.getUsuario(), inscricao.getTipoInscricao()))
                .collect(Collectors.toList());
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public List<UsuarioDTO> getInscritos() {
        return inscritos;
    }

    public void setInscritos(List<UsuarioDTO> inscritos) {
        this.inscritos = inscritos;
    }

}
