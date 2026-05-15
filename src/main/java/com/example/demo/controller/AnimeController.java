package com.example.demo.controller;

import com.example.demo.model.Anime;
import com.example.demo.service.AnimeService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animes")
public class AnimeController {
    
    @Autowired
    private AnimeService service;

    @PostMapping
    public Anime crear(@RequestBody Anime anime){
        return service.guardarAnime(anime);
    }

    @GetMapping
    public List<Anime> listarTodos(){
        return service.obtenerTodos();
    }
}
