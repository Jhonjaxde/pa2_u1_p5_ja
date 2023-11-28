package com.uce.edu.transferencia.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.uce.edu.transferencia.repository.modelo.Transferencia;

@Repository
public class TransferenciaRepositoryImpl implements ITransferenciaRepository{
	
	private static List<Transferencia> base= new ArrayList<Transferencia>();
	@Override
	public Transferencia seleccionar(String numero) {
		//System.out.println("seleccionamos:"+ numero);
		for(Transferencia transferencia:base) {
			if(transferencia.getNumero().equals(numero)) {
				return transferencia;
			}
		}
		return null;
	}

	@Override
	public void insertar(Transferencia transferencia) {
		base.add(transferencia);
		//System.out.println("Se inserto:"+ transferencia);
		
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		this.eliminar(transferencia.getNumero());
		this.insertar(transferencia);
		//System.out.println("Se actualiza:" + transferencia);
		
	}

	@Override
	public void eliminar(String numero) {
		Transferencia transferencia = this.seleccionar(numero);
		base.remove(transferencia);
		//System.out.println("Se borra:"+ numero);
		
	}

	@Override
	public List<Transferencia> seleccionarTodos() {
		
		return base;
	}

}
