package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class teste_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Teste Avaliação Servlet</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>Adicionar Nova Avaliação</h1>\n");
      out.write("    <form action=\"AvaliacaoServlet\" method=\"post\">\n");
      out.write("        Descrição: <input type=\"text\" name=\"descricao\" required><br>\n");
      out.write("        Peso: <input type=\"text\" name=\"peso\" required><br>\n");
      out.write("        <input type=\"hidden\" name=\"action\" value=\"add\">\n");
      out.write("        <input type=\"submit\" value=\"Adicionar Avaliação\">\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("    <hr>\n");
      out.write("\n");
      out.write("    <h1>Buscar Avaliação por ID</h1>\n");
      out.write("    <form action=\"\" method=\"get\">\n");
      out.write("        ID: <input type=\"text\" name=\"id\" required>\n");
      out.write("        <input type=\"hidden\" name=\"action\" value=\"search\">\n");
      out.write("        <input type=\"submit\" value=\"Buscar\">\n");
      out.write("    </form>\n");
      out.write("    \n");
      out.write("    ");

        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);
            DAO.AvaliacaoDAO avaliacaoDAO = new DAO.AvaliacaoDAO();
            Model.Avaliacao avaliacao = avaliacaoDAO.buscarPorId(id);
    
      out.write("\n");
      out.write("    <h2>Resultado da Busca:</h2>\n");
      out.write("    <table border=\"1\">\n");
      out.write("        <tr>\n");
      out.write("            <th>ID</th>\n");
      out.write("            <th>Descrição</th>\n");
      out.write("            <th>Peso</th>\n");
      out.write("            <th>Ações</th>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print( avaliacao.getId() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( avaliacao.getDescricao() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( avaliacao.getPeso() );
      out.write("</td>\n");
      out.write("            <td>\n");
      out.write("                <form action=\"AvaliacaoServlet\" method=\"post\">\n");
      out.write("                    <input type=\"hidden\" name=\"id\" value=\"");
      out.print( avaliacao.getId() );
      out.write("\">\n");
      out.write("                    <input type=\"hidden\" name=\"action\" value=\"edit\">\n");
      out.write("                    <input type=\"submit\" value=\"Editar\">\n");
      out.write("                </form>\n");
      out.write("                <form action=\"AvaliacaoServlet\" method=\"post\">\n");
      out.write("                    <input type=\"hidden\" name=\"id\" value=\"");
      out.print( avaliacao.getId() );
      out.write("\">\n");
      out.write("                    <input type=\"hidden\" name=\"action\" value=\"delete\">\n");
      out.write("                    <input type=\"submit\" value=\"Apagar\">\n");
      out.write("                </form>\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("    </table>\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("    <hr>\n");
      out.write("\n");
      out.write("    <h1>Lista de Avaliações</h1>\n");
      out.write("    <table border=\"1\">\n");
      out.write("        <tr>\n");
      out.write("            <th>ID</th>\n");
      out.write("            <th>Descrição</th>\n");
      out.write("            <th>Peso</th>\n");
      out.write("            <th>Ações</th>\n");
      out.write("        </tr>\n");
      out.write("        ");
 
            DAO.AvaliacaoDAO avaliacaoDAO = new DAO.AvaliacaoDAO();
            for (Model.Avaliacao avaliacao : avaliacaoDAO.listarAvaliacoes()) {
        
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print( avaliacao.getId() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( avaliacao.getDescricao() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( avaliacao.getPeso() );
      out.write("</td>\n");
      out.write("           <td>\n");
      out.write("    <form action=\"AvaliacaoServlet\" method=\"post\">\n");
      out.write("        <input type=\"hidden\" name=\"id\" value=\"");
      out.print( avaliacao.getId() );
      out.write("\">\n");
      out.write("        <input type=\"hidden\" name=\"action\" value=\"edit\">\n");
      out.write("        <input type=\"submit\" value=\"Editar\">\n");
      out.write("    </form>\n");
      out.write("    <form action=\"AvaliacaoServlet\" method=\"post\">\n");
      out.write("        <input type=\"hidden\" name=\"id\" value=\"");
      out.print( avaliacao.getId() );
      out.write("\">\n");
      out.write("        <input type=\"hidden\" name=\"action\" value=\"delete\">\n");
      out.write("        <input type=\"submit\" value=\"Apagar\">\n");
      out.write("    </form>\n");
      out.write("</td>\n");
      out.write("\n");
      out.write("        </tr>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("    </table>\n");
      out.write("\n");
      out.write("    <br>\n");
      out.write("    <a href=\"AvaliacaoServlet\">Atualizar Lista</a>\n");
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
