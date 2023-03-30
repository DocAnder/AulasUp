import java.util.ArrayList;
import java.util.HashMap;

public class Teste{


    public static HashMap<String, ArrayList<String>> aniversario = new HashMap<String, ArrayList<String>>();

    public static void main(String[] args) {
        


        String dia = "10/03";
        ArrayList<String> nome = new ArrayList<String>();
        nome.add("Pedro");
        aniversario.put(dia, nome);
        ArrayList<String> retornoChave = aniversario.get(dia);
        for (String pessoa : retornoChave) {
            System.out.println(pessoa);
        }

        dia = "15/02";
        ArrayList<String> nome2 = new ArrayList<String>();
        nome2.add("Charlinho");
        aniversario.put(dia, nome2);
        retornoChave = aniversario.get(dia);
        for (String pessoa : retornoChave) {
            System.out.println(pessoa);
        }

        dia = "10/03";        
        retornoChave = aniversario.get(dia);
        retornoChave.add("Charlinho 2");
        for (String pessoa : retornoChave) {
            System.out.println(pessoa);
        }






    }


}