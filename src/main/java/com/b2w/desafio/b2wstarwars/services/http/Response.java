package com.b2w.desafio.b2wstarwars.services.http;

public class Response {

    private String retorno;
    private int status;
            
    public Response(String retorno, int status) {
		this.retorno = retorno;
		this.status = status;
	}

	public String getRetorno() {
		return retorno;
	}
	
	public int getStatus() {
		return status;
	}
}