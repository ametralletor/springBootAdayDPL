package com.example.demo.service;

import com.example.demo.exception.AnimeNotFoundException;

import com.example.demo.model.Anime;

import com.example.demo.repository.AnimeRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AnimeService {

    private final AnimeRepository repository;

    public AnimeService(AnimeRepository repository) {
        this.repository = repository;
    }

    public List<Anime> findAll() {
        return repository.findAll();
    }

    public Anime findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new AnimeNotFoundException(id)); // 👈 lanza 404
    }

    public Anime save(Anime anime) {
        return repository.save(anime);
    }

    public Anime update(Long id, Anime datos) {
        Anime existente = findById(id); // reutiliza la validación
        existente.setTitulo(datos.getTitulo());
        existente.setGenero(datos.getGenero());
        existente.setEpisodios(datos.getEpisodios());
        return repository.save(existente);
    }

    public void delete(Long id) {
        findById(id); // valida que existe antes de borrar
        repository.deleteById(id);
    }
}
