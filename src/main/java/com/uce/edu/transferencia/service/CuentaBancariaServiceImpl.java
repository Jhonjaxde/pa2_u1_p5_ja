package com.uce.edu.transferencia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {
	
	@Autowired
	private ICuentaBancariaRepository cuentaBancariaRepository;
	
	@Override
	public CuentaBancaria buscar(String numero) {
		// TODO Auto-generated method stub
		return this.cuentaBancariaRepository.seleccionar(numero);
	}

	@Override
	public void guardar(CuentaBancaria cuentaBancaria) {
		this.cuentaBancariaRepository.insertar(cuentaBancaria);

	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		this.cuentaBancariaRepository.actualizar(cuentaBancaria);

	}

	@Override
	public void eliminar(String numero) {
		this.cuentaBancariaRepository.eliminar(numero);

	}

}
