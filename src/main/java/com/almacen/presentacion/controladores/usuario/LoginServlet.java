package com.almacen.presentacion.controladores.usuario;

import static com.almacen.dominio.factoria.FactoriaDispatcher.FACTORIA;

import java.io.IOException;

import com.almacen.dominio.entidades.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/vistas/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario usuario = FACTORIA.getUsuarioProductoServicio().login(email,password);
		
		if(usuario == null) {
			request.setAttribute("error", "El usuario o contraseña son inválidos");
			request.getRequestDispatcher("WEB-INF/vistas/login.jsp").forward(request, response);
		}else {
			request.getSession().setAttribute("usuario", usuario);
			response.sendRedirect(request.getContextPath() + "/listadoProductos");
		}
	}
}
