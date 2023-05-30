package com.example.aulajpa.connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionFactory {

    private static EntityManagerFactory entityManagerFactory;

    //Linka o arquivo de configuração do banco desejado ao hibernate, permitando ter varios arquivos p/ bancos diferentes
    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("ifpr_aula_jpa");
    }

    //EntityManager é o objeto gerenciardor entre o BD e os Objetos
    public static EntityManager getConnection(){
        return entityManagerFactory.createEntityManager();
    }


}
