package DAO;

import Model.Curso;
import Util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

public class CursoDAO {
    private Session sessao;
    private Transaction transacao;

    public void salvar(Curso curso) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(curso);
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

    public void atualizar(Curso curso) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.update(curso);
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

    public void excluir(Curso curso) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.delete(curso);
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

    public Curso buscarPorId(int id) {
        Curso curso = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            curso = (Curso) sessao.get(Curso.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
        return curso;
    }
    
    public List<Curso> listarCursos() {
        List<Curso> listaCursos = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Query query = sessao.createQuery("FROM Curso");
            listaCursos = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
        return listaCursos;
    }

    public List<Curso> buscarPorNome(String nome) {
        List<Curso> listaCursos = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Query query = sessao.createQuery("FROM Curso WHERE nome LIKE :nome");
            query.setParameter("nome", "%" + nome + "%");
            listaCursos = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
        return listaCursos;
    }
}
