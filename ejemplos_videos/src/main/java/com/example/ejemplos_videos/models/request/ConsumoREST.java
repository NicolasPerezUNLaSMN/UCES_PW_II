package com.example.ejemplos_videos.models.request;

import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumoREST {
	
	
		@GetMapping("/bromaAleatoria")
		private String bromaAleatoria() {
			
			String url = "https://official-joke-api.appspot.com/random_joke";
			
			RestTemplate restTemplate = new RestTemplate();
			
			String broma = restTemplate.getForObject(url,  String.class);
			
			return broma;
		}
		
		
		@GetMapping("/traerPaises")
		private List<Object> traerPaises() {
			
			String url = "https://restcountries.com/v2/all";
			
			RestTemplate restTemplate = new RestTemplate();
			
			Object[] paises = restTemplate.getForObject(url,  Object[].class);
			
			System.out.println(paises[0]);
			
			return Arrays.asList(paises);
		}
		
		
		@GetMapping("/traerPersonasExterno")
		private String[] traerPersonasExterno() {
			
			
			
			String url = "http://localhost:8080/api/v0/persona/listaDePersonas";
			
			RestTemplate restTemplate = new RestTemplate();
			
			String[] persona = restTemplate.getForObject(url,  String[].class);
			
			System.out.println(persona);
			
			return persona;
		}

}
