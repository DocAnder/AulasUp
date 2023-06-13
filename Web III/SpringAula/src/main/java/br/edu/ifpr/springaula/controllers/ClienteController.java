package br.edu.ifpr.springaula.controllers;

import br.edu.ifpr.springaula.models.Cliente;
import br.edu.ifpr.springaula.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {


    //Anotation que gerencia a criação de objetos do tipo ClienteRepository
    @Autowired
    ClienteRepository clienteRepository;



    //Anotation produces JSON é opicional pois por padrao já entrega json
    @GetMapping(produces = "application/json")
    public List<Cliente> findAll(){

        Cliente c1 = new Cliente("Pedrao", "pedrao@gmail.com", "4599999-0000");
        Cliente c2 = new Cliente("Vilma", "vilma@gmail.com", "458888-1111");

        clienteRepository.save(c1);
        clienteRepository.save(c2);

        return clienteRepository.findAll();
    }


}
