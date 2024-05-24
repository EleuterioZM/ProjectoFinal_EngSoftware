package Controller;

import DAO.CursoDAO;
import DAO.TurmaDAO;
import Model.Curso;
import Model.Turma;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
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


}



