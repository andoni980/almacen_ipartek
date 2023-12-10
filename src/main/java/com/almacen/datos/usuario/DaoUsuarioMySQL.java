package com.almacen.datos.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.almacen.datos.DaoMySQL;
import com.almacen.datos.DatosException;
import com.almacen.dominio.entidades.Rol;
import com.almacen.dominio.entidades.Usuario;

public class DaoUsuarioMySQL extends DaoMySQL<Usuario> implements DaoUsuario {

	private static final String SELECT_BY_EMAIL = "SELECT u.id_usuario AS id_usuario, u.nombre AS nombre, u.apellidos AS apellidos, u.email AS email, u.contraseña AS password, r.id_rol AS id_rol, r.nombre AS nombre_rol FROM usuarios AS u JOIN roles AS r ON u.id_rol= r.id_rol WHERE u.email= ?;";

	public DaoUsuarioMySQL(String url, String user, String password) {
		super(url, user, password);
	}

	@Override
	public Usuario getByEmail(String email) {
		
		try (Connection conn = getConexion();
				PreparedStatement stmt = conn.prepareCall(SELECT_BY_EMAIL)) {
			
			stmt.setString(1, email);
			
			Usuario usuario;
			ResultSet rs = stmt.executeQuery();
			
			usuario = null;
			if(rs.next()) {
				usuario = fromResultSetToObject(rs);
			}
			
			return usuario;
			
		} catch (SQLException e) {
			throw new DatosException("No se ha podido ejecutar la consulta getByEmail()", e);
		}
	}

	@Override
	protected Usuario fromResultSetToObject(ResultSet rs) throws SQLException {
	
		Long id_rol = rs.getLong("id_rol");
		String nombre_rol = rs.getString("nombre_rol");
		Rol rol = Rol.builder().id_rol(id_rol).nombre(nombre_rol).build();
		
		Long idUsuario = rs.getLong("id_usuario");
		String nombre = rs.getString("nombre");
		String apellidos = rs.getString("apellidos");
		String email = rs.getString("email");
		String password = rs.getString("password");
		
		return Usuario.builder()
				.id_usuario(idUsuario)
				.nombre(nombre)
				.apellidos(apellidos)
				.email(email)
				.password(password)
				.rol(rol)
				.build();
	}

	@Override
	protected PreparedStatement fromObjectToPreparedStatement(Usuario object, PreparedStatement stmt)
			throws SQLException {
		throw new DatosException("NO IMPLEMENTADO");
	}

}
