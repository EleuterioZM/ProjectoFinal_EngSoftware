package Controller;

import DAO.CursoDAO;
import Model.Curso;
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

@WebServlet(name = "CursoServlet", urlPatterns = {"/CursoServlet"})
public class CursoServlet extends HttpServlet {

    private CursoDAO cursoDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        cursoDAO = new CursoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "add":
                    addCurso(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteCurso(request, response);
                    break;
                case "update":
                    updateCurso(request, response);
                    break;
                case "search":
                    searchCurso(request, response);
                    break;
                case "searchByName":
                    searchCursoByName(request, response);
                    break;
                    case "report":
    generateReport(request, response);
    break;

                default:
                    listCursos(request, response);
                    break;
            }
        } else {
            listCursos(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("delete")) {
            deleteCurso(request, response);
        } else {
            doGet(request, response);
        }
    }

    private void addCurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");

        Curso curso = new Curso();
        curso.setNome(nome);

        try {
            cursoDAO.salvar(curso);
            request.setAttribute("message", "Curso cadastrado com sucesso!");
        } catch (Exception e) {
            request.setAttribute("message", "Erro ao cadastrar curso: " + e.getMessage());
        }

        //  response.sendRedirect(request.getContextPath() + "/Curso/FRMListarCursos.jsp");
        response.sendRedirect(request.getContextPath() + "/Curso/FRMListarCursos.jsp?message=addSuccess");

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String nome = request.getParameter("nome");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            Curso curso = cursoDAO.buscarPorId(id);
            if (curso != null) {
                request.setAttribute("cursoNome", nome);
                // Corrigindo o caminho para o arquivo JSP
                String url = "/Curso/FRMEditCurso.jsp?id=" + curso.getId();
                // Alterado para o caminho correto
                request.getRequestDispatcher(url).forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/CursoServlet");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/CursoServlet");
        }
    }

    private void deleteCurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            Curso curso = cursoDAO.buscarPorId(id);
            if (curso != null) {
                try {
                    cursoDAO.excluir(curso);
                    request.setAttribute("message", "Curso excluído com sucesso!");
                } catch (Exception e) {
                    request.setAttribute("message", "Erro ao excluir curso: " + e.getMessage());
                }
            } else {
                request.setAttribute("message", "Curso não encontrado.");
            }
        } else {
            request.setAttribute("message", "ID de curso inválido.");
        }
        // response.sendRedirect(request.getContextPath() + "/Curso/FRMListarCursos.jsp");
        response.sendRedirect(request.getContextPath() + "/Curso/FRMListarCursos.jsp?message=deleteSuccess");

    }

    private void searchCurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            Curso curso = cursoDAO.buscarPorId(id);
            if (curso != null) {
                request.setAttribute("curso", curso);
            } else {
                request.setAttribute("message", "Nenhum curso encontrado com o ID fornecido.");
            }
        }
        request.getRequestDispatcher("/Estudantes/FRMListarCursos.jsp").forward(request, response);
    }

    private void searchCursoByName(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        if (nome != null && !nome.isEmpty()) {
            List<Curso> cursosEncontrados = cursoDAO.buscarPorNome(nome);
            if (!cursosEncontrados.isEmpty()) {
                request.setAttribute("listaCursos", cursosEncontrados);
            } else {
                request.setAttribute("message", "Nenhum curso encontrado com o nome fornecido.");
            }
        } else {
            request.setAttribute("message", "Por favor, insira um nome para buscar.");
        }
        request.getRequestDispatcher("/Estudantes/FRMListarCursos.jsp").forward(request, response);
    }

    private void listCursos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Curso> listaCursos = cursoDAO.listarCursos();
        request.setAttribute("listaCursos", listaCursos);
        request.getRequestDispatcher("/Estudantes/FRMListarCursos.jsp").forward(request, response);
    }

    private void updateCurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String nome = request.getParameter("nome");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            Curso curso = cursoDAO.buscarPorId(id);
            if (curso != null) {
                // Atualiza o nome do curso
                curso.setNome(nome);
                try {
                    cursoDAO.atualizar(curso);
                    request.setAttribute("message", "Curso atualizado com sucesso!");
                } catch (Exception e) {
                    request.setAttribute("message", "Erro ao atualizar curso: " + e.getMessage());
                }
            } else {
                request.setAttribute("message", "Curso não encontrado.");
            }
        } else {
            request.setAttribute("message", "ID de curso inválido.");
        }
        // Redireciona de volta para a página de listagem de cursos
        request.getRequestDispatcher("/Curso/FRMListarCursos.jsp?message=updateSuccess").forward(request, response);
    }
private void generateReport(HttpServletRequest request, HttpServletResponse response) {
    Document document = new Document();

    try {
        // Diretório onde o PDF será temporariamente armazenado (pasta "temp" do servidor)
        String tempDir = System.getProperty("java.io.tmpdir");
        String filePath = tempDir + File.separator + "relatorio_cursos.pdf";

        // Cria um novo arquivo PDF
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));

        // Abre o documento
        document.open();

        // Adiciona título ao documento
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
        Paragraph titulo = new Paragraph("Relatório de Cursos", titleFont);
        titulo.setAlignment(Element.ALIGN_CENTER);
        titulo.setSpacingAfter(20);
        document.add(titulo);

        // Cria uma tabela com 2 colunas
        PdfPTable tabela = new PdfPTable(2);
        tabela.setWidthPercentage(100);
        tabela.setSpacingBefore(10f);
        tabela.setSpacingAfter(10f);

        // Define as larguras das colunas
        float[] columnWidths = {1f, 3f};
        tabela.setWidths(columnWidths);

        // Adiciona cabeçalhos à tabela
        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);
        BaseColor headerColor = new BaseColor(0, 102, 204);
        String[] headers = {"ID", "Nome do Curso"};
        for (String header : headers) {
            PdfPCell headerCell = new PdfPCell(new Paragraph(header, headerFont));
            headerCell.setBackgroundColor(headerColor);
            headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            headerCell.setPadding(10);
            tabela.addCell(headerCell);
        }

        // Recupera os dados da base de dados
        CursoDAO cursoDAO = new CursoDAO();
        List<Curso> listaCursos = cursoDAO.listarCursos();
        Font cellFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLACK);

        // Adiciona os dados à tabela
        for (Curso curso : listaCursos) {
            tabela.addCell(new PdfPCell(new Paragraph(curso.getId().toString(), cellFont)));
            tabela.addCell(new PdfPCell(new Paragraph(curso.getNome(), cellFont)));
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
        response.setHeader("Content-Disposition", "attachment; filename=relatorio_cursos.pdf");

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
