import java.util.ArrayList;

public class Cliente{

    private static int contador = 1;
    private int codigo;
    private String nome;
    private String cpf;
    private String telefone;
    private ArrayList <Orcamento> orcamentos;

    public Cliente(String nome, String cpf, String telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.orcamentos = new ArrayList<Orcamento>();
        this.codigo = Cliente.contador;
        Cliente.contador++;
    }

    public void getOrcamentos(){
        for (Orcamento orcamento : this.orcamentos) {
            System.out.println(orcamento);
        }
    }

    public void setOrcamentos(Orcamento novo){
        this.orcamentos.add(novo);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Codigo: " + String.valueOf(this.getCodigo()) + "\n" +
               "Nome: " + this.getNome() + "\n" +
               "Cpf: " + this.getCpf() + "\n" +
               "Telefone: " + this.getTelefone();
    }

    
}