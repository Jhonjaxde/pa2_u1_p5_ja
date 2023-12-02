package com.uce.edu;

import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Inventario;
import com.uce.edu.inventario.repository.modelo.Producto;
import com.uce.edu.inventario.service.IBodegaService;
import com.uce.edu.inventario.service.IInventarioService;
import com.uce.edu.inventario.service.IProductoService;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;
import com.uce.edu.transferencia.service.ICuentaBancariaService;
import com.uce.edu.transferencia.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U1P5JaApplication implements CommandLineRunner {
	// INYECCION DE DEPENDENCIAS POR ATRIBUTO (DI)
	// es mas directo
	// @Autowired
	// private ITransferenciaService transferenciaService;

	/*
	 * INYECCION DE DEPENDENCIAS POR CONSTRUCTOR (DI)
	 * 
	 * @Autowired private ITransferenciaService transferenciaService;
	 * 
	 * @Autowired public Pa2U1P5JaApplication(ITransferenciaService
	 * iTransferenciaService) { this.transferenciaService= iTransferenciaService; }
	 */
	/*
	 * INYECCION DE DEPENDENCIAS POR METODO (DI) se usa con el metodo set private
	 * ITransferenciaService transferenciaService;
	 * 
	 * @Autowired public void setTransferenciaService(ITransferenciaService
	 * transferenciaService) { this.transferenciaService = transferenciaService; }
	 */

	// @Autowired
	// private ICuentaBancariaService cuentaBancariaService;
	@Autowired
	private IProductoService productoService;
	@Autowired
	private IBodegaService bodegaService;
	@Autowired
	private IInventarioService inventarioService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5JaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 1) crear dos productos
		// 2) crear una bodega
		// 3) Registrar inventario
		// 50 unidades-p1-b1
		// 100 unidades-p2-b1
		// 20 unidades-p1-b1
		Producto p1 = new Producto();
		p1.setCodigoBarras("123456");
		p1.setNombre("HP 15 laptop");
		p1.setStock(0);

		this.productoService.guardar(p1);

		Producto p2 = new Producto();
		p2.setCodigoBarras("654321");
		p2.setNombre("Teclado HP");
		p2.setStock(0);
		this.productoService.guardar(p2);

		Bodega b1 = new Bodega();
		b1.setCapacidad(200);
		b1.setCodigo("8189");
		b1.setDireccion("cumbaya santa maria");
		b1.setNombre("clarita manaba");

		this.bodegaService.guardar(b1);

		 
		this.inventarioService.registrar(p1.getCodigoBarras(), b1.getCodigo(), 50);
		System.out.println(this.inventarioService.buscar("696969"));
		//System.out.println(this.productoService.buscar("123456"));
	}
}
