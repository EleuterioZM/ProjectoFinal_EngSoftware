package org.apache.jsp.Home_005fPage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"pt-br\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\n");
      out.write("        <meta name=\"description\" content=\"\" />\n");
      out.write("        <meta name=\"author\" content=\"\" />\n");
      out.write("        <title>Sistema de Gestão de Estudantes - Tema Bootstrap</title>\n");
      out.write("        <!-- Ícone-->\n");
      out.write("        <link rel=\"icon\" type=\"image/x-icon\" href=\"assets/favicon.ico\" />\n");
      out.write("        <!-- Ícones do Bootstrap-->\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css\" rel=\"stylesheet\" />\n");
      out.write("        <!-- Fontes do Google-->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <!-- CSS do plugin SimpleLightbox-->\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.css\" rel=\"stylesheet\" />\n");
      out.write("        <!-- CSS do tema principal (inclui o Bootstrap)-->\n");
      out.write("        <link href=\"../css/Pagina_Inicial.css\" rel=\"stylesheet\" />\n");
      out.write("    </head>\n");
      out.write("    <body id=\"page-top\">\n");
      out.write("          <a href=\"index.jsp\" style=\"position: fixed; top: 20px; left: 20px; z-index: 9999;\">\n");
      out.write("    <i class=\"fas fa-arrow-right\" style=\"font-size: 24px; color: white;\"></i>\n");
      out.write("</a>\n");
      out.write("        <!-- Navegação-->\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light fixed-top py-3\" id=\"mainNav\">\n");
      out.write("            <div class=\"container px-4 px-lg-5\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"#page-top\"><i class=\"bi bi-people\"></i> Sistema de Gestão de Estudantes</a>\n");
      out.write("                <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\" aria-expanded=\"false\" aria-label=\"Toggle navigation\"><span class=\"navbar-toggler-icon\"></span></button>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <!-- Cabeçalho-->\n");
      out.write("        <header class=\"masthead\">\n");
      out.write("            <div class=\"container px-4 px-lg-5 h-100\">\n");
      out.write("                <div class=\"row gx-4 gx-lg-5 h-100 align-items-center justify-content-center text-center\">\n");
      out.write("                    <div class=\"col-lg-8 align-self-end\">\n");
      out.write("                        <h1 class=\"text-white font-weight-bold\">Sistema Educacional Inteligente</h1>\n");
      out.write("\n");
      out.write("                        <hr class=\"divider\" />\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-8 align-self-baseline\">\n");
      out.write("                        <p class=\"text-white-75 mb-5\">O Sistema de Gestão de Estudantes pode ajudá-lo a gerenciar os alunos de forma eficaz! Basta integrá-lo e começar a gerenciar, sem complicações!</p>\n");
      out.write("                        <a class=\"btn btn-primary btn-xl me-2\" href=\"../Home_Page/PesquisarEstudante.jsp\">Alunos</a>\n");
      out.write("                        <a class=\"btn btn-success btn-xl\" href=\"../Admin_dashbaord/dashboard-crm.jsp\">Administradores</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("        <!-- Sobre-->\n");
      out.write("        <!-- JS do Bootstrap-->\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("        <!-- JS do plugin SimpleLightbox-->\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/SimpleLightbox/2.1.0/simpleLightbox.min.js\"></script>\n");
      out.write("        <!-- JS do tema principal-->\n");
      out.write("        <script src=\"../js/scripts.js\"></script>\n");
      out.write("        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->\n");
      out.write("        <!-- * *                               JS do Formulário SB                               * *-->\n");
      out.write("        <!-- * * Ative seu formulário em https://startbootstrap.com/solution/contact-forms * *-->\n");
      out.write("        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->\n");
      out.write("        <script src=\"https://cdn.startbootstrap.com/sb-forms-latest.js\"></script>\n");
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
