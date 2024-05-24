package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.Turma;
import DAO.TurmaDAO;
import java.util.List;
import DAO.EstudanteDAO;
import Model.Estudante;

public final class teste3_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Gerenciar Estudantes</title>\n");
      out.write("    <script>\n");
      out.write("        function preencherFormulario(nrMatricula, nome, apelido, endereco, contacto, idTurma) {\n");
      out.write("            document.getElementById(\"edit_nrMatricula\").value = nrMatricula;\n");
      out.write("            document.getElementById(\"edit_nome\").value = nome;\n");
      out.write("            document.getElementById(\"edit_apelido\").value = apelido;\n");
      out.write("            document.getElementById(\"edit_endereco\").value = endereco;\n");
      out.write("            document.getElementById(\"edit_contacto\").value = contacto;\n");
      out.write("            document.getElementById(\"edit_idTurma\").value = idTurma;\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<h1>Adicionar Novo Estudante</h1>\n");
      out.write("<form action=\"EstudanteServlet?action=add\" method=\"post\">\n");
      out.write("    Nome: <input type=\"text\" name=\"nome\" required><br>\n");
      out.write("    Apelido: <input type=\"text\" name=\"apelido\" required><br>\n");
      out.write("    Endereço: <input type=\"text\" name=\"endereco\" required><br>\n");
      out.write("    Contacto: <input type=\"text\" name=\"contacto\" required><br>\n");
      out.write("    <label for=\"turma\">Turma:</label>\n");
      out.write("    <select id=\"turma\" name=\"idTurma\">\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
 
            TurmaDAO turmaDAO = new TurmaDAO();
            List<Turma> turmas = turmaDAO.listarTurmas();
            for (Turma turma : turmas) { 
      out.write("\n");
      out.write("                <option value=\"");
      out.print( turma.getId() );
      out.write('"');
      out.write('>');
      out.print( turma.getNome() );
      out.write("</option>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("    </select>\n");
      out.write("    <input type=\"submit\" value=\"Adicionar Estudante\">\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("<h1>Buscar Estudante por Nome</h1>\n");
      out.write("<form action=\"\" method=\"get\">\n");
      out.write("    Nome: <input type=\"text\" name=\"nome\" required>\n");
      out.write("    <input type=\"submit\" value=\"Buscar\">\n");
      out.write("</form>\n");
      out.write("\n");

    String nomeParam = request.getParameter("nome");
    if (nomeParam != null && !nomeParam.isEmpty()) {
        EstudanteDAO estudanteDAO = new EstudanteDAO();
        List<Estudante> estudantesEncontrados = estudanteDAO.buscarPorNome(nomeParam);
        if (!estudantesEncontrados.isEmpty()) {

      out.write("\n");
      out.write("<h2>Resultados da Busca por Nome \"");
      out.print( nomeParam );
      out.write("\":</h2>\n");
      out.write("<table border=\"1\">\n");
      out.write("    <tr>\n");
      out.write("        <th>Número de Matrícula</th>\n");
      out.write("        <th>Nome</th>\n");
      out.write("        <th>Apelido</th>\n");
      out.write("        <th>Endereço</th>\n");
      out.write("        <th>Contacto</th>\n");
      out.write("      \n");
      out.write("        <th>Ações</th>\n");
      out.write("    </tr>\n");
      out.write("    ");
 for (Estudante estudante : estudantesEncontrados) { 
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print( estudante.getNrMatricula() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( estudante.getNome() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( estudante.getApelido() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( estudante.getEndereco() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( estudante.getContacto() );
      out.write("</td>\n");
      out.write("            <td>\n");
      out.write("                <button onclick=\"preencherFormulario('");
      out.print( estudante.getNrMatricula() );
      out.write("', '");
      out.print( estudante.getNome() );
      out.write("', '");
      out.print( estudante.getApelido() );
      out.write("', '");
      out.print( estudante.getEndereco() );
      out.write("', '");
      out.print( estudante.getContacto() );
      out.write("', '");
      out.print( estudante.getTurma() != null ? estudante.getTurma().getId() : "" );
      out.write("')\">Editar</button>\n");
      out.write("                <form action=\"EstudanteServlet?action=delete\" method=\"post\">\n");
      out.write("                    <input type=\"hidden\" name=\"nrMatricula\" value=\"");
      out.print( estudante.getNrMatricula() );
      out.write("\">\n");
      out.write("                    <input type=\"submit\" value=\"Apagar\">\n");
      out.write("                </form>\n");
      out.write("            </td>\n");
      out.write("        </tr>\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("</table>\n");

        } else {

      out.write("\n");
      out.write("<p>Nenhum estudante encontrado com o nome \"");
      out.print( nomeParam );
      out.write("\".</p>\n");

        }
    }

      out.write("\n");
      out.write("\n");
      out.write("<h1>Lista de Estudantes</h1>\n");
      out.write("<table border=\"1\">\n");
      out.write("    <tr>\n");
      out.write("        <th>Número de Matrícula</th>\n");
      out.write("        <th>Nome</th>\n");
      out.write("        <th>Apelido</th>\n");
      out.write("        <th>Endereço</th>\n");
      out.write("        <th>Contacto</th>\n");
      out.write("        <th>Turma</th>\n");
      out.write("        <th>Ações</th>\n");
      out.write("    </tr>\n");
      out.write("    ");
 
        EstudanteDAO estudanteDAO = new EstudanteDAO();
        List<Estudante> listaEstudantes = estudanteDAO.listarEstudantesComTurma();
        for (Estudante estudante : listaEstudantes) { 
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print( estudante.getNrMatricula() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( estudante.getNome() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( estudante.getApelido() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( estudante.getEndereco() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( estudante.getContacto() );
      out.write("</td>\n");
      out.write("           <td>");
      out.print( estudante.getTurma() != null ? estudante.getTurma().getNome() : "Turma não definida" );
      out.write("</td>\n");
      out.write("<td>\n");
      out.write("    <button onclick=\"preencherFormulario('");
      out.print( estudante.getNrMatricula() );
      out.write("', '");
      out.print( estudante.getNome() );
      out.write("', '");
      out.print( estudante.getApelido() );
      out.write("', '");
      out.print( estudante.getEndereco() );
      out.write("', '");
      out.print( estudante.getContacto() );
      out.write("', '");
      out.print( estudante.getTurma() != null ? estudante.getTurma().getId() : "" );
      out.write("')\">Editar</button>\n");
      out.write("    <form action=\"EstudanteServlet?action=delete\" method=\"post\">\n");
      out.write("        <input type=\"hidden\" name=\"nrMatricula\" value=\"");
      out.print( estudante.getNrMatricula() );
      out.write("\">\n");
      out.write("        <input type=\"submit\" value=\"Apagar\">\n");
      out.write("    </form>\n");
      out.write("</td>\n");
      out.write("</tr>\n");
 } 
      out.write("\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("<h1>Editar Estudante</h1>\n");
      out.write("<form action=\"EstudanteServlet?action=edit\" method=\"post\">\n");
      out.write("    <input type=\"hidden\" id=\"edit_nrMatricula\" name=\"nrMatricula\">\n");
      out.write("    Nome: <input type=\"text\" id=\"edit_nome\" name=\"nome\" required><br>\n");
      out.write("    Apelido: <input type=\"text\" id=\"edit_apelido\" name=\"apelido\" required><br>\n");
      out.write("    Endereço: <input type=\"text\" id=\"edit_endereco\" name=\"endereco\" required><br>\n");
      out.write("    Contacto: <input type=\"text\" id=\"edit_contacto\" name=\"contacto\" required><br>\n");
      out.write("    <label for=\"edit_idTurma\">Turma:</label>\n");
      out.write("    <select id=\"edit_idTurma\" name=\"idTurma\">\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
 
             turmaDAO = new TurmaDAO();
            List<Turma> turmass = turmaDAO.listarTurmas();
            for (Turma turma : turmass) { 
      out.write("\n");
      out.write("                <option value=\"");
      out.print( turma.getId() );
      out.write('"');
      out.write('>');
      out.print( turma.getNome() );
      out.write("</option>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("    </select>\n");
      out.write("    <input type=\"submit\" value=\"Atualizar\">\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
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
