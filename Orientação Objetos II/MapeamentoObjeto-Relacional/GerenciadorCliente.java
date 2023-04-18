import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GerenciadorCliente {
    
    public BufferedReader leitor;
    DaoCliente daoCliente;

    public GerenciadorCliente(){
        leitor = new BufferedReader(new InputStreamReader(System.in));
        daoCliente = new DaoCliente();
    }

    public void menu() throws NumberFormatException, IOException{
        int opcao = 1;        
        while (opcao != 0) {
            System.out.println("-----===============================-----");
            System.out.println("-----== GERENCIAMENTO DE CLIENTES ==-----");
            System.out.println("[1] - Cadastrar.");
            System.out.println("[2] - Consultar.");
            System.out.println("[3] - Alterar.");
            System.out.println("[4] - Excluir.");
            System.out.println("[5] - Listar todos.");            
            System.out.println("[0] - Voltar ao menu anterior.");
            System.out.println("-----===============================-----");

            try {
                opcao = Integer.parseInt(leitor.readLine());
            } catch (Exception e) {
                System.out.println("Erro na leitura...informe um numero inteiro!" + e.getMessage());                                
            }

            switch (opcao) {
                case 1:
                    this.cadastrar();
                    break;
                case 2:
                    this.buscarUm();
                    break;
                case 3:
                    this.alterar();                 
                    break;
                case 4:
                    this.excluir();
                    break;
                case 5:
                    this.listarTodos();                    
                    break;
                case 0:
                    Locadora aux = new Locadora();
                    aux.menu();
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }
    }

    public void cadastrar() throws NumberFormatException, IOException{       
        System.out.println("-----== CADASTRAR CLIENTE ==-----");
        System.out.println("Nome:");
        String nome = leitor.readLine();
        System.out.println("Cpf:");
        String cpf = leitor.readLine();
        Cliente novoCliente = new Cliente(nome, cpf);
        System.out.println("Rua:");
        String rua = leitor.readLine();
        System.out.println("Bairro:");
        String bairro = leitor.readLine();
        System.out.println("Cep:");
        int cep = Integer.parseInt(leitor.readLine());
        System.out.println("Cidade:");
        String cidade = leitor.readLine();
        Endereco novoEndereco = new Endereco(rua, bairro, cep, cidade);
        novoCliente.setEnderecos(novoEndereco);
        int op = 1;
        do {
            System.out.println("Cadastrar outro endereço para o cliente " + nome.toUpperCase() + " ?");
            System.out.println("[1] SIM - [0] NÃO");
            op = Integer.parseInt(leitor.readLine());
            if (op == 1) {
                System.out.println("Rua:");
                String rua2 = leitor.readLine();
                System.out.println("Bairro:");
                String bairro2 = leitor.readLine();
                System.out.println("Cep:");
                int cep2 = Integer.parseInt(leitor.readLine());
                System.out.println("Cidade:");
                String cidade2 = leitor.readLine();
                Endereco endAdicional = new Endereco(rua2, bairro2, cep2, cidade2);  
                novoCliente.setEnderecos(endAdicional);
            }
        } while (op != 0);                      
        boolean inserido = daoCliente.inserir(novoCliente);
        if (inserido) {
            System.out.println("Cliente inserido com sucesso!");
        }

    }

    public void buscarUm() throws NumberFormatException, IOException{
        System.out.println("-----===============================-----");
        System.out.println("Buscar Cliente");
        System.out.println("Codigo: ");
        int codigo = Integer.parseInt(leitor.readLine());
        Cliente retorno = daoCliente.buscarUm(codigo);
        if (retorno != null) {
            System.out.println("CODIGO: " + retorno.getCodigo() 
                        + " NOME: " + retorno.getNome() +
                        " CPF: " + retorno.getCpf());
                        retorno.imprimeEnderecos();
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    public void listarTodos(){
        ArrayList<Cliente> clientes = daoCliente.buscarTodos();                     
        for (Cliente cliente : clientes) {
            System.out.println("CODIGO: " + cliente.getCodigo() 
                + " NOME: " + cliente.getNome() +
                " CPF: " + cliente.getCpf());
            }
    }

    public void excluir() throws NumberFormatException, IOException{
        System.out.println("-----===============================-----");
        System.out.println("Exclusão de cliente");
        System.out.println("Codigo: ");
        int codigo = Integer.parseInt(leitor.readLine());
        int quantidade = daoCliente.exlcluir(codigo);
        if (quantidade > 0) {
            System.out.println("Registro excluido com sucesso!");
        } else {
            System.out.println("Registro não encontrado...");
        }
    }

    public void alterar() throws IOException{
        System.out.println("-----===============================-----");
        System.out.println("Alterar Cliente");
        System.out.println("Codigo: ");
        int codigo = Integer.parseInt(leitor.readLine());
        Cliente cliente = daoCliente.buscarUm(codigo);
        if (cliente != null) {
            System.out.println("Dados do Cliente:");
            System.out.println("[Codigo: " + cliente.getCodigo() + "]");

            System.out.println("[Nome: " + cliente.getNome() + "]");
            String nome = leitor.readLine();
            if (!nome.isEmpty()) {
                cliente.setNome(nome);
            }

            System.out.println("[CPF: " + cliente.getCpf() + "]");
            String cpf = leitor.readLine();
            if (!cpf.isEmpty()) {
                cliente.setCpf(cpf);
            }

            ArrayList<Endereco> enderecoCliente = cliente.getEnderecos();
            System.out.println("O Cliente possui " + enderecoCliente.size() + " endereco(s) cadastrado(s)!");
            System.out.println("Deseja alterar os enderecos também?");
            System.out.println("[1] SIM - [2] NAO");
            Integer alteraEndereco = Integer.parseInt(leitor.readLine());
            if (alteraEndereco.intValue() == 1){
                for (Endereco endereco : enderecoCliente) {
                    System.out.println("Rua: ");
                    String rua = leitor.readLine();
                    endereco.setRua(rua);
                    System.out.println("Bairro: ");
                    String bairro = leitor.readLine();
                    endereco.setBairro(bairro);
                    System.out.println("Cidade: ");
                    String cidade = leitor.readLine();                  
                    endereco.setCidade(cidade);
                    System.out.println("Cep: ");
                    int cep = Integer.parseInt(leitor.readLine());
                    endereco.setCep(cep);
                }
                cliente.attEnderecos(enderecoCliente);

            } else if (alteraEndereco.intValue() == 2){
                System.out.println("Enderecos do cliente não alterados!");
            } else {
                System.out.println("Opcao invalida. Enderecos não serao alterados!");
            }
                   
            
            int alterados = daoCliente.alterarUm(cliente);
            if (alterados > 0) {
                System.out.println("Cliente alterado com sucesso!");
            }
                

        }else{
            System.out.println("Cliente não encontrado!");
        }

        

    }


}
