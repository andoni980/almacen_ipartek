package com.almacen.presentacion.controladores.usuario.producto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.almacen.dominio.factoria.FactoriaDispatcher.FACTORIA;

@WebServlet("/producto")
public class GetProductoByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	public static void main(String[] args) {
//		
//		Long id = 45L;
//		
//		System.out.println(FACTORIA.getAdminServicio().getById(id).toString());
//	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String stringId = request.getParameter("id");
		
		Long id = Long.parseLong(stringId);
		
		request.setAttribute("producto", FACTORIA.getUsuarioProductoServicio().getById(id));
		request.getRequestDispatcher("WEB-INF/vistas/producto.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

}
