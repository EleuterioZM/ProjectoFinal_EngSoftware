package Controller;

import DAO.CursoDAO;
import Model.Curso;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
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

}
