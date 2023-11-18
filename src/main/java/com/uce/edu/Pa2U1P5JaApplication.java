package com.uce.edu;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.service.IMateriaService;

@SpringBootApplication
public class Pa2U1P5JaApplication implements CommandLineRunner{
	
	@Autowired
	private IMateriaService materiaService;
	@Autowired
	private Materia materia;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5JaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.materia.setCodigo("2134124");
		this.materia.setNombre("Inteligencia Artificial");
		this.materia.setNumeroCreditos(10);
		
		this.materiaService.registrar(materia);
		
		System.out.println("Reporte inicio");
		
		
		List<Materia> reporte= this.materiaService.buscarTodos();
		for(Materia mat : reporte)
			System.out.println(mat);
		
		System.out.println("Reporte fin");
		
		Materia mate=this.materiaService.buscar("2134124");
		System.out.println(mate);
		
		mate.setNumeroCreditos(20);
		
		this.materiaService.actualizar(mate);
		Materia mate2=this.materiaService.buscar("2134124");
		System.out.println(mate2);
		
		
		this.materiaService.eliminar("2134124");
		mate2= this.materiaService.buscar("2134124");
		System.out.println(mate2);
		
		
		
		
		
	}

}
