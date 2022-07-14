package com.hertzbit.consumer;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import org.json.JSONObject;

public class GETReqResUser {

	public static void main(String[] args) {
		
		try {
			String url = "https://wikipedia.com";
			
			//HttpClient httpClient = HttpClient.newHttpClient();
			HttpClient redirectClient = HttpClient.newBuilder()
										.followRedirects(HttpClient.Redirect.ALWAYS)
										.build();
		
			HttpRequest httpGETRequest = HttpRequest.newBuilder()
										.uri(URI.create(url))
										.header("Content-Type", "application/xml")
										.timeout(Duration.ofMillis(2000))
										.build();
		
			HttpResponse<String> httpGETResponse = redirectClient.send(httpGETRequest, 
													HttpResponse.BodyHandlers.ofString());
			
//			HttpResponse<Path> httpPathResponse = httpClient.send(httpGETRequest, 
//					HttpResponse.BodyHandlers.ofFile(Paths.get("responseJson.json")));
//			
			
			
			
//			System.out.println(httpGETResponse.headers().allValues("content-type"));
//			System.out.println(httpGETResponse.headers().firstValue("content-type"));
//			
//			System.out.println(httpGETResponse.headers().allValues("content-length"));
//			
//			
			
			System.out.println(httpGETResponse.statusCode());
			//System.out.println(httpGETResponse.body());
			System.out.println(httpGETResponse.uri());
			HttpResponse<String> redirectResponse = httpGETResponse.previousResponse().get();
			System.out.println(redirectResponse.uri());
			
//			JSONObject responseBodyJSON = new JSONObject(httpGETResponse.body());
//			System.out.println(responseBodyJSON.toString(5));
//			
////			System.out.println(responseBodyJSON.get("data"));
////			System.out.println(responseBodyJSON.get("support"));
//			
//			JSONObject dataObject = new JSONObject(responseBodyJSON.get("data").toString());
//			System.out.println(dataObject.toString(4));
//			
//			System.out.println(dataObject.get("last_name"));
//			
//			JSONObject supportObject = new JSONObject(responseBodyJSON.get("support").toString());
//			System.out.println(supportObject.get("text"));
			
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

}
