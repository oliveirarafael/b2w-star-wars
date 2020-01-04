package com.b2w.desafio.b2wstarwars.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.b2w.desafio.b2wstarwars.models.Planeta;
import com.b2w.desafio.b2wstarwars.services.SWAPIService;

public class CreatePlanetaForm {

    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String clima;
    @NotNull @NotEmpty
    private String terreno;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public Planeta converte(){
        return new Planeta(nome, clima, terreno, getQuantidadeFilmes());
    }

	private Integer getQuantidadeFilmes() {
		return SWAPIService.planeta(nome).get().filmes();
	}
}
