package org.apache.jsp.Avaliacao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class FRMCadastroAvaliacao_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Avaliacao/../Dashboard/Dashboard.jsp");
  }

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
      out.write(" \n");
      out.write("\n");
      out.write("<div class=\"sidebar\">\n");
      out.write("        ");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\" dir=\"ltr\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>Dashboard</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"../css/Dashboard.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-2/css/all.min.css\">\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js\" charset=\"utf-8\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div>\n");
      out.write("        <!--wrapper start-->\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("            <!--header menu start-->\n");
      out.write("            <div class=\"header\">\n");
      out.write("                <div class=\"header-menu\">\n");
      out.write("                    <div class=\"sidebar-btn\">\n");
      out.write("                        <i class=\"fas fa-bars\"></i>\n");
      out.write("                    </div>\n");
      out.write("                    <ul></ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!--header menu end-->\n");
      out.write("            <!--sidebar start-->\n");
      out.write("            <div class=\"sidebar\">\n");
      out.write("                <div class=\"sidebar-menu\">\n");
      out.write("                    <center class=\"profile\">\n");
      out.write("                        <img src=\"../img/OJZ2J70.jpg\" alt=\"\">\n");
      out.write("                        <p>Gestão de estudantes</p>\n");
      out.write("                    </center>\n");
      out.write("                    <li class=\"item\">\n");
      out.write("                        <a href=\"#\" class=\"menu-btn\">\n");
      out.write("                            <i class=\"fas fa-home\"></i><span>Página Inicial</span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"item\">\n");
      out.write("                        <a href=\"#\" class=\"menu-btn\">\n");
      out.write("                            <i class=\"fas fa-desktop\"></i><span>Dashboard</span>\n");
      out.write("                        </a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"item\" id=\"avaliacao\">\n");
      out.write("                        <a href=\"#avaliacao\" class=\"menu-btn\">\n");
      out.write("                            <i class=\"fas fa-star\"></i><span>Avaliação <i class=\"fas fa-chevron-down drop-down\"></i></span>\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"sub-menu\">\n");
      out.write("                            <a href=\"#\"><i class=\"fas fa-plus\"></i><span>Adicionar Avaliação</span></a>\n");
      out.write("                            <a href=\"#\"><i class=\"fas fa-eye\"></i><span>Visualizar Avaliações</span></a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"item\" id=\"curso\">\n");
      out.write("                        <a href=\"#curso\" class=\"menu-btn\">\n");
      out.write("                            <i class=\"fas fa-book\"></i><span>Curso <i class=\"fas fa-chevron-down drop-down\"></i></span>\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"sub-menu\">\n");
      out.write("                            <a href=\"#\"><i class=\"fas fa-plus\"></i><span>Adicionar Curso</span></a>\n");
      out.write("                            <a href=\"#\"><i class=\"fas fa-eye\"></i><span>Visualizar Cursos</span></a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"item\" id=\"turma\">\n");
      out.write("                        <a href=\"#turma\" class=\"menu-btn\">\n");
      out.write("                            <i class=\"fas fa-users\"></i><span>Turma <i class=\"fas fa-chevron-down drop-down\"></i></span>\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"sub-menu\">\n");
      out.write("                            <a href=\"#\"><i class=\"fas fa-plus\"></i><span>Adicionar Turma</span></a>\n");
      out.write("                            <a href=\"#\"><i class=\"fas fa-eye\"></i><span>Visualizar Turmas</span></a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"item\" id=\"estudante\">\n");
      out.write("                        <a href=\"#estudante\" class=\"menu-btn\">\n");
      out.write("                            <i class=\"fas fa-user-graduate\"></i><span>Estudante <i class=\"fas fa-chevron-down drop-down\"></i></span>\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"sub-menu\">\n");
      out.write("                            <a href=\"#\"><i class=\"fas fa-plus\"></i><span>Adicionar Estudante</span></a>\n");
      out.write("                            <a href=\"#\"><i class=\"fas fa-eye\"></i><span>Visualizar Estudantes</span></a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"item\" id=\"disciplina\">\n");
      out.write("                        <a href=\"#disciplina\" class=\"menu-btn\">\n");
      out.write("                            <i class=\"fas fa-book-reader\"></i><span>Disciplina <i class=\"fas fa-chevron-down drop-down\"></i></span>\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"sub-menu\">\n");
      out.write("                            <a href=\"#\"><i class=\"fas fa-plus\"></i><span>Adicionar Disciplina</span></a>\n");
      out.write("                                                     <a href=\"#\"><i class=\"fas fa-eye\"></i><span>Visualizar Disciplinas</span></a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"item\" id=\"nota\">\n");
      out.write("                        <a href=\"#nota\" class=\"menu-btn\">\n");
      out.write("                            <i class=\"fas fa-graduation-cap\"></i><span>Nota <i class=\"fas fa-chevron-down drop-down\"></i></span>\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"sub-menu\">\n");
      out.write("                            <a href=\"#\"><i class=\"fas fa-plus\"></i><span>Adicionar Nota</span></a>\n");
      out.write("                            <a href=\"#\"><i class=\"fas fa-eye\"></i><span>Visualizar Notas</span></a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!--sidebar end-->\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        $(document).ready(function(){\n");
      out.write("            $(\".sidebar-btn\").click(function(){\n");
      out.write("                $(\".wrapper\").toggleClass(\"collapse\");\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            $(\".menu-btn\").click(function(){\n");
      out.write("                $(this).next(\".sub-menu\").slideToggle();\n");
      out.write("                $(this).find(\".drop-down\").toggleClass(\"rotate\");\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>Cadastrar Avaliação</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/Estudantes.css\">\n");
      out.write("   <style>\n");
      out.write("        \n");
      out.write("        .sidebar {\n");
      out.write("           \n");
      out.write("         \n");
      out.write("            position: fixed;\n");
      out.write("            top: 0;\n");
      out.write("            left: 0;\n");
      out.write("            bottom: 0;\n");
      out.write("            overflow-y: auto;\n");
      out.write("        }\n");
      out.write("        .content {\n");
      out.write("            flex: 1;\n");
      out.write("            margin-left: 140px; /* Largura do dashboard */\n");
      out.write("            padding-top: 70px; /* Espaçamento do topo */\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"text\">\n");
      out.write("                Cadastro de Avaliação\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/AvaliacaoServlet?action=add\" method=\"post\">\n");
      out.write("\n");
      out.write("                <div class=\"form-row\">\n");
      out.write("                    <div class=\"input-data\">\n");
      out.write("                        <input type=\"text\" required name=\"descricao\">\n");
      out.write("                        <div class=\"underline\"></div>\n");
      out.write("                        <label for=\"\">Descrição</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-data\">\n");
      out.write("                        <input type=\"number\" step=\"0.01\" name=\"peso\" required>\n");
      out.write("                        <div class=\"underline\"></div>\n");
      out.write("                        <label for=\"\">Peso</label>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-row submit-btn\">\n");
      out.write("                    <div class=\"input-data\">\n");
      out.write("                        <div class=\"inner\"></div>\n");
      out.write("                        <input type=\"submit\" value=\"Cadastrar\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
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
