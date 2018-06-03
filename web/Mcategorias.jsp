<%-- 
    Document   : Acategorias
    Created on : 02/06/2018, 23:27:12
    Author     : carlos
--%>

<%@page import="model.entidades.Categoria"%>
<%@page import="model.manager.ManagerCategoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <li><a class="active" href="index.jsp">Inicio</a></li>
                    <li><a href="ABMproductos.jsp">Producto</a></li>
                    <li><a href="#">La empresa</a></li>
                    <li style="float:right"><a href="ABMcategorias.jsp">Contactenos</a></li>
                  </ul>
                </div>
            </div>
            <div class="column side-header">
                <p> Bienvenido: </p>
                <button  class="button" type = "button" >Salir</button>
                <button  class="button-carrito" type = "button" ><img src="img/carrito.png"> Comprar</button>
            </div>
        </div>
    </div>
        <%
            int id = Integer.parseInt(request.getParameter("id"));
            ManagerCategoria mc = new ManagerCategoria();
            Categoria cat  = mc.getCategoriaById(id);
        %>
      <div class="center">
        <h1 class="h1-titulo">Categorias</h1>
        <button class="button" type="button">Agregar Categoria</button>
        <table>
            <tr>
                <th>
                <form name="Mcategorias" action="ServletCategoria" method="post">
                      <p>Id Categoria: <input type="text" readonly="readonly" value="<%=cat.getIdCategoria()%>" name ="id"></p>
                      <p><input class="input-buscar" type="text" name ="descripcion" value="<%=cat.getDescripcion()%>"/></p>
                      <input type="submit" class="button" value="Actualizar">
                      <input type="hidden" name="accion" value="actualizar">
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