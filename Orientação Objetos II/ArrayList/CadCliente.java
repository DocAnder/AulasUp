import java.util.ArrayList;
import java.util.Iterator;



public class CadCliente {
    
    public static void main(String[] args) {
        
        ArrayList <Cliente> lista = new ArrayList<Cliente>();

        Cliente c1 = new Cliente();
        c1.setNome("Jão!");
        c1.setCpf("123456789");
        c1.setEmail("tadoidao@gmail.com");

        lista.add(c1);

        Cliente c2 = new Cliente();
        c2.setNome("Pedrão!");
        c2.setCpf("6669995874");
        c2.setEmail("eobraia@gmail.com");

        lista.add(c2);

        Cliente c3 = new Cliente();
        c3.setNome("Marcão!");
        c3.setCpf("88549677");
        c3.setEmail("numvaida@gmail.com");

        lista.add(c3);

        //System.out.println(lista);

        System.out.println("Percorrendo a Lista");
        //Iteretor busca o ponteiro do primeiro elemento da lista.
        Iterator<Cliente> it = lista.iterator();
        while (it.hasNext()) {
            Cliente cli = it.next(); //Pega o primeiro objeto
            System.out.println("Cliente: " + cli.getNome() + " CPF: " + cli.getCpf());
        }

        for (Cliente cliente : lista) {
            System.out.println(cliente.getNome());
        }


        //remover um item da lista         
        Cliente cliRemover = new Cliente();
        cliRemover.setCpf("123456789");
        Iterator<Cliente> itRemover = lista.iterator();
        while (itRemover.hasNext()) {
            if(itRemover.next().getCpf().equals(cliRemover.getCpf())){
                System.out.println("Removendo Cliente...");
                itRemover.remove();
            }
        }
        

        for (Cliente cliente : lista) {
            if (cliente.getCpf().equals("6669995874")) {
                lista.remove(cliente);
            }
        }

        for (Cliente cliente : lista) {
            System.out.println(cliente.getNome());
        }
        




    
    }


}
