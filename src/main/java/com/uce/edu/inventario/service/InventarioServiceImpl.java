package com.uce.edu.inventario.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.inventario.repository.IBodegaRepository;
import com.uce.edu.inventario.repository.IInventarioRepository;
import com.uce.edu.inventario.repository.IProductoRepository;
import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Inventario;
import com.uce.edu.inventario.repository.modelo.Producto;

@Service
public class InventarioServiceImpl implements IInventarioService {
	@Autowired
	private IBodegaRepository bodegaRepository;

	@Autowired
	private IProductoRepository productoRepository;
	@Autowired
	private IInventarioRepository inventarioRepository;

	@Override
	public Inventario buscar(String codigo) {
		// TODO Auto-generated method stub
		return this.inventarioRepository.seleccionar(codigo);
	}

	@Override
	public void guardar(Inventario inventario) {
		this.inventarioRepository.insertar(inventario);

	}

	@Override
	public void actualizar(Inventario inventario) {
		this.inventarioRepository.actualizar(inventario);

	}

	@Override
	public void eliminar(String codigo) {
		this.eliminar(codigo);

	}

	@Override
	public void registrar(String codigoBodega, String codigoBarras, Integer stock) {
		Bodega bodega = this.bodegaRepository.seleccionar(codigoBodega);
		Producto producto = this.productoRepository.seleccionar(codigoBarras);
		Integer stockActual = producto.getStock();
		Integer stockFinal = stockActual + stock;
		producto.setStock(stockFinal);
		this.productoRepository.actualizar(producto);
		Inventario inv = new Inventario();
		inv.setCodigo("696969");
		inv.setFechaIngreso(LocalDateTime.now());
		inv.setBodega(bodega);
		inv.setProducto(producto);
		
		this.inventarioRepository.insertar(inv);
		

	}

}
