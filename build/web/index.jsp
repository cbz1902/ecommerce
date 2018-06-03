<%-- 
    Document   : index
    Created on : 02/06/2018, 13:31:00
    Author     : carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
      <div class="column side">
        <form id = "iniciarSesion" action="" method="POST">
          <fieldset>
            <legend>Iniciar Sesión:</legend>
            Nombre Usuario: <input type="text"><br>
            Password: <input type="password"><br>
            <button  class="button" type = "submit" >Ingresar</button>
          </fieldset>
        </form>
      </div>
      <div class="column middle">
        <h1 class="h1-titulo">Ofertas</h1>
        <table>
          <tr>
            <th>Producto</th>
            <th>Descripción</th>
            <th>Precio</th>
            <th></th>
          </tr>
          <tr>
            <td><img class="img-producto" src="img/pava.jpg"></td>
            <td>PAVA SILBADORA ACERO</td>
            <td>$15</td>
            <td><form>
              <input class="input-cantidad" type="text" value="Cantidad"/>
              <button class="button" type="button">Add Carrito</button>
            </form></td>
          </tr>
          <tr>
            <td><img class="img-producto" src="img/matero.jpg"></td>
            <td>MATERO COLOR AZUL</td>
            <td>$100</td>
            <td><form>
              <input class="input-cantidad" type="text" value="Cantidad"/>
              <button class="button" type="button">Add Carrito</button>
            </form></td>
          </tr>
          <tr>
            <td><img class="img-producto" src="img/smartwatch.jpg"></td>
            <td>Reloj Inteligente</td>
            <td>$150</td>
            <td><form>
              <input class="input-cantidad" type="text" value="Cantidad"/>
              <button class="button" type="button">Add Carrito</button>
            </form></td>
          </tr>
          <tr>
            <td><img class="img-producto" src="img/pen8.jpg"></td>
            <td>Kingston DTGE9/8GB - Memoria USB de 8 GB</td>
            <td>$50</td>
            <td><form>
              <input class="input-cantidad" type="text" value="Cantidad"/>
              <button class="button" type="button">Add Carrito</button>
            </form></td>
        </tr>
      </table>
    </div>
      <div class="column side"></div>
    </div>

    <div class="footer">
      <p>Copyright &copy; Carlos Ben&iacutetez - Tania Leguizam&oacuten</p>
    </div>
    </body>
</html>
