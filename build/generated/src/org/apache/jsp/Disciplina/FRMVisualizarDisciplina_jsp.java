package org.apache.jsp.Disciplina;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class FRMVisualizarDisciplina_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Visualizar Disciplina</title>\n");
      out.write("    <!-- Adicione aqui os links para os arquivos CSS do Bootstrap -->\n");
      out.write("    <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <!-- Se você precisa dos estilos, inclua os links CSS aqui -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"../css/Estudantes.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"text\">\n");
      out.write("            Detalhes da Disciplina\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"row mt-4\">\n");
      out.write("            <div class=\"col-md-6\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"nome\">Nome:</label>\n");
      out.write("                    <!-- Use scriptlet para acessar os parâmetros passados na URL -->\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"nome\" value=\"");
      out.print( request.getParameter("nome") );
      out.write("\" readonly>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"chs\">Carga Horária Semanal:</label>\n");
      out.write("                    <!-- Use scriptlet para acessar os parâmetros passados na URL -->\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"chs\" value=\"");
      out.print( request.getParameter("chs") );
      out.write("\" readonly>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"credito\">Crédito:</label>\n");
      out.write("                    <!-- Use scriptlet para acessar os parâmetros passados na URL -->\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"credito\" value=\"");
      out.print( request.getParameter("credito") );
      out.write("\" readonly>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <a href=\"javascript:history.back()\" class=\"btn btn-primary\">Voltar</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Adicione aqui os scripts necessários, como o Bootstrap e o Font Awesome -->\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js\"></script>\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
      out.write("    <script>\n");
      out.write("        // Adicione scripts personalizados aqui, se necessário\n");
      out.write("    </script>\n");
      out.write("</body>\n");
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
