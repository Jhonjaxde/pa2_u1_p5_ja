package com.uce.edu.transferencia.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;

@Repository
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository{
	
	private static List<CuentaBancaria> base= new ArrayList<CuentaBancaria>();
	
	@Override
	public CuentaBancaria seleccionar(String numero) {
		//System.out.println("seleccionamos:"+ numero);
		for(CuentaBancaria cuentaBancaria:base) {
			if(cuentaBancaria.getNumero().equals(numero)) {
				CuentaBancaria cta = new CuentaBancaria();
				cta.setCedulaPropietario(cuentaBancaria.getCedulaPropietario());
				cta.setNumero(cuentaBancaria.getNumero());
				cta.setSaldo(cuentaBancaria.getSaldo());
				return cuentaBancaria;
			}
		}
		return null;
	}

	@Override
	public void insertar(CuentaBancaria cuentaBancaria) {
		base.add(cuentaBancaria);
		//System.out.println("Se inserto:"+ materia);
		
	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		this.eliminar(cuentaBancaria.getNumero());
		this.insertar(cuentaBancaria);
		//System.out.println("Se actualiza:" + materia);
		
	}

	@Override
	public void eliminar(String numero) {
		CuentaBancaria cuentaBancaria = this.seleccionar(numero);
		base.remove(cuentaBancaria);
		//System.out.println("Se borra:"+ numero);
		
	}

	@Override
	public CuentaBancaria seleccionarEliminar(String numero) {
		for(CuentaBancaria cuentaBancaria:base) {
			if(cuentaBancaria.getNumero().equals(numero)) {
			
				return cuentaBancaria;
			}
			}
		return null;
	}

}
