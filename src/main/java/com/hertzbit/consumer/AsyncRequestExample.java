package com.hertzbit.consumer;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.concurrent.CompletableFuture;

import org.json.JSONObject;

public class AsyncRequestExample {

	public static void main(String[] args) throws Exception {
		
		
		String url = "https://reqres.in/api/users?delay=5";
		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpRequest req = HttpRequest.newBuilder()
				.uri(URI.create(url)).build();
		
		CompletableFuture<HttpResponse<String>> future = null;
		
		long startTime = System.currentTimeMillis();
		
		future = httpClient.sendAsync(req, 
				HttpResponse.BodyHandlers.ofString());
		
		try {
			System.out.println("Starting to do something other than waiting for request");
			Thread.sleep(5000);
			System.out.println("I have completed some task while not waiting for the request");
		} catch (InterruptedException exception) {
			System.out.println(exception.getMessage());
		}
		
		String response = future.thenApplyAsync(HttpResponse::body).get();

		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime-startTime);
//		JSONObject jsonObject = new JSONObject(response);
//		
//		System.out.println(jsonObject.toString(5));
	}

}
