<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Ventas</title>
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
    <h1 class="mb-4">Lista de Ventas</h1>
    <!-- Agrega el botón para agregar una nueva venta -->
    <a href="${pageContext.request.contextPath}/nuevo/ventas" class="btn btn-success mb-3">Agregar Nueva Venta</a>

    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Cliente</th>
            <th>Fecha</th>
            <th>Total</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="venta" items="${ventas}">
            <tr>
                <td>${venta.idVenta}</td>
                <td>${venta.cliente.nombre}</td>
                <td>${venta.fecha}</td>
                <td>${venta.total}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/ventas/actualizar/${venta.idVenta}" class="btn btn-primary">Editar</a>
                    <a href="${pageContext.request.contextPath}/ventas/eliminar/${venta.idVenta}" class="btn btn-danger">Eliminar</a>
                    <a href="${pageContext.request.contextPath}/ventas/descargar/${venta.idVenta}" class="btn btn-primary">Descargar Ticket</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
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