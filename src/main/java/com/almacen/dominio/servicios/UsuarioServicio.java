package com.almacen.dominio.servicios;

import java.time.LocalDate;

import com.almacen.dominio.entidades.Usuario;

public interface UsuarioServicio<T> {

	Iterable<T> getAll();
	
	T getById(Long id);
	
	Iterable<T> getByPartialName(String nombreParcial);
	
	Iterable<T> getExpired();
	Iterable<T> getExpired(LocalDate fecha);
	
	Usuario login(String email, String password);
	
}
