package com.example.ejemplos_videos.converters;

import org.springframework.stereotype.Component;

import com.example.ejemplos_videos.entities.Avatar;
import com.example.ejemplos_videos.models.AvatarModelo;

@Component("avatarConverter")
public class AvatarConverter {
	
	public AvatarModelo entityToModel(Avatar avatar) {
		
		return new AvatarModelo(avatar.getId(), avatar.getEmail(), avatar.getWebPersonal());
		
		
	}
	
	
	
	public Avatar modelToEntity(AvatarModelo avatarModelo) {
		
		return new Avatar(avatarModelo.getId(), avatarModelo.getEmail(), avatarModelo.getWebPersonal());
		
		
	}

}
