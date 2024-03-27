package com.dtl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MakeRequest {

	public String makeTimesRequest(String uriPath) {

		URI uri = URI.create(uriPath);

		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder().GET().uri(uri).build();

		String body = null;

		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			if (response.statusCode() == 200) {
				System.out.println("Request Success");
				body = response.body();
				System.out.println("Body is " + body);
			} else {
				System.out.println("ERROR : Status Code : " + response.statusCode());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return body;

	}

}
