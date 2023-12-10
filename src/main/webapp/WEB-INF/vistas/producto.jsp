<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

<main class="container">

	<div class="card mb-3">
		<div class="row g-0">
			<div class="col-md-4">
				<img src="https://picsum.photos/300/500"
					class="img-fluid rounded-start" alt="...">
			</div>
			<div class="col-md-8">
				<div class="card-body">
					<h5 class="card-title">${producto.nombre}</h5>
					<div class="card">
						<ul class="list-group list-group-flush">
							<li class="list-group-item">ID Categoria: ${producto.idCategoria}</li>
						
							<li class="list-group-item">Precio: ${producto.precioVenta} €</li>
							<li class="list-group-item">Stock: ${producto.cantidadStock == null ? 'No disponible' : producto.cantidadStock += ' unidades'}</li>
							<li class="list-group-item">Estado del producto: ${producto.estado == false ? 'No disponible' : 'Disponible'}</li>
							
						</ul>
						<a class="btn btn-primary" href="carrito?id=${producto.idProducto}">Añadir al carrito</a>
 					</div>
					<p class="card-text">
						<small class="text-body-secondary">Fecha de Caducidad: ${producto.fechaCaducidad}</small>
					</p>
				</div>
				<a class="btn btn-secondary" href="listadoProductos">Volver al listado</a>
			</div>
		</div>
	</div>

</main>