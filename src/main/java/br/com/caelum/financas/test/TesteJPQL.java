package br.com.caelum.financas.test;

import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TesteJPQL {

    public static void main(String[] args) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        String jpql = "select m from Movimentacao m where m.conta.id = 1";
        Query query = em.createQuery(jpql);

        List<Movimentacao> resultados = query.getResultList();

        for(Movimentacao movimentacao : resultados){
            System.out.println("Descricao: " + movimentacao.getDescricao());
            System.out.println("Conta.id" + movimentacao.getId());
        }

        em.getTransaction().commit();
    }
}
