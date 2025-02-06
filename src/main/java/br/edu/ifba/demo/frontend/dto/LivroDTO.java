package br.edu.ifba.demo.frontend.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class LivroDTO {
    
    private Long id_livro;
    private String titulo;
    private String autor;
    private String editora;
    private Integer ano_publicacao;
    private String genero;
    private String isbn;
    private Integer num_paginas;
    private String sinopse;
    private String idioma;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime data_cadastro;
    private Double preco;

}
