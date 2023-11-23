<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <title>Menu</title>
</head>
<body>
<h1 class="encabezado"> Menú principal </h1>
<br>
<form action="registroEvento" method="get">
    <div class="centrado">
        <input type="submit" value="Registrar evento" class="boton">
    </div>
</form>
<form action="registroArtista" method="get">
    <div class="centrado">
        <input type="submit" value="Registrar Artista" class="boton">
    </div>
</form>
<form action="registroAsistente" method="get">
    <div class="centrado">
        <input type="submit" value="Registrar asistente" class="boton">
    </div>
</form>
</body>
</html>