import java.util.ArrayList;

public class Teste {
    
    public static void main(String[] args) {
        
        /*
        Cliente c1 = new Cliente();

        Endereco e1 = new Endereco("Romario Vidal", "Vila Yolanda", 85853220, "Foz do Iguaçu");
        Endereco e2 = new Endereco("Rua Academia", "Universitário", 89895444, "Cascavel");

        c1.setEnderecos(e1);
        c1.setEnderecos(e2);


        c1.getEnderecos();
        */

        Cliente cliente = new Cliente("Anderson", "44699564582"); 

        Endereco aux = new Endereco("Academia", "Universitário", 85853000, "Cascavel");
        cliente.setEnderecos(aux);

        Endereco aux2 = new Endereco("Romario Vidal", "Vila Yolanda", 85853220, "Foz do Iguacu");
        cliente.setEnderecos(aux2);
        ArrayList <Endereco> enderecos = cliente.getEnderecos();
        


        cliente.imprimeEnderecos();
        System.out.println(enderecos.size());
        System.out.println(enderecos.get(1).getRua());
        System.out.println(enderecos.get(0).getRua());
        System.out.println(enderecos.get(3).getRua());
       

        


//        String comando = "INSERT INTO tb_clientes VALUES(NULL,"
//        + "'" + cliente.getNome() + "'," + "'" + cliente.getCpf() + "');";

//        System.out.println(comando);

    }

}
