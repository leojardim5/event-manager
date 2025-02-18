package com.leonardo.eventosManager.DTO;

import java.util.List;
import java.util.stream.Collectors;

import com.leonardo.eventosManager.model.Usuario;

public class UsuarioInscricaoDTO {

    private long id;
    private String nome;
    private String email;
    private List<EventoDTO> listaEvento;

    public UsuarioInscricaoDTO(Usuario usuario) {

        this.id = usuario.getId();
        this.nome = usuario.getEmail();
        this.email = usuario.getEmail();

        this.listaEvento = usuario.getInscricoes().stream()
                .map(inscricao -> new EventoDTO(inscricao.getEvento()))
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<EventoDTO> getListaEvento() {
        return listaEvento;
    }

    public void setListaEvento(List<EventoDTO> listaEvento) {
        this.listaEvento = listaEvento;
    }

}
