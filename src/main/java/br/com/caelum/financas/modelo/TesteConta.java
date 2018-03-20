package br.com.caelum.financas.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteConta {
    public static void main (String args[]){
        Conta conta = new Conta();
        conta.setTitular("Daniel");
        conta.setBanco("Itau");
        conta.setAgencia("123");
        conta.setNumero("32123");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
