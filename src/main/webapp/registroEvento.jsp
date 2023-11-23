
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head> <title>Registro usuario</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body> <h1 class="encabezado">Registro usuario</h1>
<form action="registroUsuario" method="post">
    <div class="centrado">
        <label>Nombre:</label>
        <input name="nombre" type="text" class="campoTexto">
        <label>Edad:</label>
        <input name="edad" type="number" class="campoTexto">
        <label>Rut:</label>
        <input name="rut" type="text" class="campoTexto">
        <br><br>
        <input type="submit" value="enviar" class="boton">
    </div>
</form>
</body>
</html>