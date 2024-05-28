package org.apache.jsp.Disciplina;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class FRMCadastroDisciplina_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <title>Cadastrar Disciplina</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/Estudantes.css\"> <!-- Reusing the same CSS file -->\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write(" \n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"text\">\n");
      out.write("                Cadastro de Disciplina\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/DisciplinaServlet?action=add\" method=\"post\">\n");
      out.write("\n");
      out.write("                <div class=\"form-row\">\n");
      out.write("                    <div class=\"input-data\">\n");
      out.write("                        <input type=\"text\" required name=\"nome\">\n");
      out.write("                        <div class=\"underline\"></div>\n");
      out.write("                        <label for=\"\">Nome</label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"input-data\">\n");
      out.write("                        <input type=\"number\" required name=\"chs\">\n");
      out.write("                        <div class=\"underline\"></div>\n");
      out.write("                        <label for=\"\">Carga Horária Semanal</label>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-row\">\n");
      out.write("                    <div class=\"input-data\">\n");
      out.write("                        <input type=\"number\" required name=\"credito\">\n");
      out.write("                        <div class=\"underline\"></div>\n");
      out.write("                        <label for=\"\">Crédito</label>\n");
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
      out.write("    </body>\n");
      out.write("  \n");
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
