package com.almacen.dominio.servicios;

import static com.almacen.dominio.factoria.FactoriaDispatcher.FACTORIA;

import java.time.LocalDate;

import com.almacen.dominio.entidades.Producto;
import com.almacen.dominio.entidades.Usuario;

import lombok.extern.java.Log;

@Log
public class UsuarioProductoServicio implements UsuarioServicio<Producto>  {

	@Override
	public Iterable<Producto> getAll() {
		return FACTORIA.getDaoProducto().getAll();
	}

	@Override
	public Producto getById(Long id) {
		return FACTORIA.getDaoProducto().getById(id);
	}

	@Override
	public Iterable<Producto> getByPartialName(String nombreParcial) {
		return FACTORIA.getDaoProducto().getByPartialName(nombreParcial);
	}

	@Override
	public Iterable<Producto> getExpired() {
		return FACTORIA.getDaoProducto().getExpired();
	}

	@Override
	public Iterable<Producto> getExpired(LocalDate fecha) {
		return FACTORIA.getDaoProducto().getExpired(fecha);
	}

	@Override
	public Usuario login(String email, String password) {
				
		Usuario usuario = FACTORIA.getDaoUsuario().getByEmail(email);
		
		if(usuario != null && usuario.getPassword().equals(password)) {
			log.fine(String.format("El usuario %s se ha logueado", email));
			return usuario;
		}
		
		log.warning(String.format("El usuario %s con la contraseña %s no es válido", email, password));
		
		return null;

	}	
}
