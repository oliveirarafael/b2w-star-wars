package com.b2w.desafio.b2wstarwars.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.b2w.desafio.b2wstarwars.models.Planeta;

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

	private Long getQuantidadeFilmes() {
		return 1L;
	}
}
