package Controller;

import DAO.AvaliacaoDAO;
import Model.Avaliacao;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import javax.servlet.ServletOutputStream;
@WebServlet(name = "AvaliacaoServlet", urlPatterns = {"/AvaliacaoServlet"})
public class AvaliacaoServlet extends HttpServlet {

    private AvaliacaoDAO avaliacaoDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        avaliacaoDAO = new AvaliacaoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "add":
                    addAvaliacao(request, response);
                    break;
                case "edit":
                    editAvaliacao(request, response);
                    break;
                case "delete":
                    deleteAvaliacao(request, response);
                    break;
                case "search":
                    searchAvaliacao(request, response);
                    break;
              
                case "visualizar":
                    visualizarAvaliacao(request, response);
                    break;
                case "report":
                     Relatorio(request, response);
                        break;
                default:
                    listAvaliacoes(request, response);
                    break;
            }
        } else {
            listAvaliacoes(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("update".equals(action)) {
            atualizarAvaliacao(request, response);
        } else {
            doGet(request, response);
        }
    }

    private void addAvaliacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String descricao = request.getParameter("descricao");
        String pesoStr = request.getParameter("peso");
        BigDecimal peso = new BigDecimal(pesoStr);

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setDescricao(descricao);
        avaliacao.setPeso(peso);

        try {
            avaliacaoDAO.salvar(avaliacao);
            request.setAttribute("message", "Avaliação cadastrada com sucesso!");
        } catch (Exception e) {
            request.setAttribute("message", "Erro ao cadastrar avaliação: " + e.getMessage());
        }

       // response.sendRedirect(request.getContextPath() + "/AvaliacaoServlet");
           response.sendRedirect(request.getContextPath() + "/Avaliacao/FRMListarAvaliacoes.jsp?message=addSuccess");
    }

    private void editAvaliacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            Avaliacao avaliacao = avaliacaoDAO.buscarPorId(id);
            if (avaliacao != null) {
                // Redireciona para a página de edição com os parâmetros na URL
                String url = "/Avaliacao/FRMEditAvaliacao.jsp?id=" + avaliacao.getId() + "&descricao=" + avaliacao.getDescricao() + "&peso=" + avaliacao.getPeso();
                response.sendRedirect(request.getContextPath() + url);
            } else {
                response.sendRedirect(request.getContextPath() + "/AvaliacaoServlet");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/AvaliacaoServlet");
        }
    }

   private void deleteAvaliacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            Avaliacao avaliacao = avaliacaoDAO.buscarPorId(id);
            if (avaliacao != null) {
                try {
                    avaliacaoDAO.excluir(avaliacao);
                    request.setAttribute("message", "Avaliação excluída com sucesso!");
                } catch (Exception e) {
                    request.setAttribute("message", "Erro ao excluir avaliação: " + e.getMessage());
                }
            } else {
                request.setAttribute("message", "Avaliação não encontrada.");
            }
        } else {
            request.setAttribute("message", "ID de avaliação inválido.");
        }
        response.sendRedirect(request.getContextPath() + "/Avaliacao/FRMListarAvaliacoes.jsp?message=deleteSuccess");
    }


    private void searchAvaliacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            Avaliacao avaliacao = avaliacaoDAO.buscarPorId(id);
            if (avaliacao != null) {
                request.setAttribute("avaliacao", avaliacao);
            } else {
                request.setAttribute("mensagem", "Nenhuma avaliação encontrada com o ID fornecido.");
            }
        }
        request.getRequestDispatcher("/AvaliacaoServlet").forward(request, response);
    }

    private void listAvaliacoes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Avaliacao> listaAvaliacoes = avaliacaoDAO.listarAvaliacoes();
        request.setAttribute("listaAvaliacoes", listaAvaliacoes);
        request.getRequestDispatcher("/Avaliacao/FRMListarAvaliacoes.jsp").forward(request, response);
    }

    private void atualizarAvaliacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtendo os parâmetros da solicitação POST
        int id = Integer.parseInt(request.getParameter("id"));
        String descricao = request.getParameter("descricao");
        BigDecimal peso = new BigDecimal(request.getParameter("peso"));

        // Obtendo a avaliação correspondente do banco de dados
        Avaliacao avaliacao = avaliacaoDAO.buscarPorId(id);

        if (avaliacao != null) {
            // Atualizando os atributos da avaliação com os novos valores
            avaliacao.setDescricao(descricao);
            avaliacao.setPeso(peso);

            // Chamando o método atualizar do AvaliacaoDAO para persistir as alterações
            try {
                avaliacaoDAO.atualizar(avaliacao);
                request.setAttribute("message", "Avaliação atualizada com sucesso!");
            } catch (Exception e) {
                request.setAttribute("message", "Erro ao atualizar avaliação: " + e.getMessage());
            }
        } else {
            request.setAttribute("message", "Avaliação não encontrada.");
        }

        // Redirecionando de volta para a página de listagem de avaliações
      //  response.sendRedirect(request.getContextPath() + "/AvaliacaoServlet");
  response.sendRedirect(request.getContextPath() + "/Avaliacao/FRMListarAvaliacoes.jsp?message=updateSuccess");
   
    }

 private void visualizarAvaliacao(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String idStr = request.getParameter("id");
    if (idStr != null && !idStr.isEmpty()) {
        int id = Integer.parseInt(idStr);
        Avaliacao avaliacao = avaliacaoDAO.buscarPorId(id);
        if (avaliacao != null) {
            // Redireciona para a página de visualização com os parâmetros na URL
            String url = "/Avaliacao/ViewAvaliacao.jsp?id=" + avaliacao.getId() + "&descricao=" + avaliacao.getDescricao() + "&peso=" + avaliacao.getPeso();
            response.sendRedirect(request.getContextPath() + url);
        } else {
            request.setAttribute("mensagem", "Avaliação não encontrada.");
            request.getRequestDispatcher("/Avaliacao/FRMListarAvaliacoes.jsp").forward(request, response);
        }
    } else {
        request.setAttribute("mensagem", "ID de avaliação inválido.");
        request.getRequestDispatcher("/Avaliacao/FRMListarAvaliacoes.jsp").forward(request, response);
    }
}

   



private void Relatorio(HttpServletRequest request, HttpServletResponse response) {
    // Configuração do documento PDF
    Document documento = new Document();

    try {
        // Diretório onde o PDF será temporariamente armazenado (pasta "temp" do servidor)
        String tempDir = System.getProperty("java.io.tmpdir");
        String filePath = tempDir + File.separator + "relatorio.pdf";
        
        // Cria um novo arquivo PDF
        PdfWriter.getInstance(documento, new FileOutputStream(filePath));
        
        // Abre o documento
        documento.open();
        
        // Adiciona conteúdo ao documento
        documento.add(new Paragraph("Este é um exemplo de relatório em PDF gerado pelo iTextPDF."));
        
        // Fecha o documento
        documento.close();
        
        // Informa ao navegador que o arquivo PDF será baixado
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=relatorio.pdf");
        
        // Escreve o conteúdo do arquivo PDF no fluxo de saída da resposta
        ServletOutputStream out = response.getOutputStream();
        FileInputStream fis = new FileInputStream(new File(filePath));
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        
        // Fecha os fluxos de entrada e saída
        fis.close();
        out.flush();
        
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Fecha o documento
        documento.close();
    }
}


}