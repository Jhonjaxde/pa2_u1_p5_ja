package com.uce.edu.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.inventario.repository.modelo.Producto;
@Repository
public class ProductoRepositoryImpl implements IProductoRepository {
	private List<Producto> base = new ArrayList<Producto>();
	@Override
	public Producto seleccionar(String codigoBarras) {
		for (Producto producto : base) {
			if (producto.getCodigoBarras().equals(codigoBarras)) {
				Producto pro = new Producto();
				pro.setCodigoBarras(producto.getCodigoBarras());
				pro.setNombre(producto.getNombre());
				pro.setNombre(producto.getNombre());
				return producto;
			}
		}
		return null;
	}

	@Override
	public void insertar(Producto producto) {
		base.add(producto);

	}

	@Override
	public void actualizar(Producto producto) {
		this.eliminar(producto.getCodigoBarras());
		this.insertar(producto);

	}

	@Override
	public void eliminar(String codigoBarras) {
		Producto producto = this.seleccionar(codigoBarras);
		base.remove(producto);
	}

}
