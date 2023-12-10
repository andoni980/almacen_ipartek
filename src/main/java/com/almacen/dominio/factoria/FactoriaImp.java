package com.almacen.dominio.factoria;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import com.almacen.datos.DatosException;
import com.almacen.datos.producto.DaoProducto;
import com.almacen.datos.usuario.DaoUsuario;
import com.almacen.dominio.entidades.Producto;
import com.almacen.dominio.servicios.AdminServicio;
import com.almacen.dominio.servicios.UsuarioServicio;

public class FactoriaImp implements Factoria{

	private final AdminServicio<Producto> adminProductoServicio;
	private final UsuarioServicio<Producto> usuarioProductoServicio;
	private final DaoProducto daoProducto;
	private final DaoUsuario daoUsuario;
	
	@SuppressWarnings("unchecked")
	public FactoriaImp(String rutaFicheroProperties) {
		
		
		try {
			Properties props = new Properties();
			props.load(new FileReader(rutaFicheroProperties));
			
			String tipoDaoProducto = props.getProperty("datos.tipo.producto");
			String tipoDaoUsuario = props.getProperty("datos.tipo.usuario");
			String tipoAdminProductoServicio = props.getProperty("servicios.tipo.adminProducto");
			String tipoUsuarioProductoServicio = props.getProperty("servicios.tipo.usuarioProducto");

			
			String url = props.getProperty("datos.url");
			String user = props.getProperty("datos.user");
			String password = props.getProperty("datos.password");
			
			daoProducto = (DaoProducto)Class.forName(tipoDaoProducto).getConstructor(String.class, String.class, String.class).newInstance(url, user, password);
			daoUsuario = (DaoUsuario)Class.forName(tipoDaoUsuario).getConstructor(String.class, String.class, String.class).newInstance(url,user,password);
			
			adminProductoServicio = (AdminServicio<Producto>)Class.forName(tipoAdminProductoServicio).getConstructor().newInstance();
			usuarioProductoServicio = (UsuarioServicio<Producto>)Class.forName(tipoUsuarioProductoServicio).getConstructor().newInstance();
			
			
			
		} catch (IOException | ClassNotFoundException |  InstantiationException | IllegalAccessException |
				IllegalArgumentException | InvocationTargetException |
				NoSuchMethodException | SecurityException e) {
			throw new DatosException("No se ha podido leer el archivo de propiedades: " + rutaFicheroProperties, e);
		}
	}

	@Override
	public AdminServicio<Producto> getAdminProductoServicio() {
		return adminProductoServicio;
	}

	@Override
	public UsuarioServicio<Producto> getUsuarioProductoServicio() {
		return usuarioProductoServicio;
	}
	
	@Override
	public DaoProducto getDaoProducto() {
		return daoProducto;
	}

	@Override
	public DaoUsuario getDaoUsuario() {
		return daoUsuario;
	}
	
}
