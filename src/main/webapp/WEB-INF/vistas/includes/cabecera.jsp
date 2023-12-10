<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Listado de Productos</title>

<base href="${pageContext.request.contextPath}/">

<link rel="stylesheet" href="css/bootstrap-icons.min.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.bundle.min.js"></script>

<link rel="icon" type="image/svg+xml" href="imgs/shop.svg">

</head>
<body>

	<nav class="navbar navbar-expand-sm bg-dark sticky-top mb-4" data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Almacen Ipartek</a>
<!-- 			<button class="navbar-toogler" type="button" data-bs-toogle="collapse" 
				data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button> -->
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-sm-0">
					<li class="nav-item"><a class="nav-link" href="listadoProductos">Principal</a></li>
				</ul>
				<ul class="navbar-nav mb-2 mb-sm-0">
 					<c:if test="${sessionScope.usuario.rol.id_rol == 1}">
						<li class="nav-item"><a class="nav-link" href="admin/listadoProductos">ADMINISTRACIÓN</a></li>
					</c:if>
			 		<li class="navbar-text">${sessionScope.usuario.nombre}</li>
					
 					<li class="nav-item"><a class="nav-link" href="carrito"><i class="bi bi-cart4"></i>${carrito.numeroProductos > 0 ? '(' += carrito.numeroProductos += ')' : ''}</a></li>
					<c:choose>
						<c:when test="${sessionScope.usuario == null}">
							<li class="nav.item"><a class="nav-link" href="login">Iniciar Sesión</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link" href="logout">Cerrar Sesión</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			
			</div>
		
		</div>
	
	</nav>
