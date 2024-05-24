package Controller;

import DAO.EstudanteDAO;
import DAO.TurmaDAO;
import Model.Estudante;
import Model.Turma;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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


}


  
