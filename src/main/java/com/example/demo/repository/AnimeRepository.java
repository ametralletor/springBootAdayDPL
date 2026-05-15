package com.example.demo.repository;

import com.example.demo.model.Anime;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {
    
}
