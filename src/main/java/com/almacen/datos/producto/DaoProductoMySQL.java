package com.almacen.datos.producto;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.almacen.datos.DaoMySQL;
import com.almacen.datos.DatosException;
import com.almacen.dominio.entidades.Producto;

public class DaoProductoMySQL extends DaoMySQL<Producto> implements DaoProducto {
	
	private static final String SELECT_ALL = 
			"SELECT id_producto, nombre, id_categoria, codigo_barras, precio_venta, cantidad_stock, estado, fecha_caducidad FROM productos";
	private static final String SELECT_BY_ID = SELECT_ALL + " WHERE id_producto = ?;";
	private static final String INSERT = "INSERT INTO productos(nombre, id_categoria, codigo_barras, precio_venta, cantidad_stock, estado, fecha_caducidad) VALUES(?,?,?,?,?,?,?);";
	private static final String UPDATE = "UPDATE productos SET nombre=?, id_categoria=?, codigo_barras=?, precio_venta=?, cantidad_stock=?, estado=?, fecha_caducidad=? WHERE id_producto=?;";
	private static final String DELETE = "DELETE FROM productos WHERE id_producto=?;";
	private static final String SELECT_BY_PARTIAL_NAME = SELECT_ALL + " WHERE nombre LIKE ?;";
	private static final String SELECT_EXPIRED = SELECT_ALL + " WHERE fecha_caducidad < ?;";
	
	public DaoProductoMySQL(String url, String user, String password) {
		super(url, user, password);
	}



	@Override
	public Iterable<Producto> getAll() {
		
		try (	Connection conn = getConexion();
				PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
				ResultSet rs = stmt.executeQuery()) {
			
			List<Producto> productos = new ArrayList<Producto>();
			Producto producto;
			
			while(rs.next()) {
				
				producto = fromResultSetToObject(rs); 
				productos.add(producto);
			}
			
			return productos;
			
		} catch (SQLException e) {
			throw new DatosException("No se ha podido hacer la consulta getAllProductos()", e);
		}
	}

	@Override
	public Producto getById(Long id) {
		
		try (	Connection conn = getConexion();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
			
			stmt.setLong(1, id);
			
			Producto producto;
			try (ResultSet rs = stmt.executeQuery()) {
				producto = null;
				
				if(rs.next()) {
					producto = fromResultSetToObject(rs);
				}

				return producto;
			}
			
		} catch (SQLException e) {
			throw new DatosException("No se ha podido realizar la consulta getById() para el id " + id, e);
		}
	}

	@Override
	public Producto save(Producto producto) {
		
		try (	Connection conn = getConexion();
				PreparedStatement stmt = conn.prepareStatement(INSERT)) {
			
			fromObjectToPreparedStatement(producto, stmt);
			int numeroRegistrosInsertados = stmt.executeUpdate();
			
			if(numeroRegistrosInsertados != 1) {
				 throw new DatosException("Numero de registros insertados diferente de 1 " + numeroRegistrosInsertados);
			}
			
			return producto;
			
		} catch (SQLException e) {
			throw new DatosException("No se ha podido realizar la consulta save() ", e);
		}
	}


	@Override
	public Producto update(Producto producto) {
		
		try (	Connection conn = getConexion();
				PreparedStatement stmt = conn.prepareStatement(UPDATE)) {
			
			fromObjectToPreparedStatement(producto, stmt);
			
			int numeroRegistrosModificados = stmt.executeUpdate();
			
			if(numeroRegistrosModificados != 1) {
				throw new DatosException("El numero de registros modificados es diferente de 1");
			}
			
			return producto;
			
		} catch (SQLException e) {
			throw new DatosException("No se ha podido realizar la consulta update() ", e);
		}
	}

	@Override
	public boolean delete(Long id) {
		
		try (Connection conn = getConexion();
				PreparedStatement stmt = conn.prepareStatement(DELETE)) {
			
			stmt.setLong(1,id);
			
			int numeroRegistrosEliminados = stmt.executeUpdate();
			
			if(numeroRegistrosEliminados != 1) {
				throw new DatosException("El número de registros eliminados es diferente de 1" + numeroRegistrosEliminados);
			}
			
			return true;
			
		} catch (SQLException e) {
			throw new DatosException("No se ha podido realizar la consulta delete() ", e);
		}
	}
	
	@Override
	public Iterable<Producto> getByPartialName(String nombreParcial){
		
		try (	Connection conn = getConexion();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_PARTIAL_NAME)) {
			
			stmt.setString(1, "%" + nombreParcial + "%");
			
			List<Producto> productos = new ArrayList<Producto>();

			ResultSet rs = stmt.executeQuery();
			
			Producto producto;
			
			while(rs.next()) {
				
				producto = fromResultSetToObject(rs); 
				productos.add(producto);
			}
			
			return productos;
			
		} catch (SQLException e) {
			throw new DatosException("No se ha podido hacer la consulta getByPartialName()", e);
		}
		
	}

	@Override
	public Iterable<Producto> getExpired() {
		return getExpired(LocalDate.now());
	}
	
	@Override
	public Iterable<Producto> getExpired(LocalDate fecha) {
		
		try (	Connection conn = getConexion();
				PreparedStatement stmt = conn.prepareStatement(SELECT_EXPIRED)) {
			
			stmt.setString(1, fecha.toString());
			
			List<Producto> productos = new ArrayList<Producto>();

			ResultSet rs = stmt.executeQuery();
			
			Producto producto;
			
			while(rs.next()) {
				
				producto = fromResultSetToObject(rs); 
				productos.add(producto);
			}
			
			return productos;
			
		} catch (SQLException e) {
			throw new DatosException("No se ha podido hacer la consulta getExpired()", e);
		}
	}

	
	
	@Override
	protected Producto fromResultSetToObject(ResultSet rs) throws SQLException{
		
			Long idProducto = rs.getLong("id_producto");
			String nombre = rs.getString("nombre");
			Long idCategoria = rs.getLong("id_categoria");
			String codigoBarras = rs.getString("codigo_barras");
			BigDecimal precioVenta = rs.getBigDecimal("precio_venta");
			Integer cantidadStock = rs.getInt("cantidad_stock");
			Boolean estado = rs.getBoolean("estado");
			
			String stringFechaCaducidad = rs.getString("fecha_caducidad");
			LocalDate fechaCaducidad = ((stringFechaCaducidad == null) || (stringFechaCaducidad.trim().length()==0)) ? null : LocalDate.parse(stringFechaCaducidad);
			
		return Producto.builder()
				.idProducto(idProducto)
				.nombre(nombre)
				.idCategoria(idCategoria)
				.codigoBarras(codigoBarras)
				.precioVenta(precioVenta)
				.cantidadStock(cantidadStock)
				.estado(estado)
				.fechaCaducidad(fechaCaducidad)
				.build();
	}

	@Override
	protected PreparedStatement fromObjectToPreparedStatement(Producto producto, PreparedStatement stmt) throws SQLException {
		
		stmt.setString(1, producto.getNombre());
		stmt.setLong(2, producto.getIdCategoria());
		stmt.setString(3, producto.getCodigoBarras());
		stmt.setBigDecimal(4, producto.getPrecioVenta());
		stmt.setInt(5, producto.getCantidadStock());
		stmt.setBoolean(6, producto.getEstado());
		LocalDate fecha = producto.getFechaCaducidad();
		stmt.setString(7, fecha != null ? fecha.toString() : null);
		
		if(producto.getIdProducto() != null) {
			stmt.setLong(8, producto.getIdProducto());
		}
		
		return stmt;
	}

}
