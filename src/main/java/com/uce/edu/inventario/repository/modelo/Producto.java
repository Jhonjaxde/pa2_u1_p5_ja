package com.uce.edu.inventario.repository.modelo;

import org.springframework.stereotype.Component;

@Component
public class Producto {
	
	private String nombre;
	private Integer Stock;
	private String codigoBarras;
	
	//SET Y GET
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getStock() {
		return Stock;
	}
	public void setStock(Integer stock) {
		Stock = stock;
	}
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", Stock=" + Stock + ", codigoBarras=" + codigoBarras + "]";
	}
	

}
