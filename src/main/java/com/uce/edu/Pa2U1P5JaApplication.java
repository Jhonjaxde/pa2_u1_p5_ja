package com.uce.edu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pa2U1P5JaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5JaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//TODO Auto-generated method stub
		System.out.println("hola "+"mundo");
		System.out.println("Soy"+" "+"Jhon"+" "+"Arteaga");
		System.out.println("cambio en la misma rama");
		System.out.println("taller4");
		
	}

}
