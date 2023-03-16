
public class Orcamento {
    
    private static int contador = 101;
    private int codigo;
    private double valor;
    private int validade;

    public Orcamento(double valor, int validade){       
       this.valor = valor;
       this.validade = validade;
       this.codigo = Orcamento.contador;
       Orcamento.contador++;       
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getValidade() {
        return validade;
    }
    public void setValidade(int validade) {
        this.validade = validade;
    }

    @Override
    public String toString() {
        return "Codigo: " + this.codigo + " Valor: " + this.valor + " Validade: " + this.validade + " dias.";
    }
    

}
