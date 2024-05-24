package org.apache.jsp.Estudante;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.Estudante;
import Model.Turma;
import java.util.List;
import DAO.TurmaDAO;

public final class EditarEstudante_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <title>Editar Estudante</title>\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"../css/Estudantes.css\">\n");
      out.write("  <script src=\"../js/alertas.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"container\">\n");
      out.write("    <div class=\"text\">\n");
      out.write("        Edição de Estudante\n");
      out.write("    </div>\n");
      out.write("    <form id=\"estudanteForm\" action=\"/ProjectoFinalEngSoftware/EstudanteServlet?action=update\" method=\"post\">\n");
      out.write("        <input type=\"hidden\" name=\"nrMatricula\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.estudante.nrMatricula}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("        <div class=\"form-row\">\n");
      out.write("            <div class=\"input-data\">\n");
      out.write("                <input type=\"text\" name=\"nome\" required value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.estudante.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                <div class=\"underline\"></div>\n");
      out.write("                <label for=\"\">Nome</label>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"input-data\">\n");
      out.write("                <input type=\"text\" name=\"apelido\" required value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.estudante.apelido}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                <div class=\"underline\"></div>\n");
      out.write("                <label for=\"\">Apelido</label>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-row\">\n");
      out.write("            <div class=\"input-data\">\n");
      out.write("                <input type=\"text\" name=\"endereco\" required value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.estudante.endereco}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                <div class=\"underline\"></div>\n");
      out.write("                <label for=\"\">Endereço</label>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"input-data\">\n");
      out.write("                <input type=\"text\" name=\"contacto\" required value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.estudante.contacto}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                <div class=\"underline\"></div>\n");
      out.write("                <label for=\"\">Contacto</label>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-row\">\n");
      out.write("            <div class=\"input-data\">\n");
      out.write("                ");
      out.write("\n");
      out.write("                <div class=\"underline\"></div>\n");
      out.write("                <label for=\"\">Turma</label>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"form-row submit-btn\">\n");
      out.write("            <div class=\"input-data\">\n");
      out.write("                <div class=\"inner\"></div>\n");
      out.write("                <input type=\"submit\" value=\"Salvar Alterações\">\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </form>\n");
      out.write("</div>\n");
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
