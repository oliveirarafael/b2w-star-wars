package com.b2w.desafio.b2wstarwars.respository;

import com.b2w.desafio.b2wstarwars.models.Planeta;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlanetaRepository extends MongoRepository<Planeta, String>{
    Page<Planeta> findByNome(String nome, Pageable paginacao);
}