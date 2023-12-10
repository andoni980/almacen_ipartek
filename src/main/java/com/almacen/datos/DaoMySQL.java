package com.almacen.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DaoMySQL<T> {
	
	private String url;
	private String user;
	private String password;
	
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			throw new DatosException("No se ha podido leer el driver de MySQL");
		}
	}
	
	public DaoMySQL(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	protected Connection getConexion() {
		try {
			System.out.println(url + " " + user + " " + password);
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new DatosException("No se ha podido realizar la conexión" + url, e);
		}
	}
	
	protected abstract T fromResultSetToObject(ResultSet rs)throws SQLException;
	
	protected abstract PreparedStatement fromObjectToPreparedStatement(T object, PreparedStatement stmt)throws SQLException;

}
