package DAO;

import Model.Avaliacao;
import Util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

public class AvaliacaoDAO {
    private Session sessao;
    private Transaction transacao;

    public void salvar(Avaliacao avaliacao) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(avaliacao);
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

    public void atualizar(Avaliacao avaliacao) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.update(avaliacao);
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

   public void excluir(Avaliacao avaliacao) {
    try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        sessao.delete(avaliacao);
        transacao.commit();
        System.out.println("Avaliação excluída com sucesso!");
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


    public Avaliacao buscarPorId(int id) {
        Avaliacao avaliacao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            avaliacao = (Avaliacao) sessao.get(Avaliacao.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
        return avaliacao;
    }
    
    public List<Avaliacao> listarAvaliacoes() {
        List<Avaliacao> listaAvaliacoes = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Query query = (Query) sessao.createQuery("FROM Avaliacao");
            listaAvaliacoes = (List<Avaliacao>) query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
        return listaAvaliacoes;
    }
}
