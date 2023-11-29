package com.uce.edu;


import java.util.List;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;
import com.uce.edu.transferencia.service.ICuentaBancariaService;
import com.uce.edu.transferencia.service.ITransferenciaService;


@SpringBootApplication
public class Pa2U1P5JaApplication implements CommandLineRunner {
	//INYECCION DE DEPENDENCIAS POR ATRIBUTO (DI)
	// es mas directo
	@Autowired
	private ITransferenciaService transferenciaService;
	
	/*INYECCION DE DEPENDENCIAS POR CONSTRUCTOR (DI)
	@Autowired
	private ITransferenciaService transferenciaService; 
	
	@Autowired
	public Pa2U1P5JaApplication(ITransferenciaService iTransferenciaService) {
		this.transferenciaService= iTransferenciaService;
	}*/
	/*INYECCION DE DEPENDENCIAS POR METODO (DI)
	 * se usa con el metodo set 
	private ITransferenciaService transferenciaService;
	
	@Autowired
	public void setTransferenciaService(ITransferenciaService transferenciaService) {
		this.transferenciaService = transferenciaService;
	}*/
	
	@Autowired
	private ICuentaBancariaService cuentaBancariaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5JaApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {

		// 1. Crear cuentas
		CuentaBancaria ctaOrigen = new CuentaBancaria();
		ctaOrigen.setCedulaPropietario("1752083905");
		ctaOrigen.setNumero("1234");
		ctaOrigen.setSaldo(new BigDecimal(100));

		this.cuentaBancariaService.guardar(ctaOrigen);

		// ctadestino
		CuentaBancaria ctaDestino = new CuentaBancaria();
		ctaDestino.setCedulaPropietario("1234658790");
		ctaDestino.setNumero("5678");
		ctaDestino.setSaldo(new BigDecimal(200));
		this.cuentaBancariaService.guardar(ctaDestino);

		this.transferenciaService.realizar("1234", "5678", new BigDecimal(30));
		// System.out.println(ctaOrigen.hashCode());
		// System.out.println(ctaDestino.hashCode());

		//CuentaBancaria ctaOrigen1 = this.cuentaBancariaService.buscar("1234");
		// System.out.println(ctaOrigen1);
		//CuentaBancaria ctaDestino1 = this.cuentaBancariaService.buscar("5678");
		// System.out.println(ctaDestino1);
		this.transferenciaService.realizar("1234", "5678", new BigDecimal(50));
		this.transferenciaService.realizar("5678", "1234", new BigDecimal(10));
		// hascode para ver la direccion de un objeto
		// construir un reporte de cuenta de todas las transferencia
		// un for en la main
		List<Transferencia> reporte = this.transferenciaService.buscarTodos();
		// reporte.add();
		int indice = 0;
		for (Transferencia trans : reporte) {
			indice++;
			System.out.println(indice + " : " + trans);

		}
		
		CuentaBancaria ctaOrigen1 = this.cuentaBancariaService.buscar("1234");
		 System.out.println(ctaOrigen1);
		CuentaBancaria ctaDestino1 = this.cuentaBancariaService.buscar("5678");
		 System.out.println(ctaDestino1);
		 this.cuentaBancariaService.depositar("5678",  new BigDecimal(10));
	}
}
