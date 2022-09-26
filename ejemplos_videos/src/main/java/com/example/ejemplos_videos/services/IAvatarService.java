package com.example.ejemplos_videos.services;

import com.example.ejemplos_videos.models.AvatarModelo;

import java.util.List;

import com.example.ejemplos_videos.entities.Avatar;
public interface IAvatarService {
	
	
	public List<Avatar> getAll();
	
	public AvatarModelo insertOrUpdate(AvatarModelo avatarModelo);
	
	public boolean remove(int id);

}


