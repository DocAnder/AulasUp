public class Notebook{

    private int codigo;
    private String modelo;
    private String marca;
    private Double preco;
    private String cor;
    private Boolean disponivel;

    public Notebook(){

    }

    public Notebook(int codigo, String modelo, String marca, Double preco, String cor, Boolean disponivel) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.marca = marca;
        this.preco = preco;
        this.cor = cor;
        this.disponivel = disponivel;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public Boolean getDisponivel() {
        return disponivel;
    }
    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Codigo: " + getCodigo()
                + " Modelo: " + getModelo()
                + " Marca: " + getMarca()
                + " Preco: " + getPreco()
                + " Disponível: " + getDisponivel(); 
    }
    


}