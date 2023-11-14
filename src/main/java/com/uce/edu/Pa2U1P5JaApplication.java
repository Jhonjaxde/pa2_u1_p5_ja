package com.uce.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ioc.di.Estudiante;

@SpringBootApplication
public class Pa2U1P5JaApplication implements CommandLineRunner{
	// Para hacer inyeccion de dependencias 
	// declaramos un atributo de la clase estudiante 
	// usamos una anotaciones de nivel de atributo 
	@Autowired
	private Estudiante estudiante;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5JaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
	this.estudiante.setNombre("Jhon");	
	this.estudiante.setApellido("Arteaga");
	this.estudiante.setCedula("1708923873");
	this.estudiante.setSalario(new BigDecimal(100));
	// AQUI SE DESTRUYE porque ya no se lo utiliza pero se 
	//encarga el garbage collector
	System.out.println(estudiante);
		
		
	}

}
