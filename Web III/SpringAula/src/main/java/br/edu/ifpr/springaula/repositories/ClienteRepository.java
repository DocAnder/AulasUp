package br.edu.ifpr.springaula.repositories;

import br.edu.ifpr.springaula.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> { }
