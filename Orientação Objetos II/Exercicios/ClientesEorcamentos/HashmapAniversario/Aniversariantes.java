import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Aniversariantes {
    
    public HashMap<String, ArrayList<String>> aniversarios = new HashMap<String, ArrayList<String>>();
    public BufferedReader leitor;


    public static void main(String[] args) {
        Aniversariantes aux = new Aniversariantes();
                
        try {
            aux.menu();
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }


    public void menu() throws NumberFormatException, IOException{
        this.leitor = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("================================================");
        System.out.println("================== Bem-Vindo(a) ================");        
        System.out.println("Selecione uma opção abaixo: ");
        System.out.println("1 - Cadastrar Aniversariante");
        System.out.println("2 - Listar datas de aniversário");
        System.out.println("3 - Listar aniversariantes de uma data");
        System.out.println("4 - Sair do sistema");
        int opcao = 0;
        opcao = Integer.parseInt(this.leitor.readLine());
        switch(opcao){
            case 1:
            System.out.println("---== Cadastrar Aniversariante ==---");
            System.out.println("Informe a data de nascimento [dia/mes]: ");
            String data = this.leitor.readLine();
            System.out.println("Informe o nome: ");
            String nome = this.leitor.readLine();
            cadastrarAniversariante(data, nome);
            menu();
            case 2:
            System.out.println("---== Listar Aniversários==---");
            listarDatas();
            menu();
            case 3:
            System.out.println("Informe a data que deseja consultar: ");
            String aux = this.leitor.readLine();
            consultarData(aux);
            menu();
            case 4:
            System.out.println("Sistema encerrado!");
            System.exit(0);
        }


    }


    public void cadastrarAniversariante(String data, String nome){
        if (!this.aniversarios.containsKey(data)) {
            this.aniversarios.put(data, new ArrayList<String>());
            this.aniversarios.get(data).add(nome);
        }else{
            this.aniversarios.get(data).add(nome);
        }
    }

    public void listarDatas(){
        System.out.println("Datas de aniversário");
        for (String item : this.aniversarios.keySet()) {
            System.out.println(item);
        }
    }

    public void consultarData(String data){
        if (this.aniversarios.containsKey(data)) {
            System.out.println("Aniversariantes do dia " + data);
            ArrayList<String> nomes = this.aniversarios.get(data);
            for (String nome : nomes) {
                System.out.println(nome);
            }            
        }else{
            System.out.println("Não existem aniversariantes nesta data!");
        }
    }

}
