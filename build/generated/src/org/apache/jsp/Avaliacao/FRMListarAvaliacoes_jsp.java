package org.apache.jsp.Avaliacao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DAO.AvaliacaoDAO;
import Model.Avaliacao;
import java.util.List;

public final class FRMListarAvaliacoes_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Listagem de Avaliações</title>\n");
      out.write("    <!-- Adicione aqui os links para os arquivos CSS do Bootstrap -->\n");
      out.write("    <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <!-- Adicione aqui os links para os arquivos CSS de ícones, como Font Awesome -->\n");
      out.write("    <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\" rel=\"stylesheet\">\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            background-color: #ff9966; /* Cor de fundo */\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("  \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    \n");
      out.write("      <div class=\"container mt-4\">\n");
      out.write("    ");
      out.write("\n");
      out.write("    ");
      if (_jspx_meth_c_choose_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("</div>\n");
      out.write("<div class=\"container\">\n");
      out.write("    <h1 class=\"mt-4\" style=\"color:white\">Listagem de Avaliações</h1>\n");
      out.write("  \n");
      out.write("    <div class=\"text-right mb-4\">\n");
      out.write("        \n");
      out.write("      <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Avaliacao/FRMCadastroAvaliacao.jsp\" class=\"btn btn-success\">Adicionar Curso</a>\n");
      out.write("    </div>\n");
      out.write("    <table class=\"table table-striped mt-4 table-dark\">\n");
      out.write("        <thead>\n");
      out.write("        <tr>\n");
      out.write("            <th scope=\"col\">#</th>\n");
      out.write("            <th scope=\"col\">Descrição</th>\n");
      out.write("            <th scope=\"col\">Peso</th>\n");
      out.write("            <th scope=\"col\">Ações</th>\n");
      out.write("        </tr>\n");
      out.write("        </thead>\n");
      out.write("        <tbody>\n");
      out.write("        ");

            int pageSizeAvaliacao = 6;
            int currentPageAvaliacao = (request.getParameter("pageAvaliacao") != null) ? Integer.parseInt(request.getParameter("pageAvaliacao")) : 1;
            AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
            List<Avaliacao> listaAvaliacoes = avaliacaoDAO.listarAvaliacoes();
            int totalAvaliacoes = listaAvaliacoes.size();
            int totalPagesAvaliacao = (int) Math.ceil((double) totalAvaliacoes / pageSizeAvaliacao);
            int startIndexAvaliacao = (currentPageAvaliacao - 1) * pageSizeAvaliacao;
            int endIndexAvaliacao = Math.min(startIndexAvaliacao + pageSizeAvaliacao, totalAvaliacoes);
            int countAvaliacao = startIndexAvaliacao;
            for (Avaliacao avaliacao : listaAvaliacoes.subList(startIndexAvaliacao, endIndexAvaliacao)) {
                countAvaliacao++;
        
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print( countAvaliacao );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( avaliacao.getDescricao() );
      out.write("</td>\n");
      out.write("            <td>");
      out.print( avaliacao.getPeso() );
      out.write("</td>\n");
      out.write("            <td>\n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/AvaliacaoServlet?action=visualizar&id=");
      out.print( avaliacao.getId());
      out.write("\" class=\"btn btn-success btn-sm\">\n");
      out.write("    <i class=\"fas fa-eye\"></i>\n");
      out.write("</a>\n");
      out.write("\n");
      out.write("              <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/AvaliacaoServlet?action=edit&id=");
      out.print( avaliacao.getId() );
      out.write("\" class=\"btn btn-primary btn-sm\">\n");
      out.write("                    <i class=\"fas fa-edit\"></i>\n");
      out.write("                </a> \n");
      out.write("                \n");
      out.write("                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/Avaliacao/FRMExclusaoAvaliacao.jsp?id=");
      out.print( avaliacao.getId());
      out.write("&nome=");
      out.print( avaliacao.getDescricao());
      out.write("\" class=\"btn btn-danger btn-sm\">\n");
      out.write("        <i class=\"fas fa-trash\"></i> <!-- Ícone de exclusão -->\n");
      out.write("    </a> </td>\n");
      out.write("        </tr>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("    <nav aria-label=\"Page navigation example\">\n");
      out.write("        <ul class=\"pagination justify-content-center\">\n");
      out.write("            <li class=\"page-item ");
      out.print( (currentPageAvaliacao == 1) ? "disabled" : "");
      out.write("\">\n");
      out.write("                <a class=\"page-link\" href=\"?pageAvaliacao=");
      out.print( currentPageAvaliacao - 1);
      out.write("\">Anterior</a>\n");
      out.write("            </li>\n");
      out.write("            ");
 for (int i = 1; i <= totalPagesAvaliacao; i++) {
      out.write("\n");
      out.write("            <li class=\"page-item ");
      out.print( (i == currentPageAvaliacao) ? "active" : "");
      out.write("\">\n");
      out.write("                <a class=\"page-link\" href=\"?pageAvaliacao=");
      out.print( i);
      out.write('"');
      out.write('>');
      out.print( i);
      out.write("</a>\n");
      out.write("            </li>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("            <li class=\"page-item ");
      out.print( (currentPageAvaliacao == totalPagesAvaliacao || totalPagesAvaliacao == 0) ? "disabled" : "");
      out.write("\">\n");
      out.write("                <a class=\"page-link\" href=\"?pageAvaliacao=");
      out.print( currentPageAvaliacao + 1);
      out.write("\">Próximo</a>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("    </nav>\n");
      out.write("</div>\n");
      out.write("<!-- Adicione aqui os scripts necessários, como o Bootstrap e o Font Awesome -->\n");
      out.write("   <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("    // Esconder alertas após 5 segundos\n");
      out.write("    $(document).ready(function(){\n");
      out.write("        $(\".alert\").each(function(index, element) {\n");
      out.write("            var alert = $(element);\n");
      out.write("            setTimeout(function() {\n");
      out.write("                alert.alert('close');\n");
      out.write("            }, 5000);\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write(" </body>\n");
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
        out.write("        ");
        if (_jspx_meth_c_when_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("        ");
        if (_jspx_meth_c_when_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("      \n");
        out.write("        ");
        if (_jspx_meth_c_when_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_choose_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("        \n");
        out.write("    ");
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
        out.write("            <div class=\"alert alert-danger alert-dismissible fade show\" role=\"alert\">\n");
        out.write("                Avaliacao excluída com sucesso!\n");
        out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\n");
        out.write("                    <span aria-hidden=\"true\">&times;</span>\n");
        out.write("                </button>\n");
        out.write("            </div>\n");
        out.write("        ");
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
        out.write("            <div class=\"alert alert-info alert-dismissible fade show\" role=\"alert\">\n");
        out.write("              Avaliacao actualizada com sucesso!\n");
        out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\n");
        out.write("                    <span aria-hidden=\"true\">&times;</span>\n");
        out.write("                </button>\n");
        out.write("            </div>\n");
        out.write("        ");
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
        out.write("            <div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\">\n");
        out.write("                Avaliacao  cadastrada com sucesso.\n");
        out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\n");
        out.write("                    <span aria-hidden=\"true\">&times;</span>\n");
        out.write("                </button>\n");
        out.write("            </div>\n");
        out.write("        ");
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