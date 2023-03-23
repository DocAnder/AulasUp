public class Aeroporto {

    private String nome;
    private String cidade;
    private String altitude;


    public Aeroporto(String nome, String cidade, String altitude){
        this.nome = nome;
        this.cidade = cidade;
        this.altitude = altitude;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getAltitude() {
        return altitude;
    }
    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\n" +
                "Cidade: " + this.getCidade() + "\n" +
                "Altitude: " + this.getAltitude() + "\n";
    }
    


}
