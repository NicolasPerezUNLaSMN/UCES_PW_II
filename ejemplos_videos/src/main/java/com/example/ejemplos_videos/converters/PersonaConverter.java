package com.example.ejemplos_videos.converters;

import org.springframework.stereotype.Component;

import com.example.ejemplos_videos.entities.Persona;
import com.example.ejemplos_videos.models.PersonaModelo;

@Component("personaConverter")
public class PersonaConverter {
	
	public PersonaModelo entityToModel(Persona persona) {
		
		return new PersonaModelo(persona.getId(), persona.getNombre(), persona.getEdad(), persona.getPeso(), persona.getPais());
		
		
	}
	
	
	
	public Persona modelToEntity(PersonaModelo personaModelo) {
		
		return new Persona(personaModelo.getId(), personaModelo.getNombre(), personaModelo.getEdad(), personaModelo.getPeso(), personaModelo.getPais());
		
		
	}

}
