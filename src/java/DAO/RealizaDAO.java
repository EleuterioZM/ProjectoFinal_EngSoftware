package DAO;

import Model.Realiza;
import Model.RealizaId;
import Util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;

public class RealizaDAO {
    private Session sessao;
    private Transaction transacao;

    public void salvar(Realiza realiza) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(realiza);
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

    public void atualizar(Realiza realiza) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.update(realiza);
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

    public void excluir(RealizaId id) {
    try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        
        // Buscar a realização pelo ID composto
        Realiza realiza = (Realiza) sessao.get(Realiza.class, id);
        
        // Verificar se a realização existe antes de tentar excluí-la
        if (realiza != null) {
            sessao.delete(realiza);
            transacao.commit();
        } else {
            // Se a realização não foi encontrada, lançar uma exceção ou lidar com a situação de outra forma
            throw new RuntimeException("Realização não encontrada para excluir.");
        }
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


    public Realiza buscarPorId(RealizaId id) {
        Realiza realiza = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            realiza = (Realiza) sessao.get(Realiza.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
        return realiza;
    }
    
    public List<Realiza> listarRealizacoes() {
        List<Realiza> listaRealizacoes = new ArrayList<>();
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Query query = (Query) sessao.createQuery("FROM Realiza");
            listaRealizacoes = (List<Realiza>) query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
        return listaRealizacoes;
    }
}
