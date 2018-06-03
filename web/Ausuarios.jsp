<%-- 
    Document   : Ausuarios
    Created on : 03/06/2018, 12:47:22
    Author     : carlos
--%>

<%@page import="model.manager.ManagerUsuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.entidades.Usuarios"%>
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
    <div class="row">
        <div class="center">
            <form>
                <table>
                    <tr>
                        <th><p>Nombre: </p></th>
                        <th><input type="text" value="" name ="nombre"></th>
                        <th><p>Apellido: </p></th>
                        <th><input type="text" value="" name ="apellido"></th>
                        <th><p>Nombre de Usuario:</p></th> 
                        <th><input type="text" value="" name ="nombre_user"></th>
                        <th><p>Password: </th>
                        <th><input type="text" value="" name ="pass"></th>
                        <th><p>Tipo Usuario:</p></th>
                        <th></p>
                          <input type="radio" name="admin" value="0" required="required"> Admin
                          <input type="radio" name="normal" value="1" required="required"> Normal
                        </p></th>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    </body>
</html>