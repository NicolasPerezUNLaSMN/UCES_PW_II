package com.example.ejemplos_videos.integracion;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ejemplos_videos.controllers.PersonaControlador;
import com.example.ejemplos_videos.converters.PaisConverter;
import com.example.ejemplos_videos.entities.Persona;
import com.example.ejemplos_videos.models.PersonaModelo;
import com.example.ejemplos_videos.services.IAvatarService;
import com.example.ejemplos_videos.services.IPaisService;
import com.example.ejemplos_videos.services.IPersonaService;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;


@SpringBootTest
class TraerPersonasIT {
	
	@Autowired
	@Qualifier("personaService")
	private IPersonaService personaService;
		
	
	@Test
	void traerPersonas() {
		
		List<Persona> lista = personaService.getPersonasCompletas();
		
		for ( Persona p : lista) {
			System.out.println(p);
		}
		
		assertTrue(lista.size()>=1);
		assertNotNull(lista);
		assertSame(lista, lista);
		
		//fail();
		
	}
	
	@Test
	void traerPorId() {
		
		PersonaModelo p= personaService.traerPersonaCompletaPorId(1);
		
	
			System.out.println(p);
		
		assertTrue(p.getId()==1);
	
		//fail();
		
	}
	
	

}
