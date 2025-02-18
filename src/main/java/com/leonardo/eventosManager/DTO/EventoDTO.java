package com.leonardo.eventosManager.DTO;



public class EventoDTO{

    private long id;
    private String nome;
    private String descricao;
    private LocalDate data;
    private String localizacao;

    public EventoDTO(Evento evento){

        this.id = evento.id;

    }


}