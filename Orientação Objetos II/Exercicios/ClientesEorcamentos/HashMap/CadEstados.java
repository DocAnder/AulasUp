import java.util.HashMap;

public class CadEstados {
    

    public static void main(String[] args) {
        
        HashMap <String, Estado> estados = new HashMap<String, Estado>();

        Estado e1 = new Estado();

        e1.setNome("Paraná");
        e1.setRegiao("Sul");

        estados.put("PR", e1);

        Estado e2 = new Estado();
        e2.setNome("Rio Grande do Sul");
        e2.setRegiao("Sul");

        estados.put("RS", e2);

        System.out.println("Estados armazenados: " + estados);

        System.out.println("Verificando se o estado existe: ");
        String pesquisado = "RS";
        if (estados.containsKey(pesquisado)) {
            System.out.println("RS existe dentro do HasMap");
            System.out.println("Mostrando a região do estado de " + pesquisado);
            System.out.println(estados.get(pesquisado).getRegiao());
        }

        System.out.println("Percorrendo as chaves: ");
        for (String chave : estados.keySet()) {
            System.out.println(chave);
        }
        System.out.println("Percorrendo os valores: ");
        for (Estado estado : estados.values()) {
            System.out.println(estado.getNome());
        }


    }
}
