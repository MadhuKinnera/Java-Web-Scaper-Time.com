package com.dtl;

import java.util.List;

public class JSONResponse {

	
	public String getJSONResponse(String uriPath) {

		MakeRequest req = new MakeRequest();

		String responseData = req.makeTimesRequest(uriPath);

		ProcessHTML htmlProcesser = new ProcessHTML();
		
		
		

		List<Story> stories = htmlProcesser.getSixStories(responseData);

		StringBuilder sb = new StringBuilder();

		sb.append("[\n");

		for (Story s : stories) {
			sb.append("{\n");

			sb.append("\"title\": ");
			sb.append("\"");
			sb.append(s.getTitle());
			sb.append("\"");

			sb.append(",\n");

			sb.append("\"link\": ");
			sb.append(s.getLink());
			
			sb.append("},\n");
		}

		sb.deleteCharAt(sb.length() - 1);

		sb.append("\n]");

		String jsonResponse = sb.toString();

		return jsonResponse;

	}

}
