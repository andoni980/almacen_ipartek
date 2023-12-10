package com.almacen.presentacion.controladores.admin.producto;

import static com.almacen.dominio.factoria.FactoriaDispatcher.FACTORIA;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/listadoProductos")
public class AdminGetAllProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var productos = FACTORIA.getAdminProductoServicio().getAll();;
		request.setAttribute("productos", productos);
		request.getRequestDispatcher("/WEB-INF/vistas/admin/admin-listadoProductos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
