package model;

public class Notebook{

   

    private int codigo;
    private String modelo;
    private String marca;
    private Double preco;
    private String cor;
    private Boolean gpu;

    public Notebook(){

    }

    public Notebook(String modelo, String marca, Double preco, String cor, Boolean gpu) {        
        this.modelo = modelo;
        this.marca = marca;
        this.preco = preco;
        this.cor = cor;
        this.gpu = gpu;        
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
    
    public Boolean getGpu() {        
        return this.gpu;
    }
    
    public void setGpu(Boolean gpu) {
        this.gpu = gpu;
    }

    @Override
    public String toString() {
        return "Codigo: " + getCodigo()
                + " Modelo: " + getModelo()
                + " Marca: " + getMarca()
                + " Preco: " + getPreco()
                + " Disponível: " + getGpu(); 
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Notebook other = (Notebook) obj;        
        if (modelo == null) {
            if (other.modelo != null)
                return false;
        } else if (!modelo.equals(other.modelo))
            return false;
        if (marca == null) {
            if (other.marca != null)
                return false;
        } else if (!marca.equals(other.marca))
            return false;
        if (preco == null) {
            if (other.preco != null)
                return false;
        } else if (!preco.equals(other.preco))
            return false;
        if (cor == null) {
            if (other.cor != null)
                return false;
        } else if (!cor.equals(other.cor))
            return false;
        if (gpu == null) {
            if (other.gpu != null)
                return false;
        } else if (!gpu.equals(other.gpu))
            return false;
        return true;
    }
    
    
    




}