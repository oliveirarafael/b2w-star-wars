package com.b2w.desafio.b2wstarwars.services.http;

public class Http {

	private Request request;
	
	public Http(Request request) {
		this.request = request;
	}
	
	public Response request() throws Exception {
		Response response = request.envia();
		
		if(response.getStatus() == 200) {
			return response;
		}
		
		throw new Exception("Ocorreu um erro na requisição: (Status: "+response.getStatus()+")");
	}
}
