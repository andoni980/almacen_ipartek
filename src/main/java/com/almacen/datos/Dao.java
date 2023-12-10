package com.almacen.datos;

public interface Dao<T> {

	default Iterable<T> getAll(){
		throw new DatosException("No Implementado");
	}
	
	default T getById(Long id) {
		throw new DatosException("No Implementado");
	}
	
	default T save(T obj) {
		throw new DatosException("No Implementado");
	}
	
	default T update(T obj) {
		throw new DatosException("No Implementado");
	}
	
	default boolean delete(Long id) {
		throw new DatosException("No Implementado");
	}
	
}
