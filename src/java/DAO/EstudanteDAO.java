package DAO;

import Model.Estudante;
import Model.Turma;
import Util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

public class EstudanteDAO {
    private Session sessao;
    private Transaction transacao;

    public void salvar(Estudante estudante) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(estudante);
            transacao.commit();
        } catch (Exception e) {
            if (transacao != null) {
                transacao.rollback();
            }
            e.printStackTrace();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    public void atualizar(Estudante estudante) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.update(estudante);
            transacao.commit();
        } catch (Exception e) {
            if (transacao != null) {
                transacao.rollback();
            }
            e.printStackTrace();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    public void excluir(Estudante estudante) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.delete(estudante);
            transacao.commit();
        } catch (Exception e) {
            if (transacao != null) {
                transacao.rollback();
            }
            e.printStackTrace();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }

 public Estudante buscarPorMatricula(Integer nrMatricula) {
    Estudante estudante = null;
    try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        Query query = sessao.createQuery("FROM Estudante e LEFT JOIN FETCH e.turma WHERE e.nrMatricula = :nrMatricula");
        query.setParameter("nrMatricula", nrMatricula);
        estudante = (Estudante) query.uniqueResult();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (sessao != null) {
            sessao.close();
        }
    }
    return estudante;
}
public List<Estudante> listarEstudantes() {
    List<Estudante> listaEstudantes = new ArrayList<>();
    try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        Query query = sessao.createQuery("SELECT e FROM Estudante e LEFT JOIN FETCH e.turma t LEFT JOIN FETCH t.curso");
        listaEstudantes = query.list();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (sessao != null) {
            sessao.close();
        }
    }
    return listaEstudantes;
}

    
    public List<Estudante> listarEstudantese() {
        List<Estudante> listaEstudantes = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Query query = (Query) sessao.createQuery("FROM Estudante");
            listaEstudantes = (List<Estudante>) query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
        return listaEstudantes;
    }
    public List<Estudante> buscarPorNomee(String nome) {
    List<Estudante> estudantes = new ArrayList<>();
    try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        Query query = sessao.createQuery("FROM Estudante WHERE nome LIKE :nome");
        query.setParameter("nome", "%" + nome + "%");
        estudantes = (List<Estudante>) query.list();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (sessao != null) {
            sessao.close();
        }
    }
    return estudantes;
}
    
    public List<Estudante> buscarPorNome(String nome) {
    List<Estudante> estudantes = new ArrayList<>();
    Session session = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Estudante e LEFT JOIN FETCH e.turma t LEFT JOIN FETCH t.curso c WHERE e.nome LIKE :nome");
        query.setParameter("nome", "%" + nome + "%");
        estudantes = query.list();
    } catch (HibernateException e) {
        e.printStackTrace();
    } finally {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
    return estudantes;
}

    
    public List<Turma> listarTurmas() {
        TurmaDAO turmaDAO = new TurmaDAO();
        return turmaDAO.listarTurmas();
    }
public List<Estudante> listarEstudantesComTurma() {
    List<Estudante> listaEstudantes = new ArrayList<>();
    Session session = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Estudante e LEFT JOIN FETCH e.turma");
        listaEstudantes = (List<Estudante>) query.list();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
    return listaEstudantes;
}

        public static List<Estudante> listarTodos() {
            List<Estudante> listaEstudantes = new ArrayList<>();
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                Query query = session.createQuery("SELECT e FROM Estudante e LEFT JOIN FETCH e.turma t LEFT JOIN FETCH t.curso");
                listaEstudantes = query.list();
            } catch (HibernateException e) {
                e.printStackTrace();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return listaEstudantes;
        }

    
    
}
