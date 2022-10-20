package com.example.ejemplos_videos;

import java.util.List;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.ModelAndView;

import com.example.ejemplos_videos.controllers.PersonaControlador;
import com.example.ejemplos_videos.converters.PaisConverter;

import com.example.ejemplos_videos.entities.Persona;
import com.example.ejemplos_videos.services.IAvatarService;

import com.example.ejemplos_videos.services.IPaisService;
import com.example.ejemplos_videos.services.IPersonaService;


public class PersonaControladorTest {
	
	
	@Autowired
	private IPersonaService personaServiceMock = Mockito.mock(IPersonaService.class);
	
	@Autowired
	private IPaisService paisServiceMock= Mockito.mock(IPaisService.class);
	
	@Autowired
	private IAvatarService avatarServiceMock = Mockito.mock(IAvatarService.class);
	
	@Autowired
	private PersonaControlador personaControladorMock = Mockito.mock(PersonaControlador.class);
	
	@Autowired
	@Qualifier("paisConverter")
	private PaisConverter paisConverter;
	
	//Antes de cada prueba - Simula la conectividad a la bd
	/*
	@BeforeEach
	void setUp() {
		
		//Respuesta - Mockeado
		Figurita figuritaMock = new Figurita (1,10,"La de Messi");
		ResponseEntity<Object> respuesta = ResponseEntity.status(HttpStatus.OK).body(figuritaMock);
		
		//Primero instanción los objetos
		Mockito.when(controladorMock.traerFigurita(1 )).thenReturn(respuesta);
		
	
	}
	
	*/
	
	

	@Test
	void traerPersonasService() {
		
		List<Persona> lista = personaServiceMock.getAll();
		

		
		Assertions.assertEquals(lista ,  lista);

	}

	
	
	@Test
	void traerPersonasControlador() {
		
		ModelAndView lista = personaControladorMock.listaPersonas();
		

		
		Assertions.assertEquals(lista ,  lista);

	}

}
