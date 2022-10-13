package com.example.ejemplos_videos.controllers.api.v0;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.ejemplos_videos.converters.PaisConverter;
import com.example.ejemplos_videos.entities.Persona;
import com.example.ejemplos_videos.models.AvatarModelo;
import com.example.ejemplos_videos.models.PersonaModelo;
import com.example.ejemplos_videos.models.request.PersonaRequest;
import com.example.ejemplos_videos.services.IAvatarService;
import com.example.ejemplos_videos.services.IPaisService;
import com.example.ejemplos_videos.services.IPersonaService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("api/v0/persona")
public class PersonaControladorRest {
	

	@Autowired
	@Qualifier("personaService")
	private IPersonaService personaService;
	

	@Autowired
	@Qualifier("paisService")
	private IPaisService paisService;
	
	@Autowired
	@Qualifier("avatarService")
	private IAvatarService avatarService;
	
	
	@Autowired
	@Qualifier("paisConverter")
	private PaisConverter paisConverter;
	
	
	
	@GetMapping("/all")
	public ResponseEntity<List<PersonaModelo>> todasLasPersonas(){
		
		List<PersonaModelo> personas = new ArrayList<PersonaModelo>();
		personas.add(new PersonaModelo(1,"Nico", 33, 98.12f, "Argentina"));
		personas.add(new PersonaModelo(2,"Brenda",23, 48.12f, "Brasil"));
		
		return new ResponseEntity<List<PersonaModelo>>(personas, HttpStatus.OK);
		
		
	}
	
	@Operation(summary="Eliminar persona por id", description = "Elimina a la personas con su determinado id y todas sus relaciones Avatar, Figurita, Paises")
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Object> eliminarPersona(@PathVariable("id") int id) {
		
	
	    boolean isRemoved = personaService.remove(id);
	 
	    		
	    if (!isRemoved) {
	    	Object body ="No se puedo eliminar";
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
	    }

	    return ResponseEntity.status(HttpStatus.OK).body("Eliminado id: " +id);
	}
	
	
	
	
	@Operation(summary="Lista de personas", description = "Devuelve la lista de personas con su avatar, sus figuritas y sus paises candidatos")
	@GetMapping("/listaDePersonas")
	public ResponseEntity<Object> todasLasPersonasBD(){
		
		List<Persona> listaPersonas = personaService.getAll();
		
		Object body = "Lista vacia";
				
		if(listaPersonas != null) {
			body = listaPersonas;
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(body);
		
		
	}
	
	
	@Operation(summary="Agrega una persona y su avatar", description = "Seguarda en la base de datos la persona y su correspondiente avatar, figuritas y paises nulos.")
	@PostMapping("/agregarPersona")
	public ResponseEntity<Object> agregar(@RequestBody PersonaRequest persona){
		
		Object body = "";
		HttpStatus status = HttpStatus.CONFLICT;
		
		PersonaModelo p = new PersonaModelo();
		AvatarModelo a = new AvatarModelo();
		
		a.setEmail(persona.getEmail());
		a.setImagen(persona.getImagen());
		a.setWebPersonal(persona.getWebPersonal());
		
		p.setEdad(persona.getEdad());
		p.setNombre(persona.getNombre());
		p.setPais(persona.getPais());
		p.setPeso(persona.getPeso());
		p.setAvatar(a);
		
		try {
			 PersonaModelo personaAgregada = personaService.insertOrUpdate(p); 
			body = personaAgregada;
			status = HttpStatus.CREATED;
		} catch (Exception e) {
			body = "Error de la excepcion: " + e.getMessage(); 
		}
		
		return ResponseEntity.status(status).body(body);
	}
	
	
	
	
	@Operation(summary="Edita una persona y su avatar", description = "Se actualizan los datos de la tabla Persona y Avatar.")
	@PutMapping("/editarPersona/{id}")
	public ResponseEntity<Object> editar(@PathVariable int id, 
			@RequestBody PersonaRequest persona){
		
	
		Object body = "";
		HttpStatus status = HttpStatus.CONFLICT;
		
		
		PersonaModelo p = personaService.traerPorId(id);
		
		p.setEdad(persona.getEdad());
		p.setNombre(persona.getNombre());
		p.setPais(persona.getPais());
		p.setPeso(persona.getPeso());
		p.getAvatar().setEmail(persona.getEmail());
		p.getAvatar().setWebPersonal(persona.getWebPersonal());
		p.getAvatar().setImagen(persona.getImagen());
		
		
		try {
			 PersonaModelo personaAgregada = personaService.insertOrUpdate(p); 
			body = personaAgregada;
			status = HttpStatus.CREATED;
		} catch (Exception e) {
			body = "Error de la excepcion: " + e.getMessage(); 
		}
		
		return ResponseEntity.status(status).body(body);
	}
	
	
	
	

}
