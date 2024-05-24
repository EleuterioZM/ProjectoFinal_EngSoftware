package org.apache.jsp.Turma;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class FRMExclusaoTurma_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Exclusão de Turma</title>\n");
      out.write("\n");
      out.write("    <style>\n");
      out.write("        \n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .modal-container {\n");
      out.write("            position: fixed;\n");
      out.write("            top: 0;\n");
      out.write("            left: 0;\n");
      out.write("            width: 100%;\n");
      out.write("            height: 120%;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            background-image: url('../img/view-3d-school-classroom.jpg'); /* Caminho da sua imagem de fundo */\n");
      out.write("            background-size: cover;\n");
      out.write("            background-repeat: no-repeat;\n");
      out.write("            background-attachment: fixed;\n");
      out.write("            backdrop-filter: blur(5px); /* Adiciona um efeito de desfoque ao fundo */\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .modal-content {\n");
      out.write("            background-color: rgba(255, 255, 255, 0.8); /* Cor de fundo semi-transparente */\n");
      out.write("            padding: 20px;\n");
      out.write("            border-radius: 8px;\n");
      out.write("            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);\n");
      out.write("            max-width: 500px;\n");
      out.write("            width: 100%;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .modal-content h2 {\n");
      out.write("            margin-top: 0;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .modal-content p {\n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .modal-content button {\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 4px;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        /* Estilo para o botão Confirmar */\n");
      out.write("        .confirm-button {\n");
      out.write("            background-color: #f44336; /* Cor vermelha */\n");
      out.write("            color: white;\n");
      out.write("            margin-right: 10px; /* Adiciona um espaçamento à direita */\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        /* Estilo para o botão Cancelar */\n");
      out.write("        .cancel-button {\n");
      out.write("            background-color: #4CAF50; /* Cor verde */\n");
      out.write("            color: white;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"modal-container\">\n");
      out.write("        <div class=\"modal-content\">\n");
      out.write("            <h2>Exclusão de Turma</h2>\n");
      out.write("            <p>Deseja realmente excluir a turma \"");
      out.print( request.getParameter("nome") );
      out.write("\"?</p>\n");
      out.write("    <form id=\"deleteForm\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/TurmaServlet?action=delete\" method=\"POST\">\n");
      out.write("   \n");
      out.write("    <input type=\"hidden\" id=\"turmaId\" name=\"id\" value=\"");
      out.print( request.getParameter("id") );
      out.write("\">\n");
      out.write("<input type=\"hidden\" id=\"turmaNome\" name=\"nome\" value=\"");
      out.print( request.getParameter("nome") );
      out.write("\">\n");
      out.write("\n");
      out.write("    <input type=\"hidden\" name=\"action\" value=\"delete\">\n");
      out.write("    <!-- Outros campos ou conteúdo conforme necessário -->\n");
      out.write("    <button type=\"submit\" class=\"confirm-button\" onclick=\"logFormData()\">Confirmar Exclusão</button>\n");
      out.write("    <button type=\"button\" class=\"cancel-button\" onclick=\"fecharModal()\">Cancelar</button>\n");
      out.write("</form>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("        function fecharModal() {\n");
      out.write("            window.location.href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Turma/FRMListarTurmas.jsp\"; // Redirecionar de volta para a página de listagem\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</body>\n");
      out.write("<script>\n");
      out.write("    function logFormData() {\n");
      out.write("        var id = document.getElementById(\"turmaId\").value;\n");
      out.write("        var nome = document.getElementById(\"turmaNome\").value;\n");
      out.write("        \n");
      out.write("        console.log(\"ID da turma: \", id);\n");
      out.write("        console.log(\"Nome da turma: \", nome);\n");
      out.write("\n");
      out.write("        // Retorna true para permitir a submissão do formulário\n");
      out.write("        return true;\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("\n");
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
