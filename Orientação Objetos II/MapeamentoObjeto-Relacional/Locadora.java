import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Locadora {
    
    public static void main(String[] args) {
        Locadora locadora = new Locadora();
        locadora.menu();
    }

    public void menu(){
        int opcao = 1;
        BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
        while (opcao != 0) {
            System.out.println("-----====================-----");
            System.out.println("-----== MENU PRINCIPAL ==-----");
            System.out.println("[1] - Gerenciar Veículos.");
            System.out.println("[2] - Gerenciar Clientes.");
            System.out.println("[0] - Sair");
            System.out.println("-----====================-----");

            try {
                opcao = Integer.parseInt(leitor.readLine());
            } catch (Exception e) {
                System.out.println("Erro na leitura...informe um numero numero inteiro!" + e.getMessage());                                
            }

            switch (opcao) {
                case 1:
                    GerenciadorVeiculo aux = new GerenciadorVeiculo();
                    aux.menu();
                    break;
                case 2:
                    //gerenciar clientes
                case 3:
                    System.out.println("Sistema encerrado!");                    
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }
    }
}
