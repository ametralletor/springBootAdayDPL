package com.example.demo.controller;

import com.example.demo.model.Anime;
import com.example.demo.service.AnimeService;


import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/animes")
public class AnimeController {

    private final AnimeService service;

    public AnimeController(AnimeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Anime> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Anime getById(@PathVariable Long id) {
        return service.findById(id); // 404 automático si no existe
    }

    @PostMapping
    public ResponseEntity<Anime> create(@Valid @RequestBody Anime anime) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(anime));
    }

    @PutMapping("/{id}")
    public Anime update(@PathVariable Long id, @Valid @RequestBody Anime anime) {
        return service.update(id, anime); // 404 automático si no existe
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id); // 404 automático si no existe
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}