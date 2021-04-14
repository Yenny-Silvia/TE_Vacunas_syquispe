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
        
        <table border="1" align = "center">
        <th> <trong>PRIMER PARCIAL TEM-742</trong> 
            <br>
          NOMBRE: Silvia Yenny Quispe Quispe
          <br>
          CARNET: 9968069 L.P.
        </th>
        </table>

        <%
            VacunaDAO lista = (VacunaDAO) session.getAttribute("gestor");
        %>
        <h1 align = "center" >Registro de Vacunas</h1>
        <p><a href="../Principal?op=nuevo">Nuevo</a></p>
        <%
            if (lista.getVacunas().size() > 0) {
        %>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Peso</th>
                <th>Talla</th>
                <th>Vacuna</th>
                <th>Editar</th>
                <th>Eliminar</th>
            </tr>
        <%
            for(Vacuna item : lista.getVacunas()) {
        %>
            <tr>
                <td><%= item.getId()%></td>
                <td><%= item.getNombre()%></td>
                <td><%= item.getPeso()%></td>
                <td><%= item.getTalla()%></td>
                <td><%= item.getVacuna()%></td>
                <td><a href="../Principal?op=editar&id=<%= item.getId()%>">Editar</a></td>
                <td><a href="../Principal?op=eliminar&id=<%= item.getId()%>">Eliminar</a></td>
            </tr>
        <%
            }
        %>
        </table>
        <%
        }
            else{
                out.println("<p>No existen registros");;
            }
        %>
    </body>
</html>
