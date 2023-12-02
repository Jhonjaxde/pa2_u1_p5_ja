package com.uce.edu.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.inventario.repository.modelo.Bodega;

@Repository
public class BodegaRepositoryImpl implements IBodegaRepository {
	private List<Bodega> base = new ArrayList<Bodega>();

	@Override
	public Bodega seleccionar(String codigo) {
		for (Bodega bodega : base) {
			if (bodega.getCodigo().equals(codigo)) {
				Bodega bod = new Bodega();
				bod.setCapacidad(bodega.getCapacidad());
				bod.setCodigo(bodega.getCodigo());
				bod.setDireccion(bodega.getDireccion());
				bod.setNombre(bodega.getNombre());
				return bodega;
			}
		}
		return null;
	}

	@Override
	public void insertar(Bodega bodega) {
		base.add(bodega);

	}

	@Override
	public void actualizar(Bodega bodega) {
		this.eliminar(bodega.getNombre());
		this.insertar(bodega);

	}

	@Override
	public void eliminar(String codigo) {
		Bodega bodega = this.seleccionar(codigo);
		base.remove(bodega);

	}

}
