package com.almacen.presentacion.controladores.usuario.producto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.almacen.dominio.entidades.Producto;

import static com.almacen.dominio.factoria.FactoriaDispatcher.FACTORIA;

import jakarta.servlet.http.HttpServlet;

public class GetExpiredProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		
		LocalDate fecha = LocalDate.of(2026, 2, 2);
		
		List<Producto> productos = new ArrayList<Producto>();
		
		productos = (List<Producto>)FACTORIA.getUsuarioProductoServicio().getExpired();
		
		for(Producto producto: productos) {
			System.out.println(producto.toString());
		}
	}
       
//    public GetExpiredProductoServlet() {
//        super();
//    }
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
