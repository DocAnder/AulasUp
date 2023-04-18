import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorVeiculo {
    
    Scanner scanner;
    DaoVeiculo daoVeiculo;

    public GerenciadorVeiculo(){
        daoVeiculo = new DaoVeiculo();
        scanner = new Scanner(System.in);
    }

    public void menu() throws NumberFormatException, IOException{
        int opcao = 1;        
        while (opcao != 0) {
            System.out.println("-----===============================-----");
            System.out.println("-----== GERENCIAMENTO DE VEICULOS ==-----");
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
        Veiculo aux = new Veiculo();
        System.out.println("-----== CADASTRAR VEICULO ==-----");
        System.out.println("Marca:");
        aux.setMarca(scanner.nextLine());
        System.out.println("Modelo:");
        aux.setModelo(scanner.nextLine());
        System.out.println("Chassi:");
        aux.setChassi(scanner.nextLine());
        System.out.println("Ano:");
        aux.setAno(Integer.parseInt(scanner.nextLine()));              
        boolean inserido = daoVeiculo.inserir(aux);
        if (inserido) {
            System.out.println("Veiculo inserido com sucesso!");
        }

    }

    public void excluir(){
        System.out.println("-----===============================-----");
        System.out.println("Exclusão de veículo");
        System.out.println("Codigo: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        int quantidade = daoVeiculo.exlcluir(codigo);
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
        Veiculo retorno = daoVeiculo.buscarUm(codigo);
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
        ArrayList<Veiculo> veiculos = daoVeiculo.buscarTodos();                     
        for (Veiculo veiculo : veiculos) {
            System.out.println("Codigo: " + veiculo.getCodigo() 
                + " Marca: " + veiculo.getMarca() +
                " Modelo: " + veiculo.getModelo() + 
                " Chassi: " + veiculo.getChassi() + 
                " Ano: " + veiculo.getAno());
            }
    }

    public void alterar(){
        System.out.println("-----===============================-----");
        System.out.println("Alterar veículo");
        System.out.println("Codigo: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        Veiculo veiculo = daoVeiculo.buscarUm(codigo);
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
            
            int alterados = daoVeiculo.alterarUm(veiculo);
            if (alterados > 0) {
                System.out.println("Veiculo alterado com sucesso!");
            }
                

        }else{
            System.out.println("Veiculo não encontrado!");
        }

        

    }

}