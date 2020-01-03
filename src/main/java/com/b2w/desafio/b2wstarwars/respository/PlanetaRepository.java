package com.b2w.desafio.b2wstarwars.respository;

import java.util.List;
import java.util.Optional;

import com.b2w.desafio.b2wstarwars.models.Planeta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlanetaRepository extends MongoRepository<Planeta, String>{
    Optional<List<Planeta>> findByNome(String nome);
}