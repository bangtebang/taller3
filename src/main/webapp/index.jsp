<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <title>Menu</title>
</head>
<body>
<h1 class="encabezado"> Menú principal usuarios </h1>
<br>
<form action="registroUsuario" method="get">
    <div class="centrado">
        <input type="submit" value="Registrar usuario" class="boton">
    </div>
</form>

<form action="mostrarUsuarios" method="get">
    <div class="centrado">
        <input type="submit" value="Mostrar usuarios" class="boton">
    </div>
</form>
</body>
</html>