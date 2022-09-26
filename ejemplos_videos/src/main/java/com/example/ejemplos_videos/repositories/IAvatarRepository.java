package com.example.ejemplos_videos.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ejemplos_videos.entities.Avatar;
import com.example.ejemplos_videos.entities.Persona;

@Repository("avatarRepository")
public interface IAvatarRepository extends 
						JpaRepository<Avatar, Serializable> {
	
	
	public abstract Avatar findById(int id);
	
	

	

}
