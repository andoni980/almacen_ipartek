package com.almacen.presentacion.controladores.usuario.producto;

import static com.almacen.dominio.factoria.FactoriaDispatcher.FACTORIA;

import java.util.ArrayList;
import java.util.List;

import com.almacen.dominio.entidades.Producto;

import jakarta.servlet.http.HttpServlet;

public class GetProductoByPartialNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		
		String nombreParcial = "de";
		
		List<Producto> productos = new ArrayList<Producto>();
		
		productos = (List<Producto>)FACTORIA.getUsuarioProductoServicio().getByPartialName(nombreParcial);
		
		for(Producto producto : productos) {
			System.out.println(producto);
		}
	}

//    public GetProductoByPartialNameServlet() {
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
