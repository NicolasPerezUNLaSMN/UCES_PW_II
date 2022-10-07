package com.example.ejemplos_videos.converters;


import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.ejemplos_videos.entities.Pais;

import com.example.ejemplos_videos.models.PaisModelo;


@Component("paisConverter")
public class PaisConverter {
	
	
	
	public PaisModelo entityToModel(Pais pais) {
		
		
	
		return new PaisModelo(pais.getId(), pais.getNombre(), pais.getRanking());
		
		
	}
	
	
	public Set<PaisModelo> entidadAModeloSet(Set<Pais> paises){
		
		Set<PaisModelo>  lista = new HashSet<>();
		
		for(Pais p: paises) {
			
			lista.add(entityToModel(p));
			
			
		}
		
		
		return lista;
	}
	
	
	public Set<Pais> modeloAEntidadSet(Set<PaisModelo> paises){
		
		Set<Pais>  lista = new HashSet<>();
		
		for(PaisModelo p: paises) {
			
			lista.add(modelToEntity(p));
			
			
		}
		
		
		return lista;
	}
	
	
	
	
	public Pais modelToEntity(PaisModelo paisModelo) {
		
	
		return new Pais(paisModelo.getId(), paisModelo.getNombre(), paisModelo.getRanking());
		
		
	}

}
