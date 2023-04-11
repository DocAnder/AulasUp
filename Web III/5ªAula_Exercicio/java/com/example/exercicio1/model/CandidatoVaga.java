package com.example.exercicio1.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CandidatoVaga {

    private String nome;
    private String idioma;
    private LocalDate dataNascimento;
    private String [] habilidades;
    private DateTimeFormatter formatter;

    public  CandidatoVaga(){
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getDataNascimentoAsString() {
        return dataNascimento.format(formatter);
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = LocalDate.parse(dataNascimento, formatter);
    }



    public String[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
    }
}


