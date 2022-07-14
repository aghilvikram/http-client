package com.hertzbit.consumer;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

public class PostRequestExample {

	public static void main(String[] args) throws Exception{
		
		String url = "https://reqres.in/api/users";
		
		String postData = " { " +
						  "     'name' : 'Elon', " +
				          "     'job' : 'CEO'" +
						  " } ";
		
		HttpClient httpClient = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder()
								.uri(URI.create(url))
								.POST(HttpRequest.BodyPublishers.ofString(postData))
								.build();
		
		HttpResponse<?> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		
		System.out.println(response.statusCode());
		
		JSONObject jsonObject = new JSONObject(response.body().toString());
		System.out.println(jsonObject.toString(5));
	}

}
