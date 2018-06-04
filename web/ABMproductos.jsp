<%-- 
    Document   : ABMproductos
    Created on : 03/06/2018, 20:13:49
    Author     : carlos
--%>

<%@page import="model.manager.ManagerCategoria"%>
<%@page import="model.entidades.Categoria"%>
<%@page import="model.manager.ManagerProducto"%>
<%@page import="model.entidades.Producto"%>
<%@page import="model.manager.ManagerUsuario"%>
<%@page import="model.entidades.Usuarios"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession(true);
    Usuarios user = (Usuarios)sesion.getAttribute("usuario");
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
                        if(user != null){
                    %>
                        <%
                            if(user.getTipo_usuario() == 0){
                        %>
                            <li><a href="ABMusuarios.jsp">ABM usuarios</a></li>
                            <li><a href="ABMcategorias.jsp">ABM categoria</a></li>
                            <li><a href="ABMcategorias.jsp">ABM productos</a></li>
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
                    if(user != null){
                %>
                    <p> Bienvenido: <%=user.getLogin_name()%></p>
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
        <h1 class="h1-titulo">Productos</h1>
        <button class="button" type="button" onclick="location.href='/ecommerce/Ausuarios.jsp'">Agregar Producto</button>
        <%
            ArrayList<Producto> elem = new ArrayList<Producto>();
            ManagerProducto mp = new ManagerProducto();
            elem = mp.getAll();
        %>
        <%
            if (elem != null) {
                //tengo que dibujar la grilla de usuarios
        %>
        <table>
          <tr>
            <th>ID</th>
            <th>Descripcion</th>
            <th>Cartegoria</th>
            <th>Precio</th>
            <th>Cantidad</th>
            <th>Acccion</th>
          </tr>
            <%
                for (Producto list : elem) { 
                    ManagerCategoria mc = new ManagerCategoria();
                    Categoria c = mc.getCategoriaById(list.getId_categoria());
            %>
          <tr>
            <td><%=list.getId_producto()%></td>
            <td><%=list.getDescripcion()%></td>
            <td><%=c.getDescripcion()%></td>
            <td><%=list.getPrecio_unitario()%> USD</td>
            <td><%=list.getCantidad()%></td>
            <td><form>
              <button class="button" type="button" onclick="location.href='/ecommerce/Musuarios.jsp?id=<%=list.getId_producto()%>'">Editar</button>
              <button class="button" type="button" onclick="
                  location.href='ServletProducto?id=<%=list.getId_producto()%>&accion=eliminar'">Eliminar</button>
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