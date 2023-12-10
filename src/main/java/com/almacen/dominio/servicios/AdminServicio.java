package com.almacen.dominio.servicios;

public interface AdminServicio<T> extends UsuarioServicio<T> {

	T save(T objet);
	T update(T objet);
	boolean delete(Long id);
	
}
