<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Actualizar producto</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/inicio">Ferreteria Zapata</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/clientes/todos">Clientes</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/productos/todos">Productos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/ventas/todos">Ventas</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/detallesVentas/todos">Reportes</a>
            </li>
        </ul>
    </div>
    <form action="${pageContext.request.contextPath}/ventas/buscar" method="get">
        <input type="number" name="id" placeholder="Buscar por ID...">
        <button type="submit">Buscar</button>
    </form>
</nav>
<div class="container mt-5">
    <h1>Actualizar producto</h1>
    <form:form method="POST" action="${pageContext.request.contextPath}/productos/actualizar/${producto.idProducto}" modelAttribute="producto" class="mt-4">
        <div class="form-group">
            <label for="nombre">Nombre</label>
            <form:input path="nombre" id="nombre" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="descripcion">Descripción</label>
            <form:input path="descripcion" id="descripcion" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="precio">Precio</label>
            <form:input path="precio" id="precio" class="form-control"/>
        </div>
        <div class="form-group">
            <label for="stock">Stock</label>
            <form:input path="stock" id="stock" class="form-control"/>
        </div>
        <button type="submit" class="btn btn-primary">Actualizar</button>
        <a href="javascript:history.back()" class="btn btn-secondary">Regresar</a>
    </form:form>
</div>
<footer class="footer mt-auto py-3 bg-dark text-white">
    <div class="container text-center">
        <span>&copy; 2023 Ferreteria Zapata. Todos los derechos reservados.</span>
    </div>
</footer>

<!-- Bootstrap JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>