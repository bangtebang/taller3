
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head> <title>Registro evento</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body> <h1 class="encabezado">Registro evento</h1>
<form action="registroEvento" method="post">
    <div class="centrado">
        <label>Nombre:</label>
        <input name="nombre" type="text" class="campoTexto">
        <input type="submit" value="enviar" class="boton">
    </div>
</form>
</body>
</html>