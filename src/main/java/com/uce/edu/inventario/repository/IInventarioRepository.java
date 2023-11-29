package com.uce.edu.inventario.repository;

import com.uce.edu.inventario.repository.modelo.Bodega;

public interface IInventarioRepository {
	public Bodega seleccionar(String numero);

	public void insertar(Bodega bodega);

	public void actualizar(Bodega bodega);

	public void eliminar(String numero);
}
