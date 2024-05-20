<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Detalle de Venta</title>
    <!-- CSS de Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Detalle de Venta</h1>
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>ID Venta</th>
                <th>ID Producto</th>
                <th>Cantidad</th>
                <th>Precio Unitario</th>
                <th>Subtotal</th>
            </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${detallesVenta.idDetalle}</td>
                    <td>${detallesVenta.venta.idVenta}</td>
                    <td>${detallesVenta.producto.idProducto}</td>
                    <td>${detallesVenta.cantidad}</td>
                    <td>${detallesVenta.precioUnitario}</td>
                    <td>${detallesVenta.subtotal}</td>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- Regresar al listado de ventas -->
    <a href="${pageContext.request.contextPath}/ventas/todos" class="btn btn-secondary">Regresar</a>
    <!-- JS de Bootstrap -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>