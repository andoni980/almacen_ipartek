<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/admin-cabecera.jsp"%>

<main class="container">

	<h2 class="text-center fs-1 mb-4 fw-bold">Productos</h2>
	
	<table class="table table-bordered table-striped table-hover border-primary">
		<thead class="table-dark">
			<tr>
				<th class="text-end">Id Producto</th>
				<th>Nombre</th>
				<th>Id Categoria</th>
				<th>Código de barras</th>
				<th class="text-end">Precio</th>
				<th class="text-end">Stock</th>
				<th class="text-end">Estado</th>
				<th>Fecha de caducidad</th>
				<th>OPCIONES</th>
			</tr>
		</thead>
		<tbody>

				<c:forEach items="${productos}" var="p">
					<tr>
						<th class="text-end">${p.idProducto}</th>
						<td>${p.nombre}</td>
						<td class="text-center">${p.idCategoria}</td>
						<td>${p.codigoBarras}</td>
						<td class="text-end">${p.precioVenta} €</td>
						<td class="text-end">${p.cantidadStock}</td>
						<td class="text-end">${p.estado == true? 'Disponible' : 'NO Disponible'}</td>
 						<td>${p.fechaCaducidad == null ? '<i class="bi bi-dash-lg"></i>' : p.fechaCaducidad }</td>
						<td><a class="btn btn-sm btn-primary"
							href="admin/producto?id=${p.idProducto}">Editar</a>
							<a onclick="return confirm('¿Estás seguro de borrar el producto ${p.nombre}?')"
							class="btn btn-sm btn-danger" href="admin/borrar?id=${p.idProducto}">Borrar</a>
						</td>
					</tr>
				</c:forEach>

		</tbody>
		<tfoot class="table-dark">
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a class="btn btn-sm btn-primary ms-5" href="admin/producto">Añadir</a>
				</td>
			</tr>
		</tfoot>
	</table>

</main>