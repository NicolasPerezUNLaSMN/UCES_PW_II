package com.example.ejemplos_videos.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.ejemplos_videos.converters.PaisConverter;
import com.example.ejemplos_videos.converters.PersonaConverter;
import com.example.ejemplos_videos.entities.Pais;
import com.example.ejemplos_videos.entities.Persona;
import com.example.ejemplos_videos.models.PaisModelo;
import com.example.ejemplos_videos.models.PersonaModelo;
import com.example.ejemplos_videos.repositories.IPaisRepository;
import com.example.ejemplos_videos.repositories.IPersonaRepository;
import com.example.ejemplos_videos.services.IPaisService;
import com.example.ejemplos_videos.services.IPersonaService;


@Service("paisService")
public class PaisService implements IPaisService {
	
	@Autowired
	@Qualifier("paisRepository")
	private IPaisRepository paisRepository;
	
	@Autowired
	@Qualifier("paisConverter")
	private PaisConverter paisConverter;
	
	@Override
	public List<Pais> getAll(){	
			
			
		return paisRepository.findAll();	
	}
	
	
	public PaisModelo traerPorId(int id) {
		
		
		return paisConverter.entityToModel(paisRepository.findById(id));
		
	};
	
	
	
	
	public List<PaisModelo> getAllModel(){
		
		List<PaisModelo> listaDePaises = new ArrayList<PaisModelo>();
		
		for (Pais p:getAll() ) {
			
			listaDePaises.add(paisConverter.entityToModel(p));
			
			
		}
	
		
		return listaDePaises;
	}
	
	@Override
	public PaisModelo insertOrUpdate(PaisModelo paisModelo) {
		
	
		
		Pais pais = paisRepository.save(paisConverter.modelToEntity(paisModelo));
		
		return paisConverter.entityToModel(pais);
	}
	
	@Override
	public boolean remove(int id) {
		
		try {
			paisRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
	

}
