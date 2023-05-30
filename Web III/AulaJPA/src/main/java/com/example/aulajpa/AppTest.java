package com.example.aulajpa;

import com.example.aulajpa.connection.ConnectionFactory;
import com.example.aulajpa.domain.Veiculo;
import com.example.aulajpa.repository.VeiculoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.util.List;

public class AppTest {

    public static void main(String[] args) {

        VeiculoRepository veiculoRepository = new VeiculoRepository();

        Veiculo v1 = new Veiculo();
        v1.setCodigo(null);
        v1.setModelo("Fusca");
        v1.setFabricante("VW");
        v1.setAnoFabricacao(1989);
        v1.setAnoModelo(1989);
        v1.setValor(new BigDecimal("5000.00"));

        //veiculoRepository.create(v1);

        //Veiculo veiculo = veiculoRepository.findById(2L);
        //System.out.println(veiculo.getModelo() + " " + veiculo.getFabricante());

        //v1.setCodigo(1L);
        //v1.setModelo("Gol");
        //veiculoRepository.update(v1);

        List<Veiculo> veiculos = veiculoRepository.findAll();

        for (Veiculo veiculo :
                veiculos) {
            System.out.println(veiculo.getModelo() + " " + veiculo.getFabricante());
        }

    }

}
