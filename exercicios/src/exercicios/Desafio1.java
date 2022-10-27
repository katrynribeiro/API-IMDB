package exercicios;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Desafio1 {

	public static void main(String[] args) throws Exception {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest
				.newBuilder()
				.uri(new URI("https://imdb-api.com/en/API/Top250Movies/{key}"))
				.GET()
				.build();
		
		client.sendAsync(request, BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenAccept(System.out::println)
				.join();
				
	}

}