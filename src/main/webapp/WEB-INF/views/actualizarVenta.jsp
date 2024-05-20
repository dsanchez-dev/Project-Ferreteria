<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Actualizar Venta</title>
    <!-- CSS de Bootstrap -->
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
        <h1>Actualizar Venta</h1>
        <form:form method="POST" action="/ventas/actualizar/${venta.idVenta}" modelAttribute="venta" class="form">
            <div class="form-group">
                <label for="cliente.idCliente">Cliente:</label>
                <form:input type="number" path="cliente.idCliente" id="cliente.idCliente" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="fecha">Fecha:</label>
                <form:input path="fecha" id="fecha" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="total">Total:</label>
                <form:input path="total" id="total" class="form-control"/>
            </div>
            <div class="form-group">
                <input type="submit" value="Actualizar" class="btn btn-primary"/>
                <!-- Regresar Boton para regresar a listado de ventas -->
                <a href="javascript:history.back()" class="btn btn-secondary">Regresar</a>
            </div>
        </form:form>
        <footer class="footer mt-auto py-3 bg-dark text-white">
            <div class="container text-center">
                <span>&copy; 2023 Ferreteria Zapata. Todos los derechos reservados.</span>
            </div>
        </footer>

    <!-- JS de Bootstrap -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>