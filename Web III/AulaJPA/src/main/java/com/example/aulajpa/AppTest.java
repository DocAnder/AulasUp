package com.example.aulajpa;

import com.example.aulajpa.domain.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class AppTest {

    public static void main(String[] args) {



        EntityManagerFactory entityManagerFactory;
        EntityManager entityManager;


        entityManagerFactory = Persistence.createEntityManagerFactory("ifpr_aula_jpa");
        entityManager = entityManagerFactory.createEntityManager();


        entityManager.getTransaction().begin();

        Veiculo v1 = new Veiculo();
        v1.setCodigo(null);
        v1.setModelo("Fusca");
        v1.setFabricante("VW");
        v1.setAnoFabricacao(1989);
        v1.setAnoModelo(1989);
        v1.setValor(new BigDecimal("5000.00"));

        entityManager.persist(v1);

        entityManager.getTransaction().commit();


        Veiculo v2 = entityManager.find(Veiculo.class, 1);
        System.out.println(v2.getModelo() + " " + v2.getFabricante());



    }

}
