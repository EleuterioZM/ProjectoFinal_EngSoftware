package Controller;

import DAO.DisciplinaDAO;
import Model.Disciplina;
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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DisciplinaServlet", urlPatterns = {"/DisciplinaServlet"})
public class DisciplinaServlet extends HttpServlet {

    private DisciplinaDAO disciplinaDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        disciplinaDAO = new DisciplinaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "add":
                    addDisciplina(request, response);
                    break;
                case "edit":
                    editDisciplina(request, response);
                    break;
                case "delete":
                    deleteDisciplina(request, response);
                    break;
                case "search":
                    searchDisciplina(request, response);
                    break;
                case "visualizar":
                    visualizarDisciplina(request, response);
                    break;
                case "update":
                    updateDisciplina(request, response);
                    break;
                         case "report":
                generateDisciplinaReport(request, response);
                break;
                default:
                    listDisciplinas(request, response);
                    break;
            }
        } else {
            listDisciplinas(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void addDisciplina(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        Integer chs = Integer.parseInt(request.getParameter("chs"));
        Integer credito = Integer.parseInt(request.getParameter("credito"));

        Disciplina disciplina = new Disciplina();
        disciplina.setNome(nome);
        disciplina.setChs(chs);
        disciplina.setCredito(credito);

        try {
            disciplinaDAO.salvar(disciplina);
            request.setAttribute("message", "Disciplina cadastrada com sucesso!");
        } catch (Exception e) {
            request.setAttribute("message", "Erro ao cadastrar disciplina: " + e.getMessage());
        }

        response.sendRedirect(request.getContextPath() + "/Disciplina/FRMListarDisciplinas.jsp?message=addSuccess");
    }

    private void editDisciplina(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            Disciplina disciplina = disciplinaDAO.buscarPorId(id);
            if (disciplina != null) {
                String url = "/Disciplina/FRMEditDisciplina.jsp?id=" + disciplina.getId()
                        + "&nome=" + disciplina.getNome()
                        + "&chs=" + disciplina.getChs()
                        + "&credito=" + disciplina.getCredito();
                response.sendRedirect(request.getContextPath() + url);
            } else {
                response.sendRedirect(request.getContextPath() + "/DisciplinaServlet");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/DisciplinaServlet");
        }
    }

    private void deleteDisciplina(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            Disciplina disciplina = disciplinaDAO.buscarPorId(id);
            if (disciplina != null) {
                try {
                    disciplinaDAO.excluir(disciplina);
                    request.setAttribute("message", "Disciplina excluída com sucesso!");
                } catch (Exception e) {
                    request.setAttribute("message", "Erro ao excluir disciplina: " + e.getMessage());
                }
            } else {
                request.setAttribute("message", "Disciplina não encontrada.");
            }
        } else {
            request.setAttribute("message", "ID de disciplina inválido.");
        }
       // listDisciplinas(request, response);
           request.getRequestDispatcher("/Disciplina/FRMListarDisciplinas.jsp?message=deleteSuccess").forward(request, response);
    }

    private void searchDisciplina(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        if (nome != null && !nome.isEmpty()) {
            List<Disciplina> disciplinasEncontradas = disciplinaDAO.buscarPorNome(nome);
            if (!disciplinasEncontradas.isEmpty()) {
                request.setAttribute("listaDisciplinas", disciplinasEncontradas);
            } else {
                request.setAttribute("mensagem", "Nenhuma disciplina encontrada com o nome fornecido.");
            }
        } else {
            request.setAttribute("mensagem", "Por favor, insira um nome para buscar.");
        }
        request.getRequestDispatcher("/listarDisciplinas.jsp").forward(request, response);
    }

    private void listDisciplinas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Disciplina> listaDisciplinas = disciplinaDAO.listarDisciplinas();
        request.setAttribute("listaDisciplinas", listaDisciplinas);
        request.getRequestDispatcher("/listarDisciplinas.jsp").forward(request, response);
    }


private void visualizarDisciplina(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String nome = request.getParameter("nome");
    String chsStr = request.getParameter("chs");
    String creditoStr = request.getParameter("credito");

    if (nome != null && !nome.isEmpty() && chsStr != null && !chsStr.isEmpty() && creditoStr != null && !creditoStr.isEmpty()) {
        int chs = Integer.parseInt(chsStr);
        int credito = Integer.parseInt(creditoStr);

        // Cria uma String com a URL da página JSP de visualização da disciplina
        String url = "/Disciplina/FRMVisualizarDisciplina.jsp?nome=" + nome + "&chs=" + chs + "&credito=" + credito;

        // Redireciona o usuário para a URL construída
        response.sendRedirect(request.getContextPath() + url);
    } else {
        // Se algum dos parâmetros estiver faltando ou vazio, redireciona de volta com um erro
        response.sendRedirect(request.getContextPath() + "/DisciplinaServlet?action=list&viewError=true");
    }
}

    private void updateDisciplina(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String nome = request.getParameter("nome");
        String chsStr = request.getParameter("chs");
        String creditoStr = request.getParameter("credito");

        if (idStr != null && !idStr.isEmpty() && chsStr != null && !chsStr.isEmpty() && creditoStr != null && !creditoStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            int chs = Integer.parseInt(chsStr);
            int credito = Integer.parseInt(creditoStr);

            Disciplina disciplina = disciplinaDAO.buscarPorId(id);
            if (disciplina != null) {
                disciplina.setNome(nome);
                disciplina.setChs(chs);
                disciplina.setCredito(credito);

                try {
                    disciplinaDAO.atualizar(disciplina);
                    request.setAttribute("message", "Disciplina atualizada com sucesso!");
                } catch (Exception e) {
                    request.setAttribute("message", "Erro ao atualizar disciplina: " + e.getMessage());
                }
            } else {
                request.setAttribute("message", "Disciplina não encontrada.");
            }
        } else {
            request.setAttribute("message", "Parâmetros de atualização incompletos.");
        }
       // listDisciplinas(request, response);
           request.getRequestDispatcher("/Disciplina/FRMListarDisciplinas.jsp?message=updateSuccess").forward(request, response);
    }
    private void generateDisciplinaReport(HttpServletRequest request, HttpServletResponse response) {
    Document document = new Document();

    try {
        // Diretório onde o PDF será temporariamente armazenado (pasta "temp" do servidor)
        String tempDir = System.getProperty("java.io.tmpdir");
        String filePath = tempDir + File.separator + "relatorio_disciplinas.pdf";

        // Cria um novo arquivo PDF
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));

        // Abre o documento
        document.open();

        // Adiciona título ao documento
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
        Paragraph titulo = new Paragraph("Relatório de Disciplinas", titleFont);
        titulo.setAlignment(Element.ALIGN_CENTER);
        titulo.setSpacingAfter(20);
        document.add(titulo);

        // Cria uma tabela com 4 colunas
        PdfPTable tabela = new PdfPTable(4);
        tabela.setWidthPercentage(100);
        tabela.setSpacingBefore(10f);
        tabela.setSpacingAfter(10f);

        // Define as larguras das colunas
        float[] columnWidths = {1f, 3f, 1.5f, 1.5f}; // Ajuste dos tamanhos das colunas
        tabela.setWidths(columnWidths);

        // Adiciona cabeçalhos à tabela
        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);
        BaseColor headerColor = new BaseColor(0, 102, 204);
        String[] headers = {"ID", "Nome", "CHS", "Crédito"};
        for (String header : headers) {
            PdfPCell headerCell = new PdfPCell(new Paragraph(header, headerFont));
            headerCell.setBackgroundColor(headerColor);
            headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            headerCell.setPadding(5); // Reduzindo o padding
            tabela.addCell(headerCell);
        }

        // Recupera os dados da base de dados
        List<Disciplina> listaDisciplinas = disciplinaDAO.listarDisciplinas();
        Font cellFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLACK);

        // Adiciona os dados à tabela
        for (Disciplina disciplina : listaDisciplinas) {
            PdfPCell idCell = new PdfPCell(new Paragraph(String.valueOf(disciplina.getId()), cellFont));
            idCell.setPadding(5); // Reduzindo o padding
            idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabela.addCell(idCell);

            PdfPCell nomeCell = new PdfPCell(new Paragraph(disciplina.getNome(), cellFont));
            nomeCell.setPadding(5); // Reduzindo o padding
            tabela.addCell(nomeCell);

            PdfPCell chsCell = new PdfPCell(new Paragraph(String.valueOf(disciplina.getChs()), cellFont));
            chsCell.setPadding(5); // Reduzindo o padding
            chsCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabela.addCell(chsCell);

            PdfPCell creditoCell = new PdfPCell(new Paragraph(String.valueOf(disciplina.getCredito()), cellFont));
            creditoCell.setPadding(5); // Reduzindo o padding
            creditoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabela.addCell(creditoCell);
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
        response.setHeader("Content-Disposition", "attachment; filename=relatorio_disciplinas.pdf");

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
