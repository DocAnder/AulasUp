import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Sistema {
    
    private static BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<Cliente> listaClientes;

    public static void main(String[] args) {
        
        listaClientes = new ArrayList<Cliente>();

        
        try {
            Sistema.menu();
        } catch (NumberFormatException | IOException e) {
            System.out.println("Ocorreu um erro inesperado. Reinicie o sistema!");
            Utils.pausar(2); 
            System.exit(0);                  
        }


    }

    private static void menu() throws NumberFormatException, IOException{
        System.out.println("================================================");
        System.out.println("================== Bem-Vindo(a) ================");
        System.out.println("================ Auto Peças Tião ===============");
        System.out.println("Selecione uma opção abaixo: ");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Listar Clientes");
        System.out.println("3 - Cadastrar um novo orçamento");
        System.out.println("4 - Listar orçamentos de cliente");
        System.out.println("5 - Sair do sistema");
        int opcao = 0;
        opcao = Integer.parseInt(leitor.readLine());
        switch (opcao) {
            case 1:
                System.out.println("====== Cadastro de Cliente =====");
                Sistema.cadastrarCliente();
                break;
            case 2:
                if (listaClientes.size() == 0) {
                    System.out.println("Ainda não foram cadastrados clientes!");
                    Sistema.menu();
                } else {
                    System.out.println("====== Lista de Clientes =====");
                    Sistema.listarClientes();    
                }                                
                break;
            case 3:
                if (listaClientes.size() == 0) {
                    System.out.println("Necessário cadastar ao menos 1 cliente para atribuir orçamentos!");
                    Utils.pausar(2);
                    Sistema.menu();
                }else{ 
                    System.out.println("====== Cadastro de Orçamento =====");
                    Sistema.cadastrarOrcamento();
                }                
                break;
            case 4:
                if (listaClientes.size() == 0) {
                    System.out.println("Ainda não há no sistema nenhum cliente para verificar orçamentos!");
                    Sistema.menu();
                }else {
                    System.out.println("====== Lista de Orçamentos =====");
                    Sistema.listarOrcamentos();
                } 
                break;
            case 5:
                System.out.println("Sistema será encerrado.");
                System.out.println("Volte sempre!");
                Utils.pausar(2);
                System.exit(0);
            default:
                System.out.println("Opção invalida.");
                System.out.println("Selecione dentre as opções do menu.");
                Utils.pausar(2);
                Sistema.menu();
                break;
        }
        
    }

    public static void cadastrarCliente() throws NumberFormatException, IOException{
        System.out.println("Informe o nome:");
        String nome = leitor.readLine();
        System.out.println("Informe o cpf: ");
        String cpf = leitor.readLine();
        System.out.println("Informe o telefone: ");
        String telefone = leitor.readLine();
        Cliente novoCliente = new Cliente(nome, cpf, telefone);
        listaClientes.add(novoCliente);
        System.out.println("Cliente " + nome + " cadastrado com sucesso!");
        Utils.pausar(1);
        System.out.println();
        Sistema.menu();
    }

    public static void listarClientes() throws NumberFormatException, IOException{
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
            System.out.println();
        }
        Utils.pausar(2);
        Sistema.menu();
    }

    public static void cadastrarOrcamento() throws NumberFormatException, IOException{
        System.out.println("Qual o código do cliente que o orçamento será vinculado?");
        int resposta = Integer.parseInt(Sistema.leitor.readLine());
        if (buscaCliente(resposta)) {
           System.out.println("Cliente " + listaClientes.get(resposta - 1).getNome() + " selecionado."); 
           System.out.println("Informe o valor do orçamento: ");
           double valor = Double.parseDouble(Sistema.leitor.readLine());
           System.out.println("Informe quantos dias o orçamento tem validade: ");
           int validade = Integer.parseInt(Sistema.leitor.readLine());
           Orcamento novoOrcamento = new Orcamento(valor, validade);
           listaClientes.get(resposta - 1).setOrcamentos(novoOrcamento);
           System.out.println("Orçamento adicionado com sucesso ao cliente " + listaClientes.get(resposta - 1).getNome() + "!");
        }else{
            System.out.println("Não foi encontrado um cliente com o código informado.");
            Utils.pausar(1);
        }        
        Sistema.menu();
    }

    public static void listarOrcamentos(){

    }

    public static boolean buscaCliente(int codigo){
        for (Cliente cliente : listaClientes) {
            if (cliente.getCodigo() == codigo) {
                return true;
            }            
        }
        return false;
    }

}
