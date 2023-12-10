package com.almacen.presentacion.controladores.usuario.producto;

import static com.almacen.dominio.factoria.FactoriaDispatcher.FACTORIA;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listadoProductos")
public class GetAllProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	
//	public static void main(String[] args) {
//		
//		for(Producto producto : FACTORIA.getAdminServicio().getAll()) {
//			System.out.println(producto.toString());
//		}
//	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var productos = FACTORIA.getUsuarioProductoServicio().getAll();
		request.setAttribute("productos", productos);
		request.getRequestDispatcher("/WEB-INF/vistas/listadoProductos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
