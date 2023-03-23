import java.util.HashMap;



public class Dias{

    public static void main(String[] args) {
        
        HashMap<String, String> diasSemana = new HashMap<String, String>();

        diasSemana.put("SEG", "Segunda-Feira");
        diasSemana.put("TER", "Terça-Feira");
        diasSemana.put("QUA", "Quarta-Feira");
        diasSemana.put("QUI", "Quinta-Feira");
        diasSemana.put("SEX", "Sexta-Feira");
        diasSemana.put("SAB", "Sabado-Feira");
        diasSemana.put("DOM", "Domingo-Feira");

        System.out.println("Exibindo os pares armazenados:");
        System.out.println(diasSemana);

        System.out.println("Verificando se um dia exista:");
        System.out.println("Quarta existe? " + diasSemana.containsKey("QUA"));
        System.out.println("ABC existe? " + diasSemana.containsKey("ABC"));

        System.out.println("Pegando um valor a partir da chave: ");
        System.out.println(diasSemana.get("DOM"));

        System.out.println("Quantidade de pares no HashMap: ");
        System.out.println(diasSemana.size());

        System.out.println("Removendo um item da lista: ");
        System.out.println(diasSemana.remove("SEG"));

    System.out.println("Percorrendo as chaves: ");
        for (String chave : diasSemana.keySet()) {
            System.out.println(chave);
        }
    System.out.println("Percorrendo os valores: ");
        for (String item : diasSemana.values()) {
            System.out.println(item);
        }
    
    System.out.println("Removendo todo os pares: ");
    diasSemana.clear();


    }
}