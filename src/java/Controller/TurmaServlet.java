package Controller;

import DAO.CursoDAO;
import DAO.TurmaDAO;
import Model.Curso;
import Model.Turma;
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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TurmaServlet", urlPatterns = {"/TurmaServlet"})
public class TurmaServlet extends HttpServlet {

    private TurmaDAO turmaDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        turmaDAO = new TurmaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "add":
                    addTurma(request, response);
                    break;
                case "edit":
                    editTurma(request, response);
                    break;
                case "delete":
                    deleteTurma(request, response);
                    break;
                case "search":
                    searchTurma(request, response);
                    break;
                case "update":
                    updateTurma(request, response);
                    break;
                case "report":
                    generateTurmaReport(request, response);
                    break;

                default:
                    listTurmas(request, response);
                    break;
            }
        } else {
            listTurmas(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void addTurma(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String idCursoParam = request.getParameter("idCurso");

        // Verifica se o parâmetro "idCurso" não é nulo e não está vazio
        if (idCursoParam != null && !idCursoParam.isEmpty()) {
            int idCurso = Integer.parseInt(idCursoParam);

            // Criando uma instância de CursoDAO
            CursoDAO cursoDAO = new CursoDAO();

            // Verifica se o ID do Curso é válido
            if (idCurso <= 0) {
                request.setAttribute("message", "ID de curso inválido. Não foi possível cadastrar a turma.");
                response.sendRedirect(request.getContextPath() + "/TurmaServlet");
                return;
            }

            // Busca o Curso pelo ID
            Curso curso = cursoDAO.buscarPorId(idCurso);

            // Verifica se o Curso foi encontrado
            if (curso == null) {
                request.setAttribute("message", "Curso não encontrado. Não foi possível cadastrar a turma.");
                response.sendRedirect(request.getContextPath() + "/TurmaServlet");
                return;
            }

            // Cria uma nova instância de Turma
            Turma turma = new Turma();
            turma.setNome(nome);
            turma.setCurso(curso);

            // Tenta salvar a Turma
            try {
                turmaDAO.salvar(turma);
                request.setAttribute("message", "Turma cadastrada com sucesso!");
            } catch (Exception e) {
                request.setAttribute("message", "Erro ao cadastrar turma: " + e.getMessage());
            }

        } else {
            request.setAttribute("message", "ID de curso inválido. Não foi possível cadastrar a turma.");
        }
        request.getRequestDispatcher("/Turma/FRMListarTurmas.jsp?message=addSuccess").forward(request, response);

        //  response.sendRedirect(request.getContextPath() + "/TurmaServlet");
    }

    // Métodos restantes do servlet...
    private void editTurma(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            Turma turma = turmaDAO.buscarPorId(id);
            if (turma != null) {
                String url = "/Turma/FRMEditTurma.jsp?id=" + turma.getId() + "&nome=" + turma.getNome() + "&idCurso=" + turma.getCurso().getId();
                response.sendRedirect(request.getContextPath() + url);
            } else {
                response.sendRedirect(request.getContextPath() + "/TurmaServlet");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/TurmaServlet");
        }
    }

    private void deleteTurma(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            Turma turma = turmaDAO.buscarPorId(id);
            if (turma != null) {
                try {
                    turmaDAO.excluir(turma);
                    request.setAttribute("message", "Turma excluída com sucesso!");
                } catch (Exception e) {
                    request.setAttribute("message", "Erro ao excluir turma: " + e.getMessage());
                }
            } else {
                request.setAttribute("message", "Turma não encontrada.");
            }
        } else {
            request.setAttribute("message", "ID de turma inválido.");
        }
        //   response.sendRedirect(request.getContextPath() + "/TurmaServlet");
        response.sendRedirect(request.getContextPath() + "/Turma/FRMListarTurmas.jsp?message=deleteSuccess");

    }

    private void searchTurma(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            Turma turma = turmaDAO.buscarPorIdComCurso(id); // Altere o método para carregar o curso junto com a turma
            if (turma != null) {
                // Define a turma como atributo do request
                request.setAttribute("turma", turma);
                // Encaminha a solicitação para a página JSP que exibe os detalhes da turma
                request.getRequestDispatcher("/FRMDetalhesTurma.jsp").forward(request, response);
                return; // Importante retornar para evitar redirecionamento adicional
            } else {
                request.setAttribute("message", "Nenhuma turma encontrada com o ID fornecido.");
            }
        }
        // Se não encontrar a turma, encaminha de volta para a página de listagem
        listTurmas(request, response);
    }

    private void listTurmas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Turma> listaTurmas = turmaDAO.listarTurmas();

        // Obtém a lista de cursos
        CursoDAO cursoDAO = new CursoDAO();
        List<Curso> cursos = cursoDAO.listarCursos();

        // Define as listas como atributos do request
        request.setAttribute("listaTurmas", listaTurmas);
        request.setAttribute("cursos", cursos);

        // Encaminha a solicitação para a página JSP
        request.getRequestDispatcher("/Turma/FRMListarTurmas.jsp").forward(request, response);
    }

    private void searchTurmaById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            Turma turma = turmaDAO.buscarPorId(id);
            if (turma != null) {
                // Define a turma como atributo do request
                List<Turma> turmas = new ArrayList<>();
                turmas.add(turma);
                request.setAttribute("turmas", turmas);
                // Encaminha a solicitação para a mesma página
                listTurmas(request, response);
                return; // Importante retornar para evitar redirecionamento adicional
            } else {
                request.setAttribute("message", "Nenhuma turma encontrada com o ID fornecido.");
            }
        }
        // Se não encontrar a turma, encaminha de volta para a página de listagem
        listTurmas(request, response);
    }

    private void updateTurma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String nome = request.getParameter("nome");
        String idCursoStr = request.getParameter("idCurso");

        if (idStr != null && !idStr.isEmpty() && nome != null && !nome.isEmpty() && idCursoStr != null && !idCursoStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            int idCurso = Integer.parseInt(idCursoStr);

            // Verifica se o ID da turma é válido
            if (id <= 0) {
                request.setAttribute("message", "ID de turma inválido. Não foi possível atualizar a turma.");
                response.sendRedirect(request.getContextPath() + "/TurmaServlet");
                return;
            }

            // Verifica se o ID do curso é válido
            if (idCurso <= 0) {
                request.setAttribute("message", "ID de curso inválido. Não foi possível atualizar a turma.");
                response.sendRedirect(request.getContextPath() + "/TurmaServlet");
                return;
            }

            // Busca a turma pelo ID
            Turma turma = turmaDAO.buscarPorId(id);

            // Verifica se a turma foi encontrada
            if (turma == null) {
                request.setAttribute("message", "Turma não encontrada. Não foi possível atualizar a turma.");
                response.sendRedirect(request.getContextPath() + "/TurmaServlet");
                return;
            }

            // Atualiza os dados da turma
            turma.setNome(nome);

            // Busca o curso pelo ID
            CursoDAO cursoDAO = new CursoDAO();
            Curso curso = cursoDAO.buscarPorId(idCurso);

            // Verifica se o curso foi encontrado
            if (curso == null) {
                request.setAttribute("message", "Curso não encontrado. Não foi possível atualizar a turma.");
                response.sendRedirect(request.getContextPath() + "/TurmaServlet");
                return;
            }

            // Associa a turma ao curso
            turma.setCurso(curso);

            // Tenta atualizar a turma
            try {
                turmaDAO.atualizar(turma);
                request.setAttribute("message", "Turma atualizada com sucesso!");
            } catch (Exception e) {
                request.setAttribute("message", "Erro ao atualizar turma: " + e.getMessage());
            }
        } else {
            request.setAttribute("message", "Parâmetros inválidos. Não foi possível atualizar a turma.");
        }

        request.getRequestDispatcher("/Turma/FRMListarTurmas.jsp?message=updateSuccess").forward(request, response);

    }

   private void generateTurmaReport(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Document document = new Document();

    try {
        // Diretório onde o PDF será temporariamente armazenado (pasta "temp" do servidor)
        String tempDir = System.getProperty("java.io.tmpdir");
        String filePath = tempDir + File.separator + "relatorio_turmas.pdf";

        // Cria um novo arquivo PDF
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));

        // Abre o documento
        document.open();

        // Adiciona título ao documento
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
        Paragraph titulo = new Paragraph("Relatório de Turmas", titleFont);
        titulo.setAlignment(Element.ALIGN_CENTER);
        titulo.setSpacingAfter(20);
        document.add(titulo);

        // Cria uma tabela com 3 colunas
        PdfPTable tabela = new PdfPTable(3);
        tabela.setWidthPercentage(100);
        tabela.setSpacingBefore(10f);
        tabela.setSpacingAfter(10f);

        // Define as larguras das colunas
        float[] columnWidths = {1f, 2f, 2f};
        tabela.setWidths(columnWidths);

        // Adiciona cabeçalhos à tabela
        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);
        BaseColor headerColor = new BaseColor(0, 102, 204);
        String[] headers = {"ID", "Nome da Turma", "Curso"};
        for (String header : headers) {
            PdfPCell headerCell = new PdfPCell(new Paragraph(header, headerFont));
            headerCell.setBackgroundColor(headerColor);
            headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            headerCell.setPadding(10);
            tabela.addCell(headerCell);
        }

        // Recupera os dados da base de dados
        List<Turma> listaTurmas = turmaDAO.listarTurmas(); // Certifique-se de ter o DAO de Turma acessível aqui
        Font cellFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLACK);

        // Adiciona os dados à tabela
        for (Turma turma : listaTurmas) {
            PdfPCell idTurmaCell = new PdfPCell(new Paragraph(Integer.toString(turma.getId()), cellFont));
            PdfPCell nomeTurmaCell = new PdfPCell(new Paragraph(turma.getNome(), cellFont));
            PdfPCell nomeCursoCell = new PdfPCell(new Paragraph(turma.getCurso().getNome(), cellFont));

            tabela.addCell(idTurmaCell);
            tabela.addCell(nomeTurmaCell);
            tabela.addCell(nomeCursoCell);
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
        response.setHeader("Content-Disposition", "attachment; filename=relatorio_turmas.pdf");

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
        response.getWriter().println("Erro ao gerar o relatório de turmas: " + e.getMessage());
    }
}

}
