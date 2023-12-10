package com.almacen.datos.producto;

import java.time.LocalDate;

import com.almacen.datos.Dao;
import com.almacen.dominio.entidades.Producto;

public interface DaoProducto extends Dao<Producto>{

	Iterable<Producto> getByPartialName(String nombre);
	Iterable<Producto> getExpired(LocalDate fecha);
	Iterable<Producto> getExpired();
	
}
