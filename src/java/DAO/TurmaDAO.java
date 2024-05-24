package DAO;

import Model.Turma;
import Util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;

public class TurmaDAO {
    private Session sessao;
    private Transaction transacao;

    public void salvar(Turma turma) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(turma);
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

    public void atualizar(Turma turma) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.update(turma);
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

    public void excluir(Turma turma) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.delete(turma);
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

    public Turma buscarPorId(Integer id) {
        Turma turma = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            turma = (Turma) sessao.get(Turma.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
        return turma;
    }
    
    public List<Turma> listarTurmas() {
        List<Turma> listaTurmas = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Query query = (Query) sessao.createQuery("FROM Turma");
            listaTurmas = (List<Turma>) query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
        return listaTurmas;
    }
     public List<Turma> listarTurmasComEstudantes() {
        List<Turma> listaTurmas = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Query query = (Query) sessao.createQuery("FROM Turma t LEFT JOIN FETCH t.estudantes"); // Carrega os estudantes junto com as turmas
            listaTurmas = (List<Turma>) query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
        return listaTurmas;
    }
      public List<Turma> listarTurmasComCurso() {
    List<Turma> listaTurmas = new ArrayList<>();
    try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        Query query = sessao.createQuery("FROM Turma t LEFT JOIN FETCH t.curso");
        listaTurmas = query.list();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (sessao != null) {
            sessao.close();
        }
    }
    return listaTurmas;
}

public Turma buscarPorIdComCurso(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    Turma turma = null;
    try {
        transaction = session.beginTransaction();
        turma = (Turma) session.get(Turma.class, id);
        // Carregando o curso junto com a turma
        Hibernate.initialize(turma.getCurso());
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    } finally {
        session.close();
    }
    return turma;
}

}
