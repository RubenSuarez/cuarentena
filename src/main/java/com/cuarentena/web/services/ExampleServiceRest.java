package com.cuarentena.web.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class ExampleServiceRest {
	
	
	public String exampleRest() {
		try {
			URL url = new URL("https://pokeapi.co/api/v2/pokemon/");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
			String output;
			String aux = "";
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				aux = aux + output;
			}
			
			conn.disconnect();
			return aux;
		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  }
		return null;
	}
}
