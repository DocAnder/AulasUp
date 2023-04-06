import java.util.Scanner;

public class GerenciadorVeiculo {
    
    Scanner scanner;
    DaoVeiculo daoVeiculo;

    public GerenciadorVeiculo(){
        daoVeiculo = new DaoVeiculo();
        scanner = new Scanner(System.in);
    }

    public void menu(){
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
                System.out.println("Erro na leitura...informe um numero numero inteiro!" + e.getMessage());                                
            }

            switch (opcao) {
                case 1:
                    this.cadastrar();
                    break;
                case 2:
                    //gerenciar clientes
                case 3:
                    System.out.println("Sistema encerrado!");                    
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 0:
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

}
