package com.example.ejemplos_videos.services.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.ejemplos_videos.converters.PersonaConverter;
import com.example.ejemplos_videos.entities.Avatar;
import com.example.ejemplos_videos.entities.Figurita;
import com.example.ejemplos_videos.entities.Pais;
import com.example.ejemplos_videos.entities.Persona;
import com.example.ejemplos_videos.models.PaisModelo;
import com.example.ejemplos_videos.models.PersonaModelo;
import com.example.ejemplos_videos.repositories.IAvatarRepository;
import com.example.ejemplos_videos.repositories.IPersonaRepository;
import com.example.ejemplos_videos.services.IPersonaService;


@Service("personaService")
public class PersonaService implements IPersonaService {
	
	@Autowired
	@Qualifier("personaRepository")
	private IPersonaRepository personaRepository;
	
	@Autowired
	@Qualifier("personaConverter")
	private PersonaConverter personaConverter;
	
	
	
	
	@Autowired
	@Qualifier("avatarRepository")
	private IAvatarRepository avatarRepository;
	
	@Override
	public List<Persona> getAll(){	
			
			
		return personaRepository.findAll();	
	}
	
	
	public PersonaModelo traerPorId(int id) {
		
		
		return personaConverter.entityToModel(personaRepository.findById(id));
		
	};
	
	
	public PersonaModelo traerPersonaCompletaPorId(int id) {
		
		List<Persona> listaEntidad = getPersonasCompletas();
		PersonaModelo personaEncontrada = new PersonaModelo();
		for (Persona p: listaEntidad) {
			
			if(p.getId() == id) {
				
				personaEncontrada = personaConverter.entityToModel(p);
				
			}
			
			
		}
		return personaEncontrada;
	}
	
	
	public List<Persona> getPersonasCompletas(){
		
		List<Persona> personas = getAll();
		
		for (Persona p: personas) {
			
			Avatar avatar = avatarRepository.findById(p.getAvatar().getId());
			
			
			Set<Pais> paises = paisesDeLaPersona(p.getId());
			Set<Figurita> figuritas = figuritasDeLaPersona(p.getId());
			
			if(avatar != null) {
				p.setAvatar(avatar);
			}
			
			
			if(paises!=null) {
			p.setPaises(paises);
			}
			
			if(figuritas!=null) {
			p.setFiguritas(figuritas);
			}
		}
		
		return personas;
	}
	
	public List<PersonaModelo> getAllModel(){
		
		List<PersonaModelo> listaDePersonas = new ArrayList<PersonaModelo>();
		
		for (Persona p:getAll() ) {
			
			listaDePersonas.add(personaConverter.entityToModel(p));
			
			
		}
	
		
		return listaDePersonas;
	}
	
	@Override
	public PersonaModelo insertOrUpdate(PersonaModelo personaModelo) {
		
	
		
		Persona persona = personaRepository.save(personaConverter.modelToEntity(personaModelo));
		
		return personaConverter.entityToModel(persona);
	}
	
	
	
	public Set<Pais> paisesDeLaPersona(int id) {
		
		Persona p = personaRepository.findByIdAndFetchPaisesEagerly(id);
		System.out.println(p);
		Set<Pais> lista = new HashSet<>();
		if (p!=null) {
			if(p.getPaises()!=null) {
				lista = p.getPaises();
			}
		}
		return lista;
	}
	
	
	public Set<Figurita> figuritasDeLaPersona(int id) {
		
		Persona p = personaRepository.findByIdAndFetchFiguritasEagerly(id);
		
		Set<Figurita> lista = new HashSet<>();
		if (p!=null) {
			if(p.getFiguritas()!=null) {
					lista = p.getFiguritas();
			}
		}
		return lista;
	}
	
	
	
	
	
	
	
	
	@Override
	public PersonaModelo insertOrUpdateSet(PersonaModelo personaModelo) {
		
	
		
		Persona persona = personaRepository.save(personaConverter.modelToEntitySet(personaModelo));
		
		return personaConverter.entityToModelSet(persona);
	}
	
	
	@Override
	public boolean remove(int id) {
		
		try {
			personaRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}

	
	@Override
	public boolean remove(Long id) {
		
		try {
			personaRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
	

}
