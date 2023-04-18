import java.util.ArrayList;

public class Cliente {
    
    private int codigo;
    private String nome;
    private String cpf;
    private ArrayList <Endereco> enderecos;

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        this.enderecos = new ArrayList<Endereco>();
    }

    public Cliente(){
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public void imprimeEnderecos() {
        for (Endereco endereco : this.enderecos) {
            System.out.println(
                "Rua: " + endereco.getRua() +
                " Bairro: " + endereco.getBairro() +
                " CEP: " + endereco.getCep() +
                " Cidade: " + endereco.getCidade()
            );
        }
    }

    public void attEnderecos(ArrayList<Endereco> enderecos){
        this.enderecos = enderecos;
    }
    

    public void setEnderecos(Endereco endereco) {
        this.enderecos.add(endereco);
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }
    

}
