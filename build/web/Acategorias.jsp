<%-- 
    Document   : Acategorias
    Created on : 02/06/2018, 23:27:12
    Author     : carlos
--%>

<%@page import="model.entidades.Usuarios"%>
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
        
      <div class="center">
        <h1 class="h1-titulo">Categorias</h1>
        <button class="button" type="button">Agregar Categoria</button>
        <table>
            <tr>
                <th>
                <form name="Acategorias" action="ServletCategoria" method="post">
                      <input class="input-buscar" type="text" name ="descripcion" value="Descripción"/>
                      <input type="submit" class="button" value="Insertar">
                      <input type="hidden" name="accion" value="insertar">
                </form>
                </th>
              </tr>
          <tr>
              <th><a class="ref" href="ABMcategorias.jsp" style="color: white">Volver a Categorias</a></th>
          </tr>
        </table>
     </div>
     <div class="footer">
      <p>Copyright &copy; Carlos Ben&iacutetez - Tania Leguizam&oacuten</p>
    </div>
    </body>
</html>