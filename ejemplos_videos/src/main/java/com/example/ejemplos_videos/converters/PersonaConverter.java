package com.example.ejemplos_videos.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.ejemplos_videos.entities.Persona;
import com.example.ejemplos_videos.models.PersonaModelo;

@Component("personaConverter")
public class PersonaConverter {
	
	
	@Autowired
	@Qualifier("avatarConverter")
	private AvatarConverter avatarConverter;
	
	@Autowired
	@Qualifier("paisConverter")
	private PaisConverter paisConverter;
	
	public PersonaModelo entityToModelSet(Persona persona) {
		
		
	
		return new PersonaModelo(persona.getId(), persona.getNombre(), persona.getEdad(), persona.getPeso(), 
				persona.getPais(), 	avatarConverter.entityToModel(persona.getAvatar()), paisConverter.entidadAModeloSet(persona.getPaises()));
		
		
	}
	
	
	
	public Persona modelToEntitySet(PersonaModelo personaModelo) {
		
	
		return new Persona(personaModelo.getId(), personaModelo.getNombre(), personaModelo.getEdad(),
				personaModelo.getPeso(), personaModelo.getPais(), 	avatarConverter.modelToEntity(personaModelo.getAvatar()), 
				paisConverter.modeloAEntidadSet(personaModelo.getPaises()));
		
		
	}
	
	
	
	
	public PersonaModelo entityToModel(Persona persona) {
		
		
		
		return new PersonaModelo(persona.getId(), persona.getNombre(), persona.getEdad(), persona.getPeso(), 
				persona.getPais(), 	avatarConverter.entityToModel(persona.getAvatar()));
		
		
	}
	
	
	
	public Persona modelToEntity(PersonaModelo personaModelo) {
		
	
		return new Persona(personaModelo.getId(), personaModelo.getNombre(), personaModelo.getEdad(),
				personaModelo.getPeso(), personaModelo.getPais(), 	avatarConverter.modelToEntity(personaModelo.getAvatar()));
		
		
	}
	
	
	

}
