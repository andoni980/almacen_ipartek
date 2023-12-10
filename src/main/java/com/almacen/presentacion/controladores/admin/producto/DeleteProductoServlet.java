package com.almacen.presentacion.controladores.admin.producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.almacen.dominio.factoria.FactoriaDispatcher.FACTORIA;

@WebServlet("/admin/borrar")
public class DeleteProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	public static void main(String[] args) {
//		
//		Long id = 54L;
//		
//		System.out.println(FACTORIA.getAdminServicio().delete(id));
//		
//	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String stringId = request.getParameter("id");
		Long idProducto = Long.parseLong(stringId);
		
		FACTORIA.getAdminProductoServicio().delete(idProducto);
		
		response.sendRedirect(request.getContextPath() + "/admin/listadoProductos");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
