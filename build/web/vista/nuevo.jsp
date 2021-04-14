<%@page import="com.emergentes.modelo.Vacuna" %>
<%@page import="com.emergentes.modelo.VacunaDAO" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Vacuna item = (Vacuna) request.getAttribute("item");
        %>
        <h1>Nuevo Registro</h1>
        <form action="Principal?op=guardar" method="post">
            Id: <input type="number" name="id" value="<%= item.getId() %>" size="2" pattern="[1-9] {1} [0-9]*"/>
            <input type="hidden" name="tipo" value="-1" required/>
            <br>
            Nombre: <input type="text" name="nombre" value="<%= item.getNombre() %>" required/>
            <br>
            Peso: <input type="number" name="peso" value="<%= item.getPeso() %>" size="2" pattern="[1-9] {1} [0-9]*"/>
            <input type="hidden" name="tipo" value="-1" required/>
            <br>
            Talla: <input type="number" name="talla" value="<%= item.getTalla() %>" size="2" pattern="[1-9] {1} [0-9]*"/>
            <input type="hidden" name="tipo" value="-1" required/>
            <br>
            Vacuna: <input type="text" name="vacuna" value="<%= item.getVacuna() %>" />
            <br>
            <br>
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
