package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity

@Table(name = "anime")

@Data

public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String genero;
    private int episodios;
    
}
