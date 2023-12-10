<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>


<main class="container">

	<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5 row-cols-xxl-6 g-4">
	
		<c:forEach items="${productos}" var="p">
			<div class="col">
				<div class="card h-100">
					<img src="https://picsum.photos/300/200?${p.idProducto}" class="card-img-top" alt="...">
					<div class="card-body">
					
						<h5 class="card-title">${p.nombre}</h5>
						<ul class="list-group list-group-flush">
							<li class="list-group-item">ID categoria: ${p.idCategoria}</li>
							<li class="list-group-item">Código de barras: ${p.codigoBarras}</li>
							<li class="list-group-item">Precio: ${p.precioVenta}€</li>
							<li class="list-group-item">Estado: ${p.estado == true ? 'Activo' : 'NO Activo'}</li>
							<li class="list-group-item">Stock: ${p.cantidadStock == null ? 'No disponible' : p.cantidadStock += ' unidades'}</li>
						</ul>
						<a class="btn btn-primary w-100 stretched-link" href="producto?id=${p.idProducto}">Ver detalle</a>
					</div>
					<div class="card-footer">
						<small class="text-body-secondary">Fecha de Caducidad: ${p.fechaCaducidad}</small>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</main>