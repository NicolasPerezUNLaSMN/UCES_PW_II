package com.example.ejemplos_videos.integracion;

import static org.assertj.core.api.Assertions.assertThat;


import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.servlet.ModelAndView;

import com.example.ejemplos_videos.controllers.PersonaControlador;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PersonaControladorIT {
	
	@LocalServerPort
	private int port ;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private PersonaControlador controlador;
	
	
	@Test
	public void traerPersonas() {
		
		ModelAndView mAV = controlador.listaPersonas();
	
	
		System.out.println("MODEL" +mAV.getModel());
		
		assertTrue(controlador!=null);
		
	}
	
	@Test
	public void cargarEntorno() throws Exception{
		assertTrue(controlador!=null);
	}
	
	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/personas/listaPersonas",
				String.class)).contains("CRUD");
	}
	
	

}
