import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorClientePJ {
    
    Scanner scanner;
    DaoClientePJ daoClentePJ;

    public GerenciadorClientePJ(){
        daoClentePJ = new DaoClientePJ();
        scanner = new Scanner(System.in);
    }

    public void menu() throws NumberFormatException, IOException{
        int opcao = 1;        
        while (opcao != 0) {
            System.out.println("-----===============================-----");
            System.out.println("-----== GERENCIAMENTO DE CLIENTES PJ ==-----");
            System.out.println("[1] - Cadastrar.");
            System.out.println("[2] - Consultar.");
            System.out.println("[3] - Alterar.");
            System.out.println("[4] - Excluir.");
            System.out.println("[5] - Listar todos.");            
            System.out.println("[0] - Voltar ao menu anterior.");
            System.out.println("-----===============================-----");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
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

    public void cadastrar(){
        ClientePJ aux = new ClientePJ();
        System.out.println("-----== CADASTRAR CLIENTE PJ ==-----");
        System.out.println("Nome:");
        aux.setNome(scanner.nextLine());
        System.out.println("Cnpj:");
        aux.setCnpj(scanner.nextLine());

        EnderecoPJ enderecoPJ = new EnderecoPJ();
        System.out.println("[Endereço]");
        System.out.println("Rua:");
        enderecoPJ.setRua(scanner.nextLine());
        System.out.println("Numero:");
        enderecoPJ.setNumero(Integer.parseInt(scanner.nextLine()));
        System.out.println("Bairro:");
        enderecoPJ.setBairro(scanner.nextLine());
        System.out.println("Cep:");
        enderecoPJ.setCep(scanner.nextLine());  

        aux.setEnderecoPJ(enderecoPJ);

        boolean inserido = daoClentePJ.inserir(aux);
        if (inserido) {
            System.out.println("Cliente PJ inserido com sucesso!");
        }

    }

    public void excluir(){
        System.out.println("-----===============================-----");
        System.out.println("Exclusão de Cliente PJ");
        System.out.println("Codigo: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        int quantidade = daoClentePJ.exlcluir(codigo);
        if (quantidade > 0) {
            System.out.println("Registro excluido com sucesso!");
        } else {
            System.out.println("Registro não encontrado...");
        }
    }

    public void buscarUm(){
        System.out.println("-----===============================-----");
        System.out.println("Buscar veículo");
        System.out.println("Codigo: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        Veiculo retorno = daoClentePJ.buscarUm(codigo);
        if (retorno != null) {
            System.out.println("Codigo: " + retorno.getCodigo() 
                        + " Marca: " + retorno.getMarca() +
                        " Modelo: " + retorno.getModelo() + 
                        " Chassi: " + retorno.getChassi() + 
                        " Ano: " + retorno.getAno());
        } else {
            System.out.println("Veiculo não encontrado!");
        }
    }

    public void listarTodos(){
        ArrayList<ClientePJ> clientes = daoClentePJ.buscarTodos();                     
        for (ClientePJ cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome() 
                + " CNPJ: " + cliente.getCnpj() +
                " Codigo: " + cliente.getCodigoCliente());

                System.out.println("[Endereço]");
                System.out.println(" Rua: " + cliente.getEnderecoPJ().getRua() +
                                   " Numero: " + cliente.getEnderecoPJ().getNumero() +
                                   " Bairro: " + cliente.getEnderecoPJ().getBairro() +
                                   " CEP: " + cliente.getEnderecoPJ().getCep());
            }
    }

    public void alterar(){
        System.out.println("-----===============================-----");
        System.out.println("Alterar veículo");
        System.out.println("Codigo: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        Veiculo veiculo = daoClentePJ.buscarUm(codigo);
        if (veiculo != null) {
            System.out.println("Dados do Veículos:");
            System.out.println("[Codigo: " + veiculo.getCodigo() + "]");

            System.out.println("[Marca: " + veiculo.getMarca() + "]");
            String marca = scanner.nextLine();
            if (!marca.isEmpty()) {
                veiculo.setMarca(marca);
            }

            System.out.println("[Modelo: " + veiculo.getModelo() + "]");
            String modelo = scanner.nextLine();
            if (!modelo.isEmpty()) {
                veiculo.setModelo(modelo);
            }

            System.out.println("[Chassi: " + veiculo.getChassi() + "]");
            String chassi = scanner.nextLine();
            if (!chassi.isEmpty()) {
                veiculo.setChassi(chassi);
            }

            System.out.println("[Ano: " + veiculo.getAno() + "]");
            String ano = scanner.nextLine();
            if (!ano.isEmpty()) {
                veiculo.setAno(Integer.parseInt(ano));
            }       
            
            int alterados = daoClentePJ.alterarUm(veiculo);
            if (alterados > 0) {
                System.out.println("Veiculo alterado com sucesso!");
            }
                

        }else{
            System.out.println("Veiculo não encontrado!");
        }

        

    }

}