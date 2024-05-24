package DAO;

import Model.Disciplina;
import Util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

public class DisciplinaDAO {
    private Session sessao;
    private Transaction transacao;

    public void salvar(Disciplina disciplina) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(disciplina);
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

    public void atualizar(Disciplina disciplina) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.update(disciplina);
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

    public void excluir(Disciplina disciplina) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.delete(disciplina);
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

    public Disciplina buscarPorId(int id) {
        Disciplina disciplina = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            disciplina = (Disciplina) sessao.get(Disciplina.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
        return disciplina;
    }
  public List<Disciplina> buscarPorNome(String nome) {
    List<Disciplina> disciplinas = new ArrayList<>();
    try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Disciplina WHERE nome = :nome";
        Query query = sessao.createQuery(hql);
        query.setParameter("nome", nome);
        disciplinas = query.list();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (sessao != null) {
            sessao.close();
        }
    }
    return disciplinas;
}

    
    public List<Disciplina> listarDisciplinas() {
        List<Disciplina> listaDisciplinas = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Query query = (Query) sessao.createQuery("FROM Disciplina");
            listaDisciplinas = (List<Disciplina>) query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
        return listaDisciplinas;
    }
}
