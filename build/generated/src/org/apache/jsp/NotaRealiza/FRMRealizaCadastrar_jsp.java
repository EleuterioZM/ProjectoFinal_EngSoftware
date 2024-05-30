package org.apache.jsp.NotaRealiza;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.Avaliacao;
import java.util.List;
import DAO.AvaliacaoDAO;
import Model.Estudante;
import DAO.EstudanteDAO;

public final class FRMRealizaCadastrar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"sidebar\">\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>Realizar Avaliação</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css\">\n");
      out.write("        <!-- Você pode precisar ajustar o caminho para o seu arquivo CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/Estudantes.css\">\n");
      out.write("        <!-- Adicionando o Font Awesome CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            /* Adiciona um estilo para colocar os elementos em linha */\n");
      out.write("            .form-row {\n");
      out.write("                display: flex;\n");
      out.write("                justify-content: space-between;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .sidebar {\n");
      out.write("\n");
      out.write("\n");
      out.write("                position: fixed;\n");
      out.write("                top: 0;\n");
      out.write("                left: 0;\n");
      out.write("                bottom: 0;\n");
      out.write("                overflow-y: auto;\n");
      out.write("            }\n");
      out.write("            .content {\n");
      out.write("                flex: 1;\n");
      out.write("                margin-left: 140px; /* Largura do dashboard */\n");
      out.write("                padding-top: 70px; /* Espaçamento do topo */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"text\">\n");
      out.write("                Adicionar Avaliação\n");
      out.write("            </div>\n");
      out.write("            <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/RealizaServlet?action=add\" method=\"post\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"form-row\">\n");
      out.write("                    <div class=\"input-data\">\n");
      out.write("                        <input type=\"number\" name=\"nota\" step=\"0.1\" min=\"0\" max=\"20\" required>\n");
      out.write("                        <div class=\"underline\"></div>\n");
      out.write("                        <label for=\"nota\">Nota:</label>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"form-row\">\n");
      out.write("                    <div class=\"input-data\">\n");
      out.write("                        <select name=\"idAvaliacao\" required>\n");
      out.write("                            <option value=\"\" disabled selected>Selecione a Avaliação</option>\n");
      out.write("                            ");

                                AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
                                List<Avaliacao> avaliacoes = avaliacaoDAO.listarAvaliacoes();
                                for (Avaliacao avaliacao : avaliacoes) {
      out.write("\n");
      out.write("                            <option value=\"");
      out.print( avaliacao.getId());
      out.write('"');
      out.write('>');
      out.print( avaliacao.getDescricao());
      out.write("</option>\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-data\">\n");
      out.write("                        <select name=\"idEstudante\" required>\n");
      out.write("                            <option value=\"\" disabled selected>Selecione o Estudante</option>\n");
      out.write("                            ");

                                EstudanteDAO estudanteDAO = new EstudanteDAO();
                                List<Estudante> estudantes = estudanteDAO.listarEstudantes();
                                for (Estudante estudante : estudantes) {
      out.write("\n");
      out.write("                            <option value=\"");
      out.print( estudante.getNrMatricula());
      out.write('"');
      out.write('>');
      out.print( estudante.getNome());
      out.write("</option>\n");
      out.write("                            ");
 }
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"form-row submit-btn\">\n");
      out.write("                    <div class=\"input-data\">\n");
      out.write("                        <div class=\"inner\"></div>\n");
      out.write("                        <input type=\"submit\" value=\"Enviar Avaliação\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <a href=\"FRMListarEstudantes.jsp\" style=\"position: fixed; top: 20px; left: 20px; z-index: 9999;\">\n");
      out.write("            <i class=\"fas fa-arrow-right fa-flip-horizontal rotate-icon\" style=\"font-size: 30px; color: white;\"></i>\n");
      out.write("        </a>             \n");
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
