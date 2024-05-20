<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Actualizar Detalle de Venta</title>
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
    <h1 class="mb-4">Actualizar Detalle de Venta</h1>
    <form action="${pageContext.request.contextPath}/detallesVentas/actualizar/${detallesVenta.idDetalle}" method="post">
        <div class="form-group">
            <label for="idVenta">ID Venta</label>
            <input type="number" class="form-control" id="idVenta" name="venta.idVenta" value="${detallesVenta.venta.idVenta}" required>
        </div>
        <div class="form-group">
            <label for="idProducto">ID Producto</label>
            <input type="number" class="form-control" id="idProducto" name="producto.idProducto" value="${detallesVenta.producto.idProducto}" required>
        </div>
        <div class="form-group">
            <label for="cantidad">Cantidad</label>
            <input type="number" class="form-control" id="cantidad" name="cantidad" value="${detallesVenta.cantidad}" required>
        </div>
        <div class="form-group">
            <label for="precioUnitario">Precio Unitario</label>
            <input type="number" class="form-control" id="precioUnitario" name="precioUnitario" value="${detallesVenta.precioUnitario}" required>
        </div>
        <div class="form-group">
            <label for="subtotal">Subtotal</label>
            <input type="number" class="form-control" id="subtotal" name="subtotal" value="${detallesVenta.subtotal}" required>
        </div>
        <button type="submit" class="btn btn-success">Actualizar</button>
        <!-- Regresar al listado de ventas -->
        <a href="javascript:history.back()" class="btn btn-secondary">Regresar</a>
    </form>
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