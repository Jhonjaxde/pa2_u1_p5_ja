package com.uce.edu.transferencia.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;

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

	@Override
	public CuentaBancaria seleccionarEliminar(String numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void depositar(String numeroCuenta, BigDecimal monto) {
		CuentaBancaria cta = this.cuentaBancariaRepository.seleccionar(numeroCuenta);
		BigDecimal saldo = cta.getSaldo();
		if (saldo.compareTo(monto) >= 0) {
			BigDecimal nuevoSaldo = saldo.multiply(new BigDecimal(0.9));
			cta.setSaldo(nuevoSaldo);
			this.cuentaBancariaRepository.actualizar(cta);
			CuentaBancaria deposito = new CuentaBancaria();
			deposito.setCedulaPropietario(cta.getCedulaPropietario());
			deposito.setNumero(numeroCuenta);
			deposito.setSaldo(nuevoSaldo);
		}else {
			System.out.println("Saldo no disponible");

		}
	}

	

}
