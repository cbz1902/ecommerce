<%-- 
    Document   : ABMusuarios
    Created on : 03/06/2018, 12:17:23
    Author     : carlos
--%>

<%@page import="model.manager.ManagerUsuario"%>
<%@page import="model.entidades.Usuarios"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Usuarios> elem;
    ManagerUsuario mc = new ManagerUsuario();
    elem = mc.getAll();HttpSession sesion = request.getSession(true);
    Usuarios u = (Usuarios)sesion.getAttribute("usuario");
    
%>
<!DOCTYPE html>
<html>
<head>
    <title>Bazar Shop Paraguay</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="css/estilo.css" rel="stylesheet">
</head>
    <body>
    <div>
    </div>
    <div class="header">
        <div class="row">
            <div class="column side-header">
                <a href="index.jsp"><img class="img-logo" src="img/logo.png"></a>
            </div>
            <div class="column middle-header">
                <form>
                  <input class="input-buscar" type="text" value="Buscar..."/>
                  <button class="button-ir " type="button">Ir</button>
                </form>
                <p></p>
                <div>
                  <ul>
                    <li><a class="active" href="index.jsp">Home</a></li>
                    <li><a href="ABMproductos.jsp">Producto</a></li>
                    <%
                        if(u != null){
                    %>
                        <%
                            if(u.getTipo_usuario() == 0){
                        %>
                            <li><a href="ABMusuarios.jsp">ABM usuarios</a></li>
                            <li><a href="ABMcategorias.jsp">ABM categoria</a></li>
                            <li><a href="#">ABM productos</a></li>
                        <%
                            }
                        %>
                    <%
                        }
                    %>
                  </ul>
                </div>
            </div>
            <div class="column side-header">
                <%
                    if(u != null){
                %>
                    <p> Bienvenido: <%=u.getLogin_name()%></p>
                <%
                    }else{
                %>
                    <p> Bienvenido:</p>
                <%
                    }
                %>
                <button  class="button" type = "button"onclick="
                  location.href='ServletUsuario?accion=salir'" >Salir</button>
                <button  class="button-carrito" type = "button" ><img src="img/carrito.png"> Comprar</button>
            </div>
        </div>
    </div>
    <div class="center">
        <h1 class="h1-titulo">Usuarios</h1>
        <button class="button" type="button" onclick="location.href='/ecommerce/Ausuarios.jsp'">Agregar Usuario</button>
        <%
            if (elem != null) {
                //tengo que dibujar la grilla de usuarios
        %>
        <table>
          <tr>
            <th>Id Usuario</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Nombre Usuario</th>
            <th>Tipo Usuario</th>
            <th>Accion</th>
          </tr>
            <%
                for (Usuarios list : elem) { 
            %>
            <%
                String tipo;
                if(list.getTipo_usuario() == 0) {
                    tipo = "Administrador";
                }else{
                    tipo = "Normal";
                } 
            %>
          <tr>
            <td><%=list.getId_usuario()%></td>
            <td><%=list.getNombre()%></td>
            <td><%=list.getApellido()%></td>
            <td><%=list.getLogin_name()%></td>
            <td><%=tipo%></td>
            <td><form>
              <button class="button" type="button" onclick="location.href='/ecommerce/Musuarios.jsp?id=<%=list.getId_usuario()%>'">Editar</button>
              <button class="button" type="button" onclick="
                  location.href='ServletUsuario?id=<%=list.getId_usuario()%>&accion=eliminar'">Eliminar</button>
            </form></td>
          </tr>
        <%
          }
        %>
      </table>
      <%
        }
       %>
    </div>
     <div class="footer">
      <p>Copyright &copy; Carlos Ben&iacutetez - Tania Leguizam&oacuten</p>
    </div>
</html>