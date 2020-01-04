package com.b2w.desafio.b2wstarwars.services;

import java.util.Iterator;

import com.b2w.desafio.b2wstarwars.services.http.Get;
import com.b2w.desafio.b2wstarwars.services.http.Http;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

public class SWAPIService {

    private static final String URL_BASE = "https://swapi.co/api";
    private static final String URL_PLANETS_SEARCH = "/planets?search=";
    private Http http;
    private String nome;
    private JsonNode json;
    private ObjectMapper mapper = new ObjectMapper();

    private SWAPIService(String nome){
        this.nome = nome;
    }

    public static SWAPIService planeta(String nome){
        return new SWAPIService(nome);
    }

    public SWAPIService get() {
		try {
			http = new Http(new Get(URL_BASE+URL_PLANETS_SEARCH+nome));
            json = mapper.readTree(http.request().getRetorno()).path("results");

            if(json == null){
               throw new RuntimeException("Planeta não encontrado");
            }
		} catch (Exception e) {
			e.printStackTrace();
        }
        
        return this;
    }
    
    public int filmes(){
        if(http == null){
            throw new RuntimeException("Você deve chamar o metodo get antes do metodo filmes");
        }

        if(json == null){
            return 0;
        }

        Iterator<JsonNode> elements = json.elements();
        int filmes = 0;
        while(elements.hasNext()){
            filmes = elements.next().findValue("films").size();
        }
        return filmes;
    }
}