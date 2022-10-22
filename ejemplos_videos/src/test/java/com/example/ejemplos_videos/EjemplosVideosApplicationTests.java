package com.example.ejemplos_videos;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class EjemplosVideosApplicationTests {
	
	
	@Test
	void contextLoads() {
		
			BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
			String passEncriptado = "Nykolai3"; //El pass que quieras para el usuario
			System.out.println("PALABRA: " +passEncriptado +" "+pe.encode(passEncriptado));
		}

}
