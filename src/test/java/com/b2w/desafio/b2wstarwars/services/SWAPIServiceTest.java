package com.b2w.desafio.b2wstarwars.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


public class SWAPIServiceTest {

    @Test
    public void verificaQuantidadeAparicoesEmFilmes(){
        assertEquals(1, SWAPIService.planeta("Hoth").get().filmes());
    }
    
    @Test
    public void verificarSeMetodoFilmesEstaSendoChamadoAntesDoMetodoGet(){
        Exception exception = assertThrows(RuntimeException.class, () -> {
            SWAPIService.planeta("Hoth").filmes();
        });
     
        String expectedMessage = "Você deve chamar o metodo get antes do metodo filmes";
        String actualMessage = exception.getMessage();
     
        assertTrue(actualMessage.contains(expectedMessage));
    }
}