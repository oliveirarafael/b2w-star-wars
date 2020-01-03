package com.b2w.desafio.b2wstarwars.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.b2w.desafio.b2wstarwars.models.Planeta;
import com.b2w.desafio.b2wstarwars.respository.PlanetaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.domain.Pageable;

@DataMongoTest
public class PlanetaRepositoryTest {
   
    private Planeta planeta;

    @Autowired
    private PlanetaRepository repository;
    
    @Test
    public void criaPlaneta(){
        planeta = new Planeta();
        planeta.setNome("Alderaan");
        planeta.setTerreno("grasslands");
        planeta.setClima("temperate");
        planeta.setQuantidadeFilme(2L);

        Planeta planetaSalvo = repository.save(planeta);

        assertNotNull(planetaSalvo.getId());
    }

    @Test
    public void todosPlanetas(){
        List<Planeta> planetas = repository.findAll();
        assertFalse(planetas.isEmpty());
    }

    @Test
    public void buscaPorNome(){
        planeta = repository.findByNome("Alderaan", Pageable.unpaged()).getContent().get(0);
        assertEquals("grasslands", planeta.getTerreno());
    }

    @Test
    public void buscaPorId(){
        planeta = repository.findByNome("Alderaan", Pageable.unpaged()).getContent().get(0);
        assertTrue(repository.findById(planeta.getId()).isPresent());
    }

    @Test
    public void remover(){
      planeta = repository.findByNome("Alderaan", Pageable.unpaged()).getContent().get(0);  
      repository.deleteById(planeta.getId());
      assertFalse(repository.findById(planeta.getId()).isPresent());
    }

}