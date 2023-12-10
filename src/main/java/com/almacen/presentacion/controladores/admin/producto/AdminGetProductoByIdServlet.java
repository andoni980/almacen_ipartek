package com.almacen.presentacion.controladores.admin.producto;

import static com.almacen.dominio.factoria.FactoriaDispatcher.FACTORIA;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.almacen.dominio.entidades.Producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/producto")
public class AdminGetProductoByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String stringId = request.getParameter("id");
		
		if(stringId != null) {
			Long idProducto = Long.parseLong(stringId);
			Producto producto = FACTORIA.getAdminProductoServicio().getById(idProducto);
			request.setAttribute("producto", producto);
		}
		
		request.getRequestDispatcher("/WEB-INF/vistas/admin/admin-producto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String stringId = request.getParameter("id-producto");
		String nombre = request.getParameter("nombre");
		String stringIdCategoria = request.getParameter("id-categoria");
		String codigoBarras = request.getParameter("codigo-barras");
		String stringPrecioVenta = request.getParameter("precio-venta");
		String stringCantidadStock = request.getParameter("cantidad-stock");
		String stringEstado = request.getParameter("estado");
		String stringFechaCaducidad = request.getParameter("fecha-caducidad");
		
		Long idProducto = stringId.trim().length() == 0 ? null : Long.parseLong(stringId);
		Long idCategoria = Long.parseLong(stringIdCategoria);
		BigDecimal precioVenta = new BigDecimal(stringPrecioVenta);
		Integer cantidadStock = Integer.valueOf(stringCantidadStock);
		Boolean estado = Boolean.parseBoolean(stringEstado);
		LocalDate fechaCaducidad = (stringFechaCaducidad.trim().length() != 0) ? LocalDate.parse(stringFechaCaducidad) : null;
		
		Producto producto = Producto.builder()
				.idProducto(idProducto)
				.nombre(nombre)
				.idCategoria(idCategoria)
				.codigoBarras(codigoBarras)
				.precioVenta(precioVenta)
				.cantidadStock(cantidadStock)
				.estado(estado)
				.fechaCaducidad(fechaCaducidad)
				.build();
		
		if(producto.getIdProducto() != null) {
			FACTORIA.getAdminProductoServicio().update(producto);
		}else {
			FACTORIA.getAdminProductoServicio().save(producto);
		} 
		
		response.sendRedirect(request.getContextPath() + "/admin/listadoProductos");
		
		
		
		
		// Petición save() por consola
		
//		public static void main(String[] args) {
//		
//		Producto producto = Producto.builder()
//			.idProducto(null)
//			.nombre("Goma de mascar")
//			.idCategoria(1L)
//			.codigoBarras("7697DD3T2")
//			.precioVenta(new BigDecimal("0.99"))
//			.cantidadStock(1000)
//			.estado(true)
//			.fechaCaducidad(LocalDate.of(2025, 01, 9))
//			.build();
//		
//		System.out.println(FACTORIA.getAdminProductoServicio().save(producto));
//		
//	}
		
		// Petición update() por consola
		
//		public static void main(String[] args) {
//		
//		Producto producto = Producto.builder()
//				.idProducto(54L)
//				.nombre("Goma de mascar(chicle)")
//				.idCategoria(1L)
//				.codigoBarras("7697DD3T2")
//				.precioVenta(new BigDecimal("0.99"))
//				.cantidadStock(1000)
//				.estado(true)
//				.fechaCaducidad(LocalDate.of(2025, 01, 9))
//				.build();
//		
//		System.out.println(FACTORIA.getAdminProductoServicio().update(producto));
//	}
		
	}

}
