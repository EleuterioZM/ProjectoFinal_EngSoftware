package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;

public final class teste1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Gerenciar Disciplinas</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>Adicionar Nova Disciplina</h1>\n");
      out.write("    <form action=\"DisciplinaServlet\" method=\"post\">\n");
      out.write("        Nome: <input type=\"text\" name=\"nome\" required><br>\n");
      out.write("        Carga Horária Semanal: <input type=\"text\" name=\"chs\" required><br>\n");
      out.write("        Crédito: <input type=\"text\" name=\"credito\" required><br>\n");
      out.write("        <input type=\"hidden\" name=\"action\" value=\"add\">\n");
      out.write("        <input type=\"submit\" value=\"Adicionar Disciplina\">\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("<h1>Buscar Disciplina por Nome</h1>\n");
      out.write("<form action=\"\" method=\"get\">\n");
      out.write("    Nome: <input type=\"text\" name=\"nome\" required>\n");
      out.write("    <input type=\"hidden\" name=\"action\" value=\"searchByName\">\n");
      out.write("    <input type=\"submit\" value=\"Buscar\">\n");
      out.write("</form>\n");
      out.write("\n");

    String nomeParam = request.getParameter("nome");
    if (nomeParam != null && !nomeParam.isEmpty()) {
        DAO.DisciplinaDAO disciplinaDAO = new DAO.DisciplinaDAO();
        List<Model.Disciplina> disciplinasEncontradas = disciplinaDAO.buscarPorNome(nomeParam);
        if (!disciplinasEncontradas.isEmpty()) {

      out.write("\n");
      out.write("<h2>Resultados da Busca por Nome \"");
      out.print( nomeParam );
      out.write("\":</h2>\n");
      out.write("<table border=\"1\">\n");
      out.write("    <tr>\n");
      out.write("        <th>ID</th>\n");
      out.write("        <th>Nome</th>\n");
      out.write("        <th>Carga Horária Semanal</th>\n");
      out.write("        <th>Crédito</th>\n");
      out.write("        <th>Ações</th>\n");
      out.write("    </tr>\n");
      out.write("    ");
 for (Model.Disciplina disciplina : disciplinasEncontradas) { 
      out.write("\n");
      out.write("    <tr>\n");
      out.write("        <td>");
      out.print( disciplina.getId() );
      out.write("</td>\n");
      out.write("        <td>");
      out.print( disciplina.getNome() );
      out.write("</td>\n");
      out.write("        <td>");
      out.print( disciplina.getChs() );
      out.write("</td>\n");
      out.write("        <td>");
      out.print( disciplina.getCredito() );
      out.write("</td>\n");
      out.write("        <td>\n");
      out.write("            <form action=\"DisciplinaServlet\" method=\"post\">\n");
      out.write("                <input type=\"hidden\" name=\"id\" value=\"");
      out.print( disciplina.getId() );
      out.write("\">\n");
      out.write("                <input type=\"hidden\" name=\"action\" value=\"edit\">\n");
      out.write("                <input type=\"submit\" value=\"Editar\">\n");
      out.write("            </form>\n");
      out.write("            <form action=\"DisciplinaServlet\" method=\"post\">\n");
      out.write("                <input type=\"hidden\" name=\"id\" value=\"");
      out.print( disciplina.getId() );
      out.write("\">\n");
      out.write("                <input type=\"hidden\" name=\"action\" value=\"delete\">\n");
      out.write("                <input type=\"submit\" value=\"Apagar\">\n");
      out.write("            </form>\n");
      out.write("        </td>\n");
      out.write("    </tr>\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("</table>\n");

        } else {

      out.write("\n");
      out.write("<p>Nenhuma disciplina encontrada com o nome \"");
      out.print( nomeParam );
      out.write("\".</p>\n");

        }
    }

      out.write("\n");
      out.write("\n");
      out.write("    <h1>Lista de Disciplinas</h1>\n");
      out.write("    <table border=\"1\">\n");
      out.write("        <tr>\n");
      out.write("            <th>ID</th>\n");
      out.write("            <th>Nome</th>\n");
      out.write("            <th>Carga Horária Semanal</th>\n");
      out.write("            <th>Crédito</th>\n");
      out.write("            <th>Ações</th>\n");
      out.write("        </tr>\n");
      out.write("        ");
 
            DAO.DisciplinaDAO disciplinaDAO = new DAO.DisciplinaDAO();
            for (Model.Disciplina disciplina : disciplinaDAO.listarDisciplinas()) {
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print( disciplina.getId() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( disciplina.getNome() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( disciplina.getChs() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( disciplina.getCredito() );
      out.write("</td>\n");
      out.write("            <td>\n");
      out.write("                <form action=\"DisciplinaServlet\" method=\"post\">\n");
      out.write("                    <input type=\"hidden\" name=\"id\" value=\"");
      out.print( disciplina.getId() );
      out.write("\">\n");
      out.write("                    <input type=\"hidden\" name=\"action\" value=\"edit\">\n");
      out.write("                    <input type=\"submit\" value=\"Editar\">\n");
      out.write("                </form>\n");
      out.write("                <form action=\"DisciplinaServlet\" method=\"post\">\n");
      out.write("                    <input type=\"hidden\" name=\"id\" value=\"");
      out.print( disciplina.getId() );
      out.write("\">\n");
      out.write("                    <input type=\"hidden\" name=\"action\" value=\"delete\">\n");
      out.write("                    <input type=\"submit\" value=\"Apagar\">\n");
      out.write("                </form>\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("    </table>\n");
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
