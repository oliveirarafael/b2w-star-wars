package com.b2w.desafio.b2wstarwars.services.http;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;

public class Get implements Request {

	private HttpClient http = new HttpClient();
	private String url;
	
	public Get(String url) {
		this.url = url;
	}

	@Override
	public Response envia() {
		try {
			HttpMethod metodo = new GetMethod(url);
			metodo.setRequestHeader(new Header("accept", "application/json"));
			metodo.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64)"+ 
							 "AppleWebKit/537.11 (KHTML, like Gecko)"+ 
							 "Chrome/23.0.1271.95 Safari/537.11");

			int status = executa(metodo);
			return new Response(new String(metodo.getResponseBody()).toLowerCase(), status);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Ocorreu um erro na requisição: "+e.getMessage());
		}
	}

	private int executa(HttpMethod metodo) throws HttpException, IOException {
		return http.executeMethod(metodo);
	}

}