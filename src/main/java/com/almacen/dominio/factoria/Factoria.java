package com.almacen.dominio.factoria;

import com.almacen.datos.producto.DaoProducto;
import com.almacen.datos.usuario.DaoUsuario;
import com.almacen.dominio.entidades.Producto;
import com.almacen.dominio.servicios.AdminServicio;
import com.almacen.dominio.servicios.UsuarioServicio;

public interface Factoria {
	
	DaoProducto getDaoProducto();

	DaoUsuario getDaoUsuario();
	
	UsuarioServicio<Producto> getUsuarioProductoServicio();

	AdminServicio<Producto> getAdminProductoServicio();
}
