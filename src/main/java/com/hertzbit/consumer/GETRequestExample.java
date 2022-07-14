package com.hertzbit.consumer;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

public class GETRequestExample {

	public static void main(String[] args) {
		
		try {
			String url = "https://reqres.in/api/users/984";
			
			HttpClient httpClient = HttpClient.newHttpClient();
			
			HttpRequest httpRequestGET = HttpRequest.newBuilder()
					.uri(URI.create(url)).GET().build();
		
			HttpResponse<String> httpResponseGET = httpClient
					.send(httpRequestGET, 
					HttpResponse.BodyHandlers.ofString());

			try {
				System.out.println("Starting to do something other than waiting for request");
				Thread.sleep(5000);
				System.out.println("I have completed some task while not waiting for the request");
			} catch (InterruptedException exception) {
				System.out.println(exception.getMessage());
			}
			//System.out.println(httpResponseGET.body());
			//System.out.println(httpResponseGET.statusCode());
			//System.out.println(httpResponseGET.uri());
			//System.out.println(httpResponseGET.headers());
			//System.out.println(httpResponseGET.headers().firstValue("content-type"));
			//System.out.println(httpResponseGET.headers().allValues("content-type"));
			
			System.out.println("Waiting for Request");
			JSONObject jsonResponse = new JSONObject(httpResponseGET.body().toString());
			System.out.println(jsonResponse.toString(4));
			System.out.println(jsonResponse.get("data"));
			JSONObject dataJsonObject = new JSONObject(jsonResponse.get("data").toString());
			System.out.println(dataJsonObject);
			System.out.println(dataJsonObject.get("last_name"));
			
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
}
