package com.b2w.desafio.b2wstarwars.dto;

import java.util.Optional;

import com.b2w.desafio.b2wstarwars.models.Planeta;

import org.springframework.data.domain.Page;

public class PlanetaDTO {

    private String id;
    private String nome;
    private String clima;
    private String terreno;
    private Long quantidadeFilme;

    public PlanetaDTO(Planeta planeta){
       this.id = planeta.getId();
       this.nome = planeta.getNome();
       this.clima = planeta.getClima();
       this.terreno = planeta.getTerreno();
       this.quantidadeFilme = planeta.getQuantidadeFilme();
    }

	public String getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getClima() {
		return clima;
	}
	public String getTerreno() {
		return terreno;
	}
	public Long getQuantidadeFilme() {
		return quantidadeFilme;
    }
    
    public static Page<PlanetaDTO> converte(Page<Planeta> planetas){
        if(Optional.ofNullable(planetas).isPresent()){
           return planetas.map(PlanetaDTO::new);
        }
        return Page.empty();
    }
    
}