package com.b2w.desafio.b2wstarwars.controllers;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.b2w.desafio.b2wstarwars.dto.PlanetaDTO;
import com.b2w.desafio.b2wstarwars.form.CreatePlanetaForm;
import com.b2w.desafio.b2wstarwars.models.Planeta;
import com.b2w.desafio.b2wstarwars.respository.PlanetaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/v1/planetas")
public class PlanetaController {

    @Autowired
    private PlanetaRepository repository;

    @GetMapping
    public Page<PlanetaDTO> get(@PageableDefault(sort = "nome", direction = Direction.ASC, 
                                                 page = 0, size = 10) Pageable paginacao, 
                                @RequestParam(required = false) String nome){
       if(nome == null){
          return PlanetaDTO.converte(repository.findAll(paginacao));
       }else{
          Page<Planeta> planetas = repository.findByNome(nome, paginacao);
          return PlanetaDTO.converte(planetas);
       }
    }

    @GetMapping("/{id}")
    public ResponseEntity getId(@PathVariable String id){
        Optional<Planeta> optional = repository.findById(id);

        if(optional.isPresent()){
           return ResponseEntity.ok(new PlanetaDTO(optional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity post(@RequestBody @Valid CreatePlanetaForm planetaForm, UriComponentsBuilder uriBuilder){
        Planeta planetaCadastrado = repository.save(planetaForm.converte());
        URI uri = uriBuilder.path("/planetas/{id}").buildAndExpand(planetaCadastrado.getId()).toUri();
        return ResponseEntity.created(uri).body(planetaCadastrado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id){
        Optional<Planeta> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
    }
    
}