package Controller;

import DAO.DisciplinaDAO;
import Model.Disciplina;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
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
}
