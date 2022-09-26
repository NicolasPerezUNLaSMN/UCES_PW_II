package com.example.ejemplos_videos.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class AvatarModelo {
	
	
	private int id;
	
	@Email
	@Size(min=10, max =20)
	private String email;
	
	@Size(min=5, max =40)
	private String webPersonal;
	
	private PersonaModelo persona;
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebPersonal() {
		return webPersonal;
	}
	public void setWebPersonal(String webPersonal) {
		this.webPersonal = webPersonal;
	}
	public AvatarModelo(int id, String email, String webPersonal) {
		super();
		this.id = id;
		this.email = email;
		this.webPersonal = webPersonal;
	}
	
	
	
	public AvatarModelo() {
		super();
		
	}
	public PersonaModelo getPersona() {
		return persona;
	}
	public void setPersona(PersonaModelo persona) {
		this.persona = persona;
	}
	public AvatarModelo(int id, @Email @Size(min = 10, max = 20) String email,
			@Size(min = 5, max = 40) String webPersonal, PersonaModelo persona) {
		super();
		this.id = id;
		this.email = email;
		this.webPersonal = webPersonal;
		this.persona = persona;
	}
	
	
	

}
