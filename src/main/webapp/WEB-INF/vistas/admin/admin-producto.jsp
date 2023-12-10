<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/admin-cabecera.jsp"%>

	<form action="admin/producto" method="post">
		<div class="row mb-3 mx-5">
			<label for="id-producto" class="col-sm-2 col-form-label">Id Producto</label>
			<div class="col-sm">
				<input type="number" readonly
					class="form-control"
					id="id-producto" name="id-producto" value="${producto.idProducto}">
			</div>
		</div>
		
		<div class="row mb-3 mx-5">
			<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
			<div class="col-sm">
				<input type="text"
					class="form-control"
					id="nombre" name="nombre" value="${producto.nombre}">
			</div>
		</div>
		
		<div class="row mb-3 mx-5">
			<label for="id-categoria" class="col-sm-2 col-form-label">Id Categoria</label>
			<div class="col-sm">
				<input type="number" class="form-control"
					id="id-categoria" name="id-categoria" value="${producto.idCategoria}">
			</div>
		</div>

		<div class="row mb-3 mx-5">
			<label for="codigo-barras" class="col-sm-2 col-form-label">Código
				de barras</label>
			<div class="col-sm">
				<input type="text"
					class="form-control"
					id="codigo-barras" name="codigo-barras"
					value="${producto.codigoBarras}">
			</div>
		</div>

		<div class="row mb-3 mx-5">
			<label for="precio-venta" class="col-sm-2 col-form-label">Precio</label>
			<div class="col-sm">
				<input type="number" step=".01"
					class="form-control"
					id="precio-venta" name="precio-venta" value="${producto.precioVenta}">
			</div>
		</div>

		<div class="row mb-3 mx-5">
			<label for="cantidad-stock" class="col-sm-2 col-form-label">Unidades</label>
			<div class="col-sm">
				<input type="number"
					class="form-control"
					id="cantidad-stock" name="cantidad-stock" value="${producto.cantidadStock}">
			</div>
		</div>
		
		<div class="row mb-3 mx-5">
			<label for="estado" class="col-sm-2 col-form-label" style="margin-top:0px;">Disponible</label>
			<div class="col-sm">
				<input type="checkbox" 
					class="form-check-input"
					id="estado" name="estado" value="${producto.estado}">
			</div>
		</div>
		
		<div class="row mb-3 mx-5">
			<label for="fecha-caducidad" class="col-sm-2 col-form-label">Fecha
				de caducidad</label>
			<div class="col-sm">
				<input type="date"
					class="form-control"
					id="fecha-caducidad" name="fecha-caducidad"
					value="${producto.fechaCaducidad}">
			</div>
		</div>

		<div class="row mb-3 mx-5">
			<div class="offset-sm-2 col-sm">
				<div class="d-flex">
					<div>
						<button type="submit" class="btn btn-primary">Guardar</button>
						<a class="btn btn-danger" href="admin/listadoProductos">Cancelar</a>
					</div>
					<div class="ms-auto d-none d-lg-block">
						<button type="reset" class="btn btn-warning">Restaurar
							valores originales</button>
						<a class="btn btn-danger" href="admin/producto">Vaciar
							formulario</a>
					</div>
				</div>
			</div>
		</div>
	</form>
