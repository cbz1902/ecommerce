<%-- 
    Document   : Musuarios
    Created on : 03/06/2018, 14:33:28
    Author     : carlos
--%>

<%@page import="model.entidades.Usuarios"%>
<%@page import="model.manager.ManagerUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession(true);
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
         <%
            int id = Integer.parseInt(request.getParameter("id"));
            ManagerUsuario ma = new ManagerUsuario();
            Usuarios user  = ma.getUsuariosById(id);
        %>
    <div class="row">
        <div class="center">
            <form name="Musuarios" action="ServletUsuario" method="post">
                <table>
                    <tr>
                        <th><p>ID: </p></th>
                        <th><input type="text" readonly="readonly" value="<%=user.getId_usuario()%>" name ="id"></th>
                        <th><p>Nombre: </p></th>
                        <th><input type="text" value="<%=user.getNombre()%>" name ="nombre"></th>
                        <th><p>Apellido: </p></th>
                        <th><input type="text" value="<%=user.getApellido()%>" name ="apellido"></th>
                        <th><p>Nombre de Usuario:</p></th> 
                        <th><input type="text" value="<%=user.getLogin_name()%>" name ="nombre_user"></th>
                        <th><p>Tipo Usuario:</p><p>
                          <input type="radio" name="tipo_usuario" value="0" required="required"> Admin
                          <input type="radio" name="tipo_usuario" value="1" required="required"> Normal
                        </p></th>
                    </tr>
                    <tr>
                        
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>                        
                        <th><input type="hidden" name="accion" value="actualizar">
                        <input type="submit" class="button" value="Actualizar">
                        </th>
                        <th></th>
                        <th></th>
                        <th></th>
                      
                    </tr>
                </table>
            </form>
        </div>
        <div class="footer">
            <p>Copyright &copy; Carlos Ben&iacutetez - Tania Leguizam&oacuten</p>
        </div>
    </div>
    </body>
</html>