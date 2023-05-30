package com.example.aulajpa.repository;

import com.example.aulajpa.connection.ConnectionFactory;
import com.example.aulajpa.domain.Veiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transaction;

import java.util.List;

public class VeiculoRepository {

    private EntityManager entityManager;
    private EntityTransaction transaction;

    public VeiculoRepository(){
        this.entityManager = ConnectionFactory.getConnection();
        this.transaction = this.entityManager.getTransaction();
    }

    public Veiculo create(Veiculo veiculo){
       transaction.begin();
       entityManager.persist(veiculo);
       transaction.commit();

       return veiculo;
    }

    public Veiculo findById(Long id){
        Veiculo veiculo = entityManager.find(Veiculo.class, id);
        return veiculo;
    }

    public Veiculo update(Veiculo veiculo){
        transaction.begin();

        //O MERDGE dispensa o COMMIT pois já atualiza o objeto no banco direto;
        //Merge transforma o veiculo em um objeto monitorado pela JPA
        veiculo = entityManager.merge(veiculo);

        transaction.commit();

        return veiculo;
    }

    public Veiculo remove(Veiculo veiculo){
        transaction.begin();

        veiculo = entityManager.find(Veiculo.class, veiculo.getCodigo());

        entityManager.remove(veiculo);

        transaction.commit();

        return veiculo;
    }

    public List<Veiculo> findAll(){

        //SELECT V FROM veiculos v -> Sintaxe do createQuery
        List<Veiculo> veiculos = entityManager.createNativeQuery("SELECT * FROM veiculos", Veiculo.class).getResultList();

        return veiculos;
    }


}
