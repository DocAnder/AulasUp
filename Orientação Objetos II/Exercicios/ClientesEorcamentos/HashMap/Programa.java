import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Programa {
    
    public static BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
    public static HashMap<String, Aeroporto> aeroportos = new HashMap<String, Aeroporto>();
    
    

    public static void main(String[] args) {
        
        
        
        
        try {
            Programa.menu();
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    
    private static void menu() throws NumberFormatException, IOException {
        System.out.println("================================================");
        System.out.println("================== Bem-Vindo(a) ================");
        System.out.println("Selecione uma opção abaixo: ");
        System.out.println("1 - Cadastrar Aeroporto");
        System.out.println("2 - Listar Aeropostos Cadastrados");
        System.out.println("3 - Remover um Aeroporto cadastrado");
        System.out.println("4 - Consultar detalhes de um Aeroporto");
        System.out.println("5 - Sair do sistema");
        int opcao = 0;
        opcao = Integer.parseInt(leitor.readLine());
        switch (opcao) {
            case 1:
                Programa.cadastrarAeroporto();
                Programa.menu();
                break;
            case 2:
                Programa.listarAeroportos();
                Programa.menu();
                break;
            case 3:
                Programa.removerAeroporto();
                Programa.menu();
                break;
            case 4:
                Programa.consultarAeroporto();
                Programa.menu();
                break;
            case 5:
                System.exit(0);
                break;
            default:                
                break;
        }
        
    }

    public static void cadastrarAeroporto() throws NumberFormatException, IOException{
        System.out.println();
        System.out.println("CADASTRAR AEROPORTO.");
        System.out.println("Informe o nome: ");
        String nome = Programa.leitor.readLine();
        System.out.println("Informe a cidade: ");
        String cidade = Programa.leitor.readLine();
        System.out.println("Informe a altitude: ");
        String altitude = Programa.leitor.readLine();
        Aeroporto novo = new Aeroporto(nome, cidade, altitude);
        System.out.println("Qual CHAVE deseja vincular este aeroporto?");
        String chave = Programa.leitor.readLine();
        Programa.aeroportos.put(chave, novo);
    }

    public static void listarAeroportos() throws NumberFormatException, IOException{
        System.out.println();
        for (String chave : aeroportos.keySet()) {
            System.out.println(chave);
            
        }
    }

    public static void removerAeroporto() throws NumberFormatException, IOException{
        System.out.println("Informe a CHAVE do aeroporto que deseja remover: ");        
        String chave = Programa.leitor.readLine();
        if (existe(chave)) {
            aeroportos.remove(chave);
            System.out.println("Aeroporto " + chave + " removido com sucesso!");
        } else {
            System.out.println("Não existe um aeroporto com esta chave.");   
        }

    }

    public static void consultarAeroporto() throws NumberFormatException, IOException{
        System.out.println("Informe a chave do aeroporto que deseja visualizar: ");
        String chave = leitor.readLine();
        if (existe(chave)) {
            System.out.println(aeroportos.get(chave));            
        }else{
            System.out.println("Não existe um aeroporto com esta chave.");
        }
    }

    public static Boolean existe(String chave){
        if (aeroportos.containsKey(chave)) {
            return true;
        }
        return false;
    }



}
