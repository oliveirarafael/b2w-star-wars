package com.b2w.desafio.b2wstarwars.models;

import org.springframework.data.annotation.Id;

public class Planeta {

   @Id
   private String id;
   private String nome;
   private String clima;
   private String terreno;
   private Integer quantidadeFilme;

   public Planeta() {
   }
   
   public Planeta(String nome, String clima, String terreno, Integer quantidadeFilme) {
   	this.nome = nome;
   	this.clima = clima;
   	this.terreno = terreno;
   	this.quantidadeFilme = quantidadeFilme;
   }

   
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getNome() {
      return nome;
   }
   
   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getClima() {
      return clima;
   }
   
   public void setClima(String clima) {
      this.clima = clima;
   }

   public String getTerreno() {
      return terreno;
   }

   public void setTerreno(String terreno) {
      this.terreno = terreno;
   }
   
   public Integer getQuantidadeFilme() {
      return quantidadeFilme;
   }

   public void setQuantidadeFilme(Integer quantidadeFilme) {
      this.quantidadeFilme = quantidadeFilme;
   }
   

   @Override
   public String toString() {
      return "Planeta [clima=" + clima + ", id=" + id + ", nome=" + nome + ", quantidadeFilme=" + quantidadeFilme
            + ", terreno=" + terreno + "]";
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((clima == null) ? 0 : clima.hashCode());
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      result = prime * result + ((nome == null) ? 0 : nome.hashCode());
      result = prime * result + ((quantidadeFilme == null) ? 0 : quantidadeFilme.hashCode());
      result = prime * result + ((terreno == null) ? 0 : terreno.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Planeta other = (Planeta) obj;
      if (clima == null) {
         if (other.clima != null)
            return false;
      } else if (!clima.equals(other.clima))
         return false;
      if (id == null) {
         if (other.id != null)
            return false;
      } else if (!id.equals(other.id))
         return false;
      if (nome == null) {
         if (other.nome != null)
            return false;
      } else if (!nome.equals(other.nome))
         return false;
      if (quantidadeFilme == null) {
         if (other.quantidadeFilme != null)
            return false;
      } else if (!quantidadeFilme.equals(other.quantidadeFilme))
         return false;
      if (terreno == null) {
         if (other.terreno != null)
            return false;
      } else if (!terreno.equals(other.terreno))
         return false;
      return true;
   }
      
}