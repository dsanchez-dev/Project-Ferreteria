<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Página Principal</title>
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
</nav>

<div class="container mt-5 pt-5">
    <h1 class="mb-4">Bienvenido a Mi Aplicación</h1>
    <p>Bienvenido a la aplicación web de gestión integral. Aquí puedes manejar de forma eficiente tus clientes, productos y ventas.</p>
    <p>Utiliza la barra de navegación superior para acceder a las diferentes secciones. Esta herramienta está diseñada para simplificar y optimizar tus procesos administrativos y comerciales.</p>
    <hr>
    <h2>Acerca de esta página web</h2>
    <p>Esta es una aplicación web desarrollada con Java y Spring Boot. Está diseñada para facilitar la gestión de clientes, productos y ventas en tu negocio. A continuación, se detallan las funcionalidades disponibles:</p>
    <ul>
        <li><strong>Clientes:</strong> Permite agregar, editar, eliminar y visualizar la información de tus clientes. Mantén tus datos de contacto y registros de compras al día.</li>
        <li><strong>Productos:</strong> Gestiona tu inventario de productos, incluyendo la adición de nuevos productos, actualización de detalles y control de stock.</li>
        <li><strong>Ventas:</strong> Registra y supervisa todas las ventas realizadas. Obtén informes detallados y analíticos sobre el rendimiento de tu negocio.</li>
    </ul>
    <p>Además, la aplicación ofrece seguridad en el manejo de datos, asegurando que la información de tu negocio esté protegida y accesible solo para usuarios autorizados.</p>
    <hr>
    <h2>Funcionalidades destacadas</h2>
    <p>La aplicación cuenta con varias funcionalidades destacadas que mejoran la eficiencia operativa:</p>
    <ul>
        <li><strong>Panel de control:</strong> Un tablero centralizado para monitorear el estado general de tus operaciones.</li>
        <li><strong>Reportes personalizados:</strong> Genera reportes personalizados sobre ventas, clientes y productos para una mejor toma de decisiones.</li>
        <li><strong>Integración con sistemas externos:</strong> Conexión con otras herramientas y plataformas que ya utilizas, como sistemas de contabilidad o CRMs.</li>
        <li><strong>Actualizaciones en tiempo real:</strong> Los datos se actualizan automáticamente para ofrecerte la información más reciente sin necesidad de recargar la página.</li>
    </ul>
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