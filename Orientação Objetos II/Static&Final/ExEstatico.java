public class ExEstatico {
    
    public static void main(String[] args) {
        
        Cliente c1 = new Cliente();
        c1.setNome("Paulão da Fuzilagem");
        System.out.println("qtd de clientes " + Cliente.qtdClientes);

        Cliente c2 = new Cliente();
        c2.setNome("Chaolin Matador de Porco");
        System.out.println("qtd de clientes " + Cliente.qtdClientes);


    }
}
