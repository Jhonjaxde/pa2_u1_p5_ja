package com.uce.edu.transferencia.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.ITransferenciaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;
@Service
public class TransferenciaServiceImpl implements ITransferenciaService {
	@Autowired
	private ITransferenciaRepository transferenciaRepository;
	@Autowired
	private ICuentaBancariaRepository cuentaBancariaRepository;
	@Override
	public Transferencia buscar(String numero) {
		// TODO Auto-generated method stub
		return this.transferenciaRepository.seleccionar(numero);
	}

	@Override
	public void guardar(Transferencia transferencia) {
		this.transferenciaRepository.insertar(transferencia);

	}

	@Override
	public void actualizar(Transferencia transferencia) {
		this.transferenciaRepository.actualizar(transferencia);

	}

	@Override
	public void eliminar(String numero) {
		this.transferenciaRepository.eliminar(numero);
	}

	@Override
	public void realizar(String numeroOrigen, String numeroDestino, BigDecimal monto) {
		//1. Buscar la cuenta Origen 
		CuentaBancaria ctaOrigen= this.cuentaBancariaRepository.seleccionar(numeroOrigen);
		//2. Consultar el saldo
		//3. Validar el saldo
		//4. Restar el monto
		//5. Actualizar la cuenta Origen
		
		//6. Buscar la cuenta Destino
		//7. consultar el saldo(para sumarle)
		//8. Sumar el monto
		//9. Actualizar la cuenta Destino
		//10.Crear la transferencia
		
		
	}

}
