<%-- 
    Document   : ABMcategorias
    Created on : 02/06/2018, 17:37:56
    Author     : carlos
--%>

<%@page import="model.entidades.Usuarios"%>
<%@page import="model.manager.ManagerCategoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.entidades.Categoria"%>
<%
    ArrayList<Categoria> elem;
    ManagerCategoria mc = new ManagerCategoria();
    elem = mc.getAll();
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
        
      <div class="center">
        <h1 class="h1-titulo">Categorias</h1>
        <button class="button" type="button" onclick="location.href='/ecommerce/Ausuarios.jsp'">Agregar Categoria</button>
        <%
            if (elem != null) {
                //tengo que dibujar la grilla de usuarios
        %>
        <table>
          <tr>
            <th>Id Categoria</th>
            <th>Descripción</th>
            <th>Acción</th>
          </tr>
            <%
                for (Categoria list : elem) {
            %>
          <tr>
            <td><%=list.getIdCategoria()%></td>
            <td><%=list.getDescripcion()%></td>
            <td><form>
              <button class="button" type="button" onclick="location.href='/ecommerce/Mcategorias.jsp?id=<%=list.getIdCategoria()%>'">Editar</button>
              <button class="button" type="button" onclick="
                  location.href='ServletCategoria?id=<%=list.getIdCategoria()%>&accion=eliminar'">Eliminar</button>
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
    </body>
</html>
