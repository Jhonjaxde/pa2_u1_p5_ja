package com.uce.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Materia;
@Repository
public class MateriaRepositoryImpl implements IMateriaRepository{
	//este es el mockeo de la base de datos
	private static List<Materia> base= new ArrayList<>();
	// el this es una referencia de una instancia
	// pero un atributo estatico que no pertenece a la clase
	@Override
	public Materia seleccionar(String codigo) {
		
		System.out.println("seleccionamos:"+ codigo);
		for(Materia mate:base) {
			if(mate.getCodigo().equals(codigo)) {
				return mate;
			}
		}
		return null;
	}

	@Override
	public void insertar(Materia materia) {
		base.add(materia);
		System.out.println("Se inserto:"+ materia);
		
	}

	@Override
	public void actualizar(Materia materia) {
		this.borrar(materia.getCodigo());
		this.insertar(materia);
		System.out.println("Se actualiza:" + materia);
		
	}

	@Override
	public void borrar(String codigo) {
		Materia mate = this.seleccionar(codigo);
		base.remove(mate);
		System.out.println("Se borra:"+ codigo);
		
	}

	@Override
	public List<Materia> seleccionarTodos() {
		// TODO Auto-generated method stub
		return base;
	}

	

		
	
}
