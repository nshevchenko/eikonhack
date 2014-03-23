package com.example.eikonhack;


import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
 
public class HttpClient {
 
	private static final String USER_AGENT = "";

	public static void main(String[] args) throws Exception {
 
		String url = "http://www.google.com/search?q=httpClient";
		 
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
	 
		// add request header
		request.addHeader("User-Agent", USER_AGENT);
		HttpResponse response = client.execute(request);
	 
		System.out.println("Response Code : " 
	                + response.getStatusLine().getStatusCode());
	 
//		BufferedReader rd = new BufferedReader(
//			new InputStreamReader(response.getEntity().getContent()));
////	 
//		StringBuffer result = new StringBuffer();
//		String line = "";
//		while ((line = rd.readLine()) != null) {
//			result.append(line);
//		}
}}