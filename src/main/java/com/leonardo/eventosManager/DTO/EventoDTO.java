package com.leonardo.eventosManager.DTO;

import java.time.LocalDate;

import com.leonardo.eventosManager.model.Evento;

public class EventoDTO {

    private long id;
    private String nome;
    private String descricao;
    private LocalDate data;
    private String localizacao;

    public EventoDTO(Evento evento) {

        this.id = evento.getId();
        this.nome = evento.getNome();
        this.descricao = evento.getDescricao();
        this.data = evento.getData();
        this.localizacao = evento.getLocalizacao();

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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

}
