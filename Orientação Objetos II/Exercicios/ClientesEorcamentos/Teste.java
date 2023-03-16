public class Teste {
    
    public static void main(String[] args) {
        
        Cliente c1 = new Cliente("Pedro de Lara", "111222333", "45-99995050");
        Orcamento orca = new Orcamento(350.00, 15);
        Orcamento orca2 = new Orcamento(500.00, 10);
        c1.setOrcamentos(orca);
        c1.setOrcamentos(orca2);

        System.out.println(c1);
        //c1.getOrcamentos();

    }


}
