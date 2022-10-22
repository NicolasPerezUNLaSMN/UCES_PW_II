package com.example.ejemplos_videos;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.example.ejemplos_videos.controllers.api.v0.FiguritaControladorRest;
import com.example.ejemplos_videos.entities.Figurita;
import com.example.ejemplos_videos.services.IFiguritaService;



///Usaremos Mockito :) Comportamiento sin conectar a base de datos, para que no sea de integración


public class FiguritaControladorTest {
	
		@Autowired
		@Qualifier("figuritaService")
		private IFiguritaService figuritaService;
		
		
			
		@Autowired
		FiguritaControladorRest controladorMock = Mockito.mock(FiguritaControladorRest.class);
		
		//Antes de cada prueba - Simula la conectividad a la bd
		@BeforeEach
		void setUp() {
				
			//Respuesta - Mockeado
			Figurita figuritaMock = new Figurita (1,10,"La de Messi");
				ResponseEntity<Object> respuesta = ResponseEntity.status(HttpStatus.OK).body(figuritaMock);
				
			//Primero instanción los objetos
				Mockito.when(controladorMock.traerFigurita(1 )).thenReturn(respuesta);
				
				
			//Respuesta - Mockeado
			figuritaMock = null;
				respuesta = ResponseEntity.status(HttpStatus.NO_CONTENT).body(figuritaMock);
				
				//Primero instanción los objetos
				Mockito.when(controladorMock.traerFigurita(100 )).thenReturn(respuesta);
			}
			
			
			@Test
			void traerFigurita() {
				
				ResponseEntity<Object> respuesta;
		//		
				respuesta = controladorMock.traerFigurita(1);
				
				Assertions.assertEquals(10,  ((Figurita) (respuesta.getBody())).getNumero());
		
			}
		//	
			@Test
			void traerFiguritaErronea() {
		//		
			ResponseEntity<Object> respuesta;
		//		
			respuesta = controladorMock.traerFigurita(100);
		//		
			Assertions.assertEquals(null,  ((Figurita) (respuesta.getBody())));
		//
			}
	 
}