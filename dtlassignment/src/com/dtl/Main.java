package com.dtl;

public class Main {

	public static void main(String[] args) {

		String uriPath = "https://time.com/search/?q=stories";

		JSONResponse jsonResponse = new JSONResponse();

		String response = jsonResponse.getJSONResponse(uriPath);

		System.out.println("The Response is " + response);

	}
}
