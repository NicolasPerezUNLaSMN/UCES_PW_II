package com.example.ejemplos_videos.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="avatar")
public class Avatar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String email;
	
	private String webPersonal;
	
	//Relación no propietaria
	@OneToOne(mappedBy = "avatar")
	private Persona persona;
	
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
	public Avatar(int id, String email, String webPersonal) {
		super();
		this.id = id;
		this.email = email;
		this.webPersonal = webPersonal;
	}
	
	public Avatar() {
		super();
		
	}
	@Override
	public String toString() {
		return "Avatar [id=" + id + ", email=" + email + ", webPersonal=" + webPersonal + ", persona=" + persona + "]";
	}
	
	

}
