package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ABMcategorias_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("   <html>\n");
      out.write("<head>\n");
      out.write("    <title>Bazar Shop Paraguay-ABMcategoria</title>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("    <link href=\"css/estilo.css\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("    <body>\n");
      out.write("    <div class=\"header\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("              <div class=\"column side-header\"><img class=\"img-logo\" src=\"img/logo.png\"></div>\n");
      out.write("                                            <div class=\"column middle-header\">\n");
      out.write("                <form>\n");
      out.write("                  <input class=\"input-buscar\" type=\"text\" value=\"Buscar...\"/>\n");
      out.write("                  <button class=\"button-ir \" type=\"button\">Ir</button>\n");
      out.write("                </form>\n");
      out.write("                <p></p>\n");
      out.write("                <div>\n");
      out.write("                  <ul>\n");
      out.write("                    <li><a class=\"active\" href=\"inicio.html\">Inicio</a></li>\n");
      out.write("                    <li><a href=\"productos.html\">Producto</a></li>\n");
      out.write("                    <li><a href=\"#\">La empresa</a></li>\n");
      out.write("                    <li style=\"float:right\"><a href=\"#\">Contactenos</a></li>\n");
      out.write("                  </ul>\n");
      out.write("                </div>\n");
      out.write("                            </div>\n");
      out.write("              <div class=\"column side-header\">\n");
      out.write("                                            <p> Bienvenido: </p>\n");
      out.write("                                            <button  class=\"button\" type = \"button\" >Salir</button>\n");
      out.write("                  <button  class=\"button-carrito\" type = \"button\" ><img\n");
      out.write("                    src=\"img/carrito.png\"> Comprar</button>\n");
      out.write("                            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("      <div class=\"column middle\">\n");
      out.write("        <h1 class=\"h1-titulo\">Ofertas</h1>\n");
      out.write("        <table>\n");
      out.write("          <tr>\n");
      out.write("            <th>Producto</th>\n");
      out.write("            <th>Descripción</th>\n");
      out.write("            <th>Precio</th>\n");
      out.write("            <th></th>\n");
      out.write("          </tr>\n");
      out.write("          <tr>\n");
      out.write("            <td><img class=\"img-producto\" src=\"img/pava.jpg\"></td>\n");
      out.write("            <td>PAVA SILBADORA ACERO</td>\n");
      out.write("            <td>$15</td>\n");
      out.write("            <td><form>\n");
      out.write("              <input class=\"input-cantidad\" type=\"text\" value=\"Cantidad\"/>\n");
      out.write("              <button class=\"button\" type=\"button\">Add Carrito</button>\n");
      out.write("            </form></td>\n");
      out.write("          </tr>\n");
      out.write("          <tr>\n");
      out.write("            <td><img class=\"img-producto\" src=\"img/matero.jpg\"></td>\n");
      out.write("            <td>MATERO COLOR AZUL</td>\n");
      out.write("            <td>$100</td>\n");
      out.write("            <td><form>\n");
      out.write("              <input class=\"input-cantidad\" type=\"text\" value=\"Cantidad\"/>\n");
      out.write("              <button class=\"button\" type=\"button\">Add Carrito</button>\n");
      out.write("            </form></td>\n");
      out.write("          </tr>\n");
      out.write("          <tr>\n");
      out.write("            <td><img class=\"img-producto\" src=\"img/smartwatch.jpg\"></td>\n");
      out.write("            <td>Reloj Inteligente</td>\n");
      out.write("            <td>$150</td>\n");
      out.write("            <td><form>\n");
      out.write("              <input class=\"input-cantidad\" type=\"text\" value=\"Cantidad\"/>\n");
      out.write("              <button class=\"button\" type=\"button\">Add Carrito</button>\n");
      out.write("            </form></td>\n");
      out.write("          </tr>\n");
      out.write("          <tr>\n");
      out.write("            <td><img class=\"img-producto\" src=\"img/pen8.jpg\"></td>\n");
      out.write("            <td>Kingston DTGE9/8GB - Memoria USB de 8 GB</td>\n");
      out.write("            <td>$50</td>\n");
      out.write("            <td><form>\n");
      out.write("              <input class=\"input-cantidad\" type=\"text\" value=\"Cantidad\"/>\n");
      out.write("              <button class=\"button\" type=\"button\">Add Carrito</button>\n");
      out.write("            </form></td>\n");
      out.write("        </tr>\n");
      out.write("      </table>\n");
      out.write("    </div>\n");
      out.write("      <div class=\"column side\"></div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"footer\">\n");
      out.write("      <p>Copyright &copy; Carlos Ben&iacutetez - Tania Leguizam&oacuten</p>\n");
      out.write("    </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
