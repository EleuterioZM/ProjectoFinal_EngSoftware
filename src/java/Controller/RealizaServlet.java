package Controller;

import DAO.RealizaDAO;
import Model.Realiza;
import Model.RealizaId;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RealizaServlet", urlPatterns = {"/RealizaServlet"})
public class RealizaServlet extends HttpServlet {

    private RealizaDAO realizaDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        realizaDAO = new RealizaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "add":
                    addRealiza(request, response);
                    break;
                case "edit":
                    editRealiza(request, response);
                    break;
                case "delete":
                    deleteRealiza(request, response);
                    break;
                case "search":
                    searchRealiza(request, response);
                    break;
                       case "update":
                updateRealiza(request, response);
                break;
                       case "visualizar":
                         visualizarRealiza(request, response);
                           break;
                           case "generateReport":
    generateReport(request, response);
    break;

                default:
                    listRealizas(request, response);
                    break;
            }
        } else {
            listRealizas(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
private void addRealiza(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Extrair os parâmetros da solicitação
    int idEstudante = Integer.parseInt(request.getParameter("idEstudante"));
    int idAvaliacao = Integer.parseInt(request.getParameter("idAvaliacao"));
    BigDecimal nota = new BigDecimal(request.getParameter("nota"));

    // Criar um objeto Realiza com os parâmetros
    Realiza realiza = new Realiza();
    realiza.setId(new RealizaId(idEstudante, idAvaliacao));
    realiza.setNota(nota);

    // Chama o método salvar do RealizaDAO para adicionar a realização ao banco de dados
    try {
        realizaDAO.salvar(realiza);
        request.setAttribute("message", "Realização cadastrada com sucesso!");
    } catch (Exception e) {
        request.setAttribute("message", "Erro ao cadastrar realização: " + e.getMessage());
    }
  request.getRequestDispatcher("/NotaRealiza/FRMListarRealizas.jsp?message=addSuccess").forward(request, response);
           
}

private void editRealiza(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Extrair os parâmetros da solicitação
    int idEstudante = Integer.parseInt(request.getParameter("idEstudante"));
    int idAvaliacao = Integer.parseInt(request.getParameter("idAvaliacao"));
    BigDecimal nota = new BigDecimal(request.getParameter("nota"));

    // Criar um objeto Realiza com os parâmetros
    Realiza realiza = new Realiza();
    realiza.setId(new RealizaId(idEstudante, idAvaliacao));
    realiza.setNota(nota);

    // Encaminha para a página de edição da realização com os parâmetros
    //request.setAttribute("realiza", realiza);
    request.getRequestDispatcher("/NotaRealiza/FRMEditRealizas.jsp").forward(request, response);
}

private void updateRealiza(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Extrair os parâmetros da solicitação
    int idEstudante = Integer.parseInt(request.getParameter("idEstudante"));
    int idAvaliacao = Integer.parseInt(request.getParameter("idAvaliacao"));
    BigDecimal nota = new BigDecimal(request.getParameter("nota"));

    // Criar um objeto Realiza com os parâmetros
    Realiza realiza = new Realiza();
    realiza.setId(new RealizaId(idEstudante, idAvaliacao));
    realiza.setNota(nota);

    // Chama o método atualizar do RealizaDAO para editar a realização no banco de dados
    try {
        realizaDAO.atualizar(realiza);
        request.setAttribute("message", "Realização atualizada com sucesso!");
    } catch (Exception e) {
        request.setAttribute("message", "Erro ao atualizar realização: " + e.getMessage());
    }

    // Encaminha para a página apropriada após a atualização
    request.getRequestDispatcher("/NotaRealiza/FRMListarRealizas.jsp?message=updateSuccess").forward(request, response);
}

 private void deleteRealiza(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idEstudanteStr = request.getParameter("idEstudante");
        String idAvaliacaoStr = request.getParameter("idAvaliacao");

        if (idEstudanteStr != null && !idEstudanteStr.trim().isEmpty() &&
            idAvaliacaoStr != null && !idAvaliacaoStr.trim().isEmpty()) {
            try {
                int idEstudante = Integer.parseInt(idEstudanteStr);
                int idAvaliacao = Integer.parseInt(idAvaliacaoStr);

                RealizaId id = new RealizaId(idEstudante, idAvaliacao);

                try {
                    realizaDAO.excluir(id);
                    response.sendRedirect(request.getContextPath() + "/NotaRealiza/FRMListarRealizas.jsp?message=deleteSuccess");
                } catch (Exception e) {
                    response.sendRedirect(request.getContextPath() + "/NotaRealiza/FRMListarRealizas.jsp?message=deleteError");
                }
            } catch (NumberFormatException e) {
                response.sendRedirect(request.getContextPath() + "/NotaRealiza/FRMListarRealizas.jsp?message=invalidId");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/NotaRealiza/FRMListarRealizas.jsp?message=missingId");
        }
    }

 
private void searchRealiza(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Extrair os parâmetros da solicitação
    int idEstudante = Integer.parseInt(request.getParameter("idEstudante"));
    int idAvaliacao = Integer.parseInt(request.getParameter("idAvaliacao"));

    // Criar um objeto RealizaId com os parâmetros
    RealizaId id = new RealizaId(idEstudante, idAvaliacao);

    // Chama o método buscarPorId do RealizaDAO para buscar a realização no banco de dados
    Realiza realiza = realizaDAO.buscarPorId(id);

    // Define o atributo "realiza" no request com a realização encontrada
    request.setAttribute("realiza", realiza);

    // Encaminha para a página de visualização da realização
    request.getRequestDispatcher("/Realiza/FRMVisualizarRealiza.jsp").forward(request, response);
}

private void listRealizas(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Obtém a lista de todas as realizações do banco de dados
    List<Realiza> listaRealizas = realizaDAO.listarRealizacoes();

    // Define o atributo "listaRealizas" no request com a lista de realizações
    request.setAttribute("listaRealizas", listaRealizas);

    // Encaminha para a página de listagem de realizações
    request.getRequestDispatcher("/Realiza/FRMListarRealizas.jsp").forward(request, response);
}
private void visualizarRealiza(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Extrair os parâmetros da solicitação
    int idEstudante = Integer.parseInt(request.getParameter("idEstudante"));
    int idAvaliacao = Integer.parseInt(request.getParameter("idAvaliacao"));

    // Criar um objeto RealizaId com os parâmetros
    RealizaId id = new RealizaId(idEstudante, idAvaliacao);

    // Chama o método buscarPorId do RealizaDAO para buscar a realização no banco de dados
    Realiza realiza = realizaDAO.buscarPorId(id);

    // Verifica se a realização foi encontrada
    if (realiza != null) {
        // Crie uma string de URL para redirecionar para a página de visualização
        String url = "/NotaRealiza/FRMVisualizarRealiza.jsp?idEstudante=" + idEstudante +
                     "&idAvaliacao=" + idAvaliacao +
                     "&nota=" + realiza.getNota();

        // Redirecione para a URL construída
        response.sendRedirect(request.getContextPath() + url);
    } else {
        // Se a realização não for encontrada, redirecione de volta para o servlet com um erro
        response.sendRedirect(request.getContextPath() + "/RealizaServlet?action=list&viewError=true");
    }
}
private void generateReporte(HttpServletRequest request, HttpServletResponse response) {
    Document document = new Document();

    try {
        // Diretório onde o PDF será temporariamente armazenado (pasta "temp" do servidor)
        String tempDir = System.getProperty("java.io.tmpdir");
        String filePath = tempDir + File.separator + "relatorio_realizacoes.pdf";

        // Cria um novo arquivo PDF
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));

        // Abre o documento
        document.open();

        // Adiciona título ao documento
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
        Paragraph titulo = new Paragraph("Relatório de Realizações", titleFont);
        titulo.setAlignment(Element.ALIGN_CENTER);
        titulo.setSpacingAfter(20);
        document.add(titulo);

        // Cria uma tabela com 4 colunas
        PdfPTable tabela = new PdfPTable(4);
        tabela.setWidthPercentage(100);
        tabela.setSpacingBefore(10f);
        tabela.setSpacingAfter(10f);

        // Define as larguras das colunas
        float[] columnWidths = {2f, 2f, 2f, 2f};
        tabela.setWidths(columnWidths);

        // Adiciona cabeçalhos à tabela
        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);
        String[] headers = {"ID Avaliação", "ID Estudante", "Nota"};
        for (String header : headers) {
            PdfPCell headerCell = new PdfPCell(new Paragraph(header, headerFont));
            headerCell.setBackgroundColor(BaseColor.DARK_GRAY);
            headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            headerCell.setPadding(10);
            tabela.addCell(headerCell);
        }

        // Recupera os dados da base de dados
        List<Realiza> listaRealizacoes = realizaDAO.listarRealizacoes(); // Certifique-se de ter o DAO de Realiza acessível aqui
        Font cellFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLACK);

        // Adiciona os dados à tabela
        for (Realiza realizacao : listaRealizacoes) {
            PdfPCell idAvaliacaoCell = new PdfPCell(new Paragraph(Integer.toString(realizacao.getId().getIdAvaliacao()), cellFont));
            PdfPCell idEstudanteCell = new PdfPCell(new Paragraph(Integer.toString(realizacao.getId().getIdEstudante()), cellFont));
            PdfPCell notaCell = new PdfPCell(new Paragraph(realizacao.getNota().toString(), cellFont));

            tabela.addCell(idAvaliacaoCell);
            tabela.addCell(notaCell);
             tabela.addCell(idEstudanteCell);
           
        }

        // Adiciona a tabela ao documento
        document.add(tabela);

        // Adiciona assinatura ao documento
        Font signatureFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);
        Paragraph assinadoPor = new Paragraph("Assinado por", signatureFont);
        assinadoPor.setAlignment(Element.ALIGN_CENTER);
        assinadoPor.setSpacingBefore(20);
        document.add(assinadoPor);

        // Adiciona uma linha para assinatura
        Paragraph linhaAssinatura = new Paragraph("__________________________________\nNome do Assinante\n", signatureFont);
        linhaAssinatura.setAlignment(Element.ALIGN_CENTER);
        document.add(linhaAssinatura);

        // Fecha o documento
        document.close();

        // Informa ao navegador que o arquivo PDF será baixado
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=relatorio_realizacoes.pdf");

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
    }
}

private void generateReport(HttpServletRequest request, HttpServletResponse response) {
    Document document = new Document();

    try {
        // Diretório onde o PDF será temporariamente armazenado (pasta "temp" do servidor)
        String tempDir = System.getProperty("java.io.tmpdir");
        String filePath = tempDir + File.separator + "relatorio_realizacoes.pdf";

        // Cria um novo arquivo PDF
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));

        // Abre o documento
        document.open();

        // Adiciona título ao documento
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
        Paragraph titulo = new Paragraph("Relatório de Realizações", titleFont);
        titulo.setAlignment(Element.ALIGN_CENTER);
        titulo.setSpacingAfter(20);
        document.add(titulo);

        // Cria uma tabela com 3 colunas
        PdfPTable tabela = new PdfPTable(3);
        tabela.setWidthPercentage(100);
        tabela.setSpacingBefore(10f);
        tabela.setSpacingAfter(10f);

        // Define as larguras das colunas
        float[] columnWidths = {2f, 2f, 2f};
        tabela.setWidths(columnWidths);

        // Adiciona cabeçalhos à tabela
        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);
        BaseColor headerColor = new BaseColor(0, 102, 204);
        String[] headers = {"ID Avaliação", "ID Estudante", "Nota"};
        for (String header : headers) {
            PdfPCell headerCell = new PdfPCell(new Paragraph(header, headerFont));
           headerCell.setBackgroundColor(headerColor);
            headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            headerCell.setPadding(10);
            tabela.addCell(headerCell);
        }

        // Recupera os dados da base de dados
        List<Realiza> listaRealizacoes = realizaDAO.listarRealizacoes(); // Certifique-se de ter o DAO de Realiza acessível aqui
        Font cellFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLACK);

        // Adiciona os dados à tabela
        for (Realiza realizacao : listaRealizacoes) {
            PdfPCell idAvaliacaoCell = new PdfPCell(new Paragraph(Integer.toString(realizacao.getId().getIdAvaliacao()), cellFont));
            PdfPCell idEstudanteCell = new PdfPCell(new Paragraph(Integer.toString(realizacao.getId().getIdEstudante()), cellFont));
            PdfPCell notaCell = new PdfPCell(new Paragraph(realizacao.getNota().toString(), cellFont));

            tabela.addCell(idAvaliacaoCell);
            tabela.addCell(idEstudanteCell);
            tabela.addCell(notaCell);
        }

        // Adiciona a tabela ao documento
        document.add(tabela);

        // Adiciona assinatura ao documento
        Font signatureFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.BLACK);
        Paragraph assinadoPor = new Paragraph("Assinado por", signatureFont);
        assinadoPor.setAlignment(Element.ALIGN_CENTER);
        assinadoPor.setSpacingBefore(20);
        document.add(assinadoPor);

        // Adiciona uma linha para assinatura
        Paragraph linhaAssinatura = new Paragraph("__________________________________\n", signatureFont);
        linhaAssinatura.setAlignment(Element.ALIGN_CENTER);
        document.add(linhaAssinatura);

        // Fecha o documento
        document.close();

        // Informa ao navegador que o arquivo PDF será baixado
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=relatorio_realizacoes.pdf");

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
    }
}

}
