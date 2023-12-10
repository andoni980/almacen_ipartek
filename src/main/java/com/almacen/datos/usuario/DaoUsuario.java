package com.almacen.datos.usuario;

import com.almacen.datos.Dao;
import com.almacen.dominio.entidades.Usuario;

public interface DaoUsuario extends Dao<Usuario>{
	
	Usuario getByEmail(String email);

}
