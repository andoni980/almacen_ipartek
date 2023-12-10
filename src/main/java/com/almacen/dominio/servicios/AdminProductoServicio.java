package com.almacen.dominio.servicios;

import com.almacen.dominio.entidades.Producto;

import static com.almacen.dominio.factoria.FactoriaDispatcher.FACTORIA;

public class AdminProductoServicio  extends UsuarioProductoServicio implements AdminServicio<Producto> {

	@Override
	public Producto save(Producto producto) {
		return FACTORIA.getDaoProducto().save(producto);
	}

	@Override
	public Producto update(Producto producto) {
		return FACTORIA.getDaoProducto().update(producto);
	}

	@Override
	public boolean delete(Long id) {
		return FACTORIA.getDaoProducto().delete(id);

	}
}
