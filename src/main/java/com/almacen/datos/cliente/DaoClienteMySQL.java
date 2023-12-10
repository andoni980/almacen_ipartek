package com.almacen.datos.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.almacen.datos.DaoMySQL;
import com.almacen.datos.DatosException;
import com.almacen.dominio.entidades.Cliente;

public class DaoClienteMySQL extends DaoMySQL<Cliente> implements DaoCliente{
	
	private static final String SELECT_ALL = null;
	
	public DaoClienteMySQL(String url, String user, String password) {
		super(url, user, password);
	}


	@Override
	public Iterable<Cliente> getAll(){
		
		try (	Connection conn = getConexion();
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rs = stmt.executeQuery()) {
			
			List<Cliente> clientes = new ArrayList<Cliente>();
			Cliente cliente;
			
			while(rs.next()) {
				
				cliente = fromResultSetToObject(rs); 
				clientes.add(cliente);
			}
			
			return clientes;
			
		} catch (SQLException e) {
			throw new DatosException("No se ha podido hacer la consulta getAllClientes()", e);
		}
	}
	

	@Override
	protected Cliente fromResultSetToObject(ResultSet rs) throws SQLException {
		Long idCliente = rs.getLong("id_cliente");
		String nombre = rs.getString("nombre");
		String apellidos = rs.getString("apellidos");
		String telefono = rs.getString("telefono");
		String direccion = rs.getString("direccion");
		String correoElectronico = rs.getString("correo_electronico");
//		var ficheros = rs.getBlob("ficheros");
		String nif = rs.getString("nif");
		
	return Cliente.builder()
			.idCliente(idCliente)
			.nombre(nombre)
			.apellidos(apellidos)
			.telefono(telefono)
			.direccion(direccion)
			.correoElectronico(correoElectronico)
//			.ficheros(ficheros)
			.nif(nif)
			.build();
	}


	@Override
	protected PreparedStatement fromObjectToPreparedStatement(Cliente object, PreparedStatement stmt)
			throws SQLException {
		throw new DatosException("NO IMPLEMENTADO");
	}

}
