package com.dtl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ResponseServer {

	public static void main(String[] args) {


		String uriPath = "https://time.com/search/?q=stories";

		JSONResponse jsonResponse = new JSONResponse();

		String response = jsonResponse.getJSONResponse(uriPath);

		try (ServerSocket serverSocket = new ServerSocket(8000)) {
			System.out.println("Server running on port 8000");

			while (true) {
				Socket clientSocket = serverSocket.accept();
				handleRequest(clientSocket,response);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	private static void handleRequest(Socket clientSocket,String jsonReponse) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            OutputStream out = clientSocket.getOutputStream();
          
            StringBuilder request = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null && !line.isEmpty()) {
                request.append(line).append("\r\n");
            }
            
            
            String response = "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/plain\r\n"
                    + "\r\n"
                    + jsonReponse;
            out.write(response.getBytes());

            out.flush();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	

}
