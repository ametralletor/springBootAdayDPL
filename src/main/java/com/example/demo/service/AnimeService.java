package com.example.demo.service;

import com.example.demo.model.Anime;

import com.example.demo.repository.AnimeRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AnimeService {

    @Autowired
    private AnimeRepository repository;

    public Anime guardarAnime(Anime anime){
        return repository.save(anime);
    }

    public List<Anime> obtenerTodos(){
        return repository.findAll();
    }
}
