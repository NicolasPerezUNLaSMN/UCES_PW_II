package com.example.ejemplos_videos.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.ejemplos_videos.converters.AvatarConverter;
import com.example.ejemplos_videos.converters.PersonaConverter;
import com.example.ejemplos_videos.entities.Avatar;
import com.example.ejemplos_videos.entities.Persona;
import com.example.ejemplos_videos.models.AvatarModelo;
import com.example.ejemplos_videos.models.PersonaModelo;
import com.example.ejemplos_videos.repositories.IAvatarRepository;
import com.example.ejemplos_videos.repositories.IPersonaRepository;
import com.example.ejemplos_videos.services.IAvatarService;
import com.example.ejemplos_videos.services.IPersonaService;


@Service("avatarService")
public class AvatarService implements IAvatarService {
	
	@Autowired
	@Qualifier("avatarRepository")
	private IAvatarRepository avatarRepository;
	
	@Autowired
	@Qualifier("avatarConverter")
	private AvatarConverter avatarConverter;
	
	@Override
	public List<Avatar> getAll(){	
		return avatarRepository.findAll();	
	}
	
	@Override
	public AvatarModelo insertOrUpdate(AvatarModelo avatarModelo) {
		
		Avatar avatar = avatarRepository.save(avatarConverter.modelToEntity(avatarModelo));
		
		return avatarConverter.entityToModel(avatar);
	}
	
	@Override
	public boolean remove(int id) {
		
		try {
			avatarRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
	

}
