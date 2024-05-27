package Controller;

import DAO.EstudanteDAO;
import DAO.TurmaDAO;
import Model.Estudante;
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
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EstudanteServlet", urlPatterns = {"/EstudanteServlet"})
public class EstudanteServlet extends HttpServlet {

    private EstudanteDAO estudanteDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        estudanteDAO = new EstudanteDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "add":
                    addEstudante(request, response);
                    break;
                case "edit":
                    editEstudante(request, response);
                    break;
                case "delete":
                    deleteEstudante(request, response);
                    break;
                case "search":
                    searchEstudante(request, response);
                    break;
                case "view":
                    visualizarEstudante(request, response);
                    break;
                case "update":
                    updateEstudante(request, response);
                    break;
                    case "report":
                generateReport(request, response);
                break;
                default:
                    listEstudantes(request, response);
                    break;
            }
        } else {
            listEstudantes(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void addEstudante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String apelido = request.getParameter("apelido");
        String endereco = request.getParameter("endereco");
        String contacto = request.getParameter("contacto");
        String idTurmaStr = request.getParameter("idTurma");

        Estudante estudante = new Estudante();
        estudante.setNome(nome);
        estudante.setApelido(apelido);
        estudante.setEndereco(endereco);
        estudante.setContacto(contacto);

        TurmaDAO turmaDAO = new TurmaDAO();
        Turma turma = turmaDAO.buscarPorId(Integer.parseInt(idTurmaStr));
        estudante.setTurma(turma);

        try {
            estudanteDAO.salvar(estudante);
            response.sendRedirect(request.getContextPath() + "/Estudante/FRMListarEstudantes.jsp?message=addSuccess");
            return;
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Erro ao cadastrar estudante: " + e.getMessage());
            request.getRequestDispatcher("/Estudante/FRMListarEstudantes.jsp?").forward(request, response);
        }
    }

    private void editEstudante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nrMatriculaStr = request.getParameter("nrMatricula");
        if (nrMatriculaStr != null && !nrMatriculaStr.isEmpty()) {
            int nrMatricula = Integer.parseInt(nrMatriculaStr);
            Estudante estudante = estudanteDAO.buscarPorMatricula(nrMatricula);
            if (estudante != null) {
                Turma turma = estudante.getTurma();
                int idTurma = (turma != null) ? turma.getId() : -1;

                String url = "/Estudante/EditarEstudante.jsp?nrMatricula=" + estudante.getNrMatricula() +
                             "&nome=" + estudante.getNome() +
                             "&apelido=" + estudante.getApelido() +
                             "&endereco=" + estudante.getEndereco() +
                             "&contacto=" + estudante.getContacto() +
                             "&idTurma=" + idTurma;
                response.sendRedirect(request.getContextPath() + url);
            } else {
                response.sendRedirect(request.getContextPath() + "/EstudanteServlet?action=list");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/EstudanteServlet?action=list");
        }
    }

    private void deleteEstudante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nrMatriculaStr = request.getParameter("nrMatricula");
        if (nrMatriculaStr != null && !nrMatriculaStr.isEmpty()) {
            int nrMatricula = Integer.parseInt(nrMatriculaStr);
            Estudante estudante = estudanteDAO.buscarPorMatricula(nrMatricula);
            if (estudante != null) {
                try {
                    estudanteDAO.excluir(estudante);
                    request.setAttribute("message", "Estudante excluído com sucesso!");
                } catch (Exception e) {
                    request.setAttribute("message", "Erro ao excluir estudante: " + e.getMessage());
                }
            } else {
                request.setAttribute("message", "Estudante não encontrado.");
            }
        } else {
            request.setAttribute("message", "Número de matrícula inválido.");
        }
        response.sendRedirect(request.getContextPath() + "/Estudante/FRMListarEstudantes.jsp?message=deleteSuccess");
    }

    private void searchEstudante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nrMatriculaStr = request.getParameter("nrMatricula");
        if (nrMatriculaStr != null && !nrMatriculaStr.isEmpty()) {
            int nrMatricula = Integer.parseInt(nrMatriculaStr);
            Estudante estudante = estudanteDAO.buscarPorMatricula(nrMatricula);
            if (estudante != null) {
                request.setAttribute("estudante", estudante);
            } else {
                request.setAttribute("mensagem", "Nenhum estudante encontrado com o número de matrícula fornecido.");
            }
        }
        request.getRequestDispatcher("/EstudanteServlet").forward(request, response);
    }

    private void listEstudantes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Estudante> listaEstudantes = estudanteDAO.listarEstudantes();
        request.setAttribute("listaEstudantes", listaEstudantes);
        request.getRequestDispatcher("/Estudante/FRMListarEstudantes.jsp").forward(request, response);
    }

    private void searchEstudanteByName(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        if (nome != null && !nome.isEmpty()) {
            List<Estudante> estudantesEncontrados = estudanteDAO.buscarPorNome(nome);
            request.setAttribute("listaEstudantes", estudantesEncontrados);
            request.getRequestDispatcher("/ListarEstudantes.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/EstudanteServlet");
        }
    }

    private void visualizarEstudantee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nrMatriculaStr = request.getParameter("nrMatricula");
        if (nrMatriculaStr != null && !nrMatriculaStr.isEmpty()) {
            int nrMatricula = Integer.parseInt(nrMatriculaStr);
            Estudante estudante = estudanteDAO.buscarPorMatricula(nrMatricula);
            if (estudante != null) {
                Turma turma = estudante.getTurma();
                if (turma != null) {
                    String url = "/Estudante/FRMVisualizarEstudante.jsp?nrMatricula=" + estudante.getNrMatricula() +
                                 "&nome=" + estudante.getNome() +
                                 "&apelido=" + estudante.getApelido() +
                                 "&endereco=" + estudante.getEndereco() +
                                 "&contacto=" + estudante.getContacto() +
                                 "&nomeTurma=" + turma.getNome();
                    request.getRequestDispatcher(url).forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath() + "/EstudanteServlet?action=list&viewError=true");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/EstudanteServlet?action=list&viewError=true");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/EstudanteServlet?action=list&viewError=true");
        }
    }    
    private void updateEstudante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nrMatriculaStr = request.getParameter("nrMatricula");
        String nome = request.getParameter("nome");
        String apelido = request.getParameter("apelido");
        String endereco = request.getParameter("endereco");
        String contacto = request.getParameter("contacto");
        String idTurmaStr = request.getParameter("idTurma");

        if (nrMatriculaStr != null && !nrMatriculaStr.isEmpty() && idTurmaStr != null && !idTurmaStr.isEmpty()) {
            int nrMatricula = Integer.parseInt(nrMatriculaStr);
            int idTurma = Integer.parseInt(idTurmaStr);

            Estudante estudante = estudanteDAO.buscarPorMatricula(nrMatricula);
            if (estudante != null) {
                estudante.setNome(nome);
                estudante.setApelido(apelido);
                estudante.setEndereco(endereco);
                estudante.setContacto(contacto);

                TurmaDAO turmaDAO = new TurmaDAO();
                Turma turma = turmaDAO.buscarPorId(idTurma);
                if (turma != null) {
                    estudante.setTurma(turma);

                    try {
                        estudanteDAO.atualizar(estudante);
                        request.setAttribute("message", "Estudante atualizado com sucesso!");
                    } catch (Exception e) {
                        request.setAttribute("message", "Erro ao atualizar estudante: " + e.getMessage());
                    }
                } else {
                    request.setAttribute("message", "Turma não encontrada.");
                }
            } else {
                request.setAttribute("message", "Estudante não encontrado.");
            }
        } else {
            request.setAttribute("message", "Parâmetros de atualização incompletos.");
        }

        //listEstudantes(request, response);
 request.getRequestDispatcher("/Estudante/FRMListarEstudantes.jsp?message=updateSuccess").forward(request, response);
      
    }
 private void visualizarEstudante(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String nrMatriculaStr = request.getParameter("nrMatricula");
    
    if (nrMatriculaStr != null && !nrMatriculaStr.isEmpty()) {
        int nrMatricula = Integer.parseInt(nrMatriculaStr);
        Estudante estudante = estudanteDAO.buscarPorMatricula(nrMatricula);
        
        if (estudante != null) {
            // Garante que a turma associada ao estudante seja carregada
            Turma turma = estudante.getTurma();
            // Verifica se a turma foi carregada corretamente
            if (turma != null) {
                // Redireciona para a página de visualização com os parâmetros na URL
                String url = "/Estudante/FRMVisualizarEstudante.jsp?nrMatricula=" + estudante.getNrMatricula() +
                             "&nome=" + estudante.getNome() +
                             "&apelido=" + estudante.getApelido() +
                             "&endereco=" + estudante.getEndereco() +
                             "&contacto=" + estudante.getContacto() +
                             "&nomeTurma=" + turma.getNome(); // Obtém o nome da turma
                
                response.sendRedirect(request.getContextPath() + url);
            } else {
                // Se a turma não puder ser carregada, redireciona de volta para o servlet com um erro
                response.sendRedirect(request.getContextPath() + "/EstudanteServlet?action=list&viewError=true");
            }
        } else {
            // Se o estudante não for encontrado, redireciona de volta para o servlet com um erro
            response.sendRedirect(request.getContextPath() + "/EstudanteServlet?action=list&viewError=true");
        }
    } else {
        // Se o número de matrícula estiver ausente, redireciona de volta para o servlet com um erro
        response.sendRedirect(request.getContextPath() + "/EstudanteServlet?action=list&viewError=true");
    }
}
 private void generateReport(HttpServletRequest request, HttpServletResponse response) {
    Document document = new Document();

    try {
        // Diretório onde o PDF será temporariamente armazenado (pasta "temp" do servidor)
        String tempDir = System.getProperty("java.io.tmpdir");
        String filePath = tempDir + File.separator + "relatorio_estudantes.pdf";

        // Cria um novo arquivo PDF
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));

        // Abre o documento
        document.open();

        // Adiciona título ao documento
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
        Paragraph titulo = new Paragraph("Relatório de Estudantes", titleFont);
        titulo.setAlignment(Element.ALIGN_CENTER);
        titulo.setSpacingAfter(20);
        document.add(titulo);

        // Cria uma tabela com 5 colunas
        PdfPTable tabela = new PdfPTable(5);
        tabela.setWidthPercentage(100);
        tabela.setSpacingBefore(10f);
        tabela.setSpacingAfter(10f);

        // Define as larguras das colunas
        float[] columnWidths = {2f, 2f, 2f, 3f, 3f};
        tabela.setWidths(columnWidths);

        // Adiciona cabeçalhos à tabela
        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);
         BaseColor headerColor = new BaseColor(0, 102, 204);
        String[] headers = {"Nr Matrícula", "Nome", "Apelido", "Contato", "ID Turma"};
        for (String header : headers) {
            PdfPCell headerCell = new PdfPCell(new Paragraph(header, headerFont));
            headerCell.setBackgroundColor(headerColor); 
         
            headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            headerCell.setPadding(10);
            tabela.addCell(headerCell);
        }

        // Recupera os dados da base de dados
        List<Estudante> listaEstudantes = estudanteDAO.listarEstudantesComTurma();
        Font cellFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLACK);

        // Adiciona os dados à tabela
        for (Estudante estudante : listaEstudantes) {
            tabela.addCell(new PdfPCell(new Paragraph(estudante.getNrMatricula().toString(), cellFont)));
            tabela.addCell(new PdfPCell(new Paragraph(estudante.getNome(), cellFont)));
            tabela.addCell(new PdfPCell(new Paragraph(estudante.getApelido(), cellFont)));
            tabela.addCell(new PdfPCell(new Paragraph(estudante.getContacto(), cellFont)));
            tabela.addCell(new PdfPCell(new Paragraph(estudante.getTurma().getId().toString(), cellFont)));
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
        Paragraph linhaAssinatura = new Paragraph("__________________________________\nEleuterio Zacarias Mabecuane\n", signatureFont);
        linhaAssinatura.setAlignment(Element.ALIGN_CENTER);
        document.add(linhaAssinatura);

        // Fecha o documento
        document.close();

        // Informa ao navegador que o arquivo PDF será baixado
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=relatorio_estudantes.pdf");

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

private void generateReporte(HttpServletRequest request, HttpServletResponse response) {
    Document document = new Document();

    try {
        // Diretório onde o PDF será temporariamente armazenado (pasta "temp" do servidor)
        String tempDir = System.getProperty("java.io.tmpdir");
        String filePath = tempDir + File.separator + "relatorio_estudantes.pdf";

        // Cria um novo arquivo PDF
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));

        // Abre o documento
        document.open();

        // Adiciona título ao documento
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
        Paragraph titulo = new Paragraph("Relatório de Estudantes", titleFont);
        titulo.setAlignment(Element.ALIGN_CENTER);
        titulo.setSpacingAfter(20);
        document.add(titulo);

        // Cria uma tabela com 4 colunas
        PdfPTable tabela = new PdfPTable(4);
        tabela.setWidthPercentage(100);
        tabela.setSpacingBefore(10f);
        tabela.setSpacingAfter(10f);

        // Define as larguras das colunas
        float[] columnWidths = {2f, 2f, 3f, 3f};
        tabela.setWidths(columnWidths);

        // Adiciona cabeçalhos à tabela
        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);
        String[] headers = {"Nr Matrícula", "Nome", "Apelido", "Contato"};
        for (String header : headers) {
            PdfPCell headerCell = new PdfPCell(new Paragraph(header, headerFont));
            headerCell.setBackgroundColor(BaseColor.DARK_GRAY);
            headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            headerCell.setPadding(10);
            tabela.addCell(headerCell);
        }

        // Recupera os dados da base de dados
        List<Estudante> listaEstudantes = estudanteDAO.listarEstudantesComTurma();
        Font cellFont = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLACK);

        // Adiciona os dados à tabela
        for (Estudante estudante : listaEstudantes) {
            tabela.addCell(new PdfPCell(new Paragraph(estudante.getNrMatricula().toString(), cellFont)));
            tabela.addCell(new PdfPCell(new Paragraph(estudante.getNome(), cellFont)));
            tabela.addCell(new PdfPCell(new Paragraph(estudante.getApelido(), cellFont)));
            tabela.addCell(new PdfPCell(new Paragraph(estudante.getContacto(), cellFont)));
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
        Paragraph linhaAssinatura = new Paragraph("__________________________________\nEleuterio Zacarias Mabecuane\n", signatureFont);
        linhaAssinatura.setAlignment(Element.ALIGN_CENTER);
        document.add(linhaAssinatura);

        // Fecha o documento
        document.close();

        // Informa ao navegador que o arquivo PDF será baixado
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=relatorio_estudantes.pdf");

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



  
