package org.apache.jsp.Turma;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DAO.TurmaDAO;
import Model.Turma;
import java.util.List;

public final class FRMListarTurmas_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Turma/../includes/menu.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_when_test.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <title>Listagem de Turmas</title>\n");
      out.write("        <!-- Adicione aqui os links para os arquivos CSS do Bootstrap -->\n");
      out.write("        <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- Adicione aqui os links para os arquivos CSS de ícones, como Font Awesome -->\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\" rel=\"stylesheet\">\n");
      out.write("             <link rel=\"stylesheet\" type=\"text/css\" href=\"../includes/bootstrap.css\" />\n");
      out.write("        <link href=\"../includes/style.css\" rel=\"stylesheet\" />\n");
      out.write("         <link href=\"https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap\" rel=\"stylesheet\">\n");
      out.write("    \n");
      out.write("        <style>\n");
      out.write("            body {\n");
      out.write("                background-color: #ff9966; /* Cor de fundo */\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script src=\"../js/alertas.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            // Chamar a função para exibir a mensagem de exclusão com sucesso quando a página for carregada\n");
      out.write("            window.onload = function () {\n");
      out.write("                showDeleteSuccessMessage();\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            function editarTurma(turmaId, turmaNome) {\n");
      out.write("                window.location.href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/TurmaServlet?action=edit&id=\" + turmaId + \"&nome=\" + turmaNome;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("          ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!-- header section strats -->\n");
      out.write("    <header class=\"header_section\">\n");
      out.write("      <div class=\"container-fluid\">\n");
      out.write("        <nav class=\"navbar navbar-expand-lg custom_nav-container\">\n");
      out.write("          <a class=\"navbar-brand\" href=\"index.html\">\n");
      out.write("           \n");
      out.write("          </a>\n");
      out.write("          <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("          </button>\n");
      out.write("\n");
      out.write("          <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("            <ul class=\"navbar-nav  \">\n");
      out.write("              <li class=\"nav-item active\">\n");
      out.write("                <a class=\"nav-link\" href=\"index.html\">Página Inicial <span class=\"sr-only\">(current)</span></a>\n");
      out.write("              </li>\n");
      out.write("              <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link\" href=\"cursos.html\"> Cursos</a>\n");
      out.write("              </li>\n");
      out.write("              <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link\" href=\"alunos.html\">Alunos </a>\n");
      out.write("              </li>\n");
      out.write("              <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link\" href=\"matriculas.html\"> Matrículas </a>\n");
      out.write("              </li>\n");
      out.write("            </ul>\n");
      out.write("            <div class=\"user_option\">\n");
      out.write("              <a href=\"\">\n");
      out.write("                <span>\n");
      out.write("                  Login\n");
      out.write("                </span>\n");
      out.write("              </a>\n");
      out.write("              <form class=\"form-inline my-2 my-lg-0 ml-0 ml-lg-4 mb-3 mb-lg-0\">\n");
      out.write("                <button class=\"btn  my-2 my-sm-0 nav_search-btn\" type=\"submit\"></button>\n");
      out.write("              </form>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          <div>\n");
      out.write("            <div class=\"custom_menu-btn \">\n");
      out.write("              <button>\n");
      out.write("                <span class=\" s-1\">\n");
      out.write("\n");
      out.write("                </span>\n");
      out.write("                <span class=\"s-2\">\n");
      out.write("\n");
      out.write("                </span>\n");
      out.write("                <span class=\"s-3\">\n");
      out.write("\n");
      out.write("                </span>\n");
      out.write("              </button>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("        </nav>\n");
      out.write("      </div>\n");
      out.write("    </header>\n");
      out.write("   \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container mt-4\">\n");
      out.write("            ");
      out.write("\n");
      out.write("            ");
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h1 class=\"mt-4\" style=\"color:white\">Listagem de Turmas</h1>\n");
      out.write("\n");
      out.write("            <div class=\"text-right mb-4\">\n");
      out.write("                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/TurmaServlet?action=report\" class=\"btn btn-info\" download>Gerar Relatório</a>\n");
      out.write("\n");
      out.write("                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Turma/FRMCadastroTurma.jsp\" class=\"btn btn-success\">Adicionar Turma</a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <table class=\"table table-striped mt-4 table-dark\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th scope=\"col\">#</th>\n");
      out.write("                        <th scope=\"col\">ID</th>\n");
      out.write("                        <th scope=\"col\">Nome</th>\n");
      out.write("\n");
      out.write("                        <th scope=\"col\">Ações</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");

                        int pageSize = 6;
                        int currentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1;
                        TurmaDAO turmaDAO = new TurmaDAO();
                        List<Turma> listaTurmas = turmaDAO.listarTurmas();
                        int totalTurmas = listaTurmas.size();
                        int totalPages = (int) Math.ceil((double) totalTurmas / pageSize);
                        int startIndex = (currentPage - 1) * pageSize;
                        int endIndex = Math.min(startIndex + pageSize, totalTurmas);
                        int count = startIndex;
                        for (Turma turma : listaTurmas.subList(startIndex, endIndex)) {
                            count++;
                    
      out.write("\n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( count);
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( turma.getId());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( turma.getNome());
      out.write("</td>\n");
      out.write("                        <td>\n");
      out.write("                            <a href=\"javascript:void(0);\" onclick=\"editarTurma(");
      out.print( turma.getId());
      out.write(", '");
      out.print( turma.getNome());
      out.write("')\" class=\"btn btn-primary btn-sm\"><i class=\"fas fa-edit\"></i></a>\n");
      out.write("                            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Turma/FRMExclusaoTurma.jsp?id=");
      out.print( turma.getId());
      out.write("&nome=");
      out.print( turma.getNome());
      out.write("\" class=\"btn btn-danger btn-sm\">\n");
      out.write("                                <i class=\"fas fa-trash\"></i> <!-- Ícone de exclusão -->\n");
      out.write("                            </a>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
 }
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("            <nav aria-label=\"Page navigation example\">\n");
      out.write("                <ul class=\"pagination justify-content-center\">\n");
      out.write("                    <li class=\"page-item ");
      out.print( (currentPage == 1) ? "disabled" : "");
      out.write("\">\n");
      out.write("                        <a class=\"page-link\" href=\"?page=");
      out.print( currentPage - 1);
      out.write("\">Anterior</a>\n");
      out.write("                    </li>\n");
      out.write("                    ");
 for (int i = 1; i <= totalPages; i++) {
      out.write("\n");
      out.write("                    <li class=\"page-item ");
      out.print( (i == currentPage) ? "active" : "");
      out.write("\">\n");
      out.write("                        <a class=\"page-link\" href=\"?page=");
      out.print( i);
      out.write('"');
      out.write('>');
      out.print( i);
      out.write("</a>\n");
      out.write("                    </li>\n");
      out.write("                    ");
 }
      out.write("\n");
      out.write("                    <li class=\"page-item ");
      out.print( (currentPage == totalPages || totalPages == 0) ? "disabled" : "");
      out.write("\">\n");
      out.write("                        <a class=\"page-link\" href=\"?page=");
      out.print( currentPage + 1);
      out.write("\">Próximo</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("        <!-- Adicione aqui os scripts necessários, como o Bootstrap e o Font Awesome -->\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("                             // Esconder alertas após 5 segundos\n");
      out.write("                             $(document).ready(function () {\n");
      out.write("                                 $(\".alert\").each(function (index, element) {\n");
      out.write("                                     var alert = $(element);\n");
      out.write("                                     setTimeout(function () {\n");
      out.write("                                         alert.alert('close');\n");
      out.write("                                     }, 5000);\n");
      out.write("                                 });\n");
      out.write("                             });\n");
      out.write("        </script>\n");
      out.write("  <script src=\"../includes/jquery.js\"></script>\n");
      out.write(" \n");
      out.write("        <script src=\"../includes/custom.js\"></script>\n");
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

  private boolean _jspx_meth_c_choose_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
    _jspx_th_c_choose_0.setParent(null);
    int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
    if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                ");
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                ");
        if (_jspx_meth_c_when_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\n");
        out.write("                ");
        if (_jspx_meth_c_when_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\n");
        out.write("            ");
        int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      return true;
    }
    _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
    return false;
  }

  private boolean _jspx_meth_c_when_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_0.setPageContext(_jspx_page_context);
    _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.message == 'deleteSuccess'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
    if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">\n");
        out.write("                        Turma excluída com sucesso!\n");
        out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\n");
        out.write("                            <span aria-hidden=\"true\">&times;</span>\n");
        out.write("                        </button>\n");
        out.write("                    </div>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
    return false;
  }

  private boolean _jspx_meth_c_when_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_1.setPageContext(_jspx_page_context);
    _jspx_th_c_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.message == 'updateSuccess'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_1 = _jspx_th_c_when_1.doStartTag();
    if (_jspx_eval_c_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <div class=\"alert alert-info alert-dismissible fade show\" role=\"alert\">\n");
        out.write("                        Turma actualizada com sucesso!\n");
        out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\n");
        out.write("                            <span aria-hidden=\"true\">&times;</span>\n");
        out.write("                        </button>\n");
        out.write("                    </div>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_when_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
    return false;
  }

  private boolean _jspx_meth_c_when_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_choose_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_2 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_when_2.setPageContext(_jspx_page_context);
    _jspx_th_c_when_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
    _jspx_th_c_when_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.message == 'addSuccess'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_when_2 = _jspx_th_c_when_2.doStartTag();
    if (_jspx_eval_c_when_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\">\n");
        out.write("                        Turma  cadastrada com sucesso.\n");
        out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\n");
        out.write("                            <span aria-hidden=\"true\">&times;</span>\n");
        out.write("                        </button>\n");
        out.write("                    </div>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_when_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_when_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_2);
      return true;
    }
    _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_2);
    return false;
  }
}
