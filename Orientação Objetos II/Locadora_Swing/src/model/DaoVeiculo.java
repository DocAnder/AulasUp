package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class DaoVeiculo {
    
    private Connection conn;
    private Statement st;

    private void conectar(){
        try {
            this.conn = GerenciarConexao.pegarConexao();
            st = conn.createStatement();
        } catch (ClassNotFoundException e1) {
            System.out.println(e1.getMessage());
        } catch (SQLException e2){
            System.out.println(e2.getMessage());
        }
    }


    private void desconectar(){
        try {
            st.close();
            conn.close();            
        } catch (SQLException e2){
            System.out.println(e2.getMessage());
        }
    }

    public boolean inserir(Veiculo veiculo){
        boolean resultado = false;
        try {
            this.conectar();
            String comando = "INSERT INTO tb_veiculos VALUES(NULL,"
                            + "'" + veiculo.getMarca() + "'," + "'" + veiculo.getModelo() + "'," + "'" + veiculo.getChassi() + "', " + veiculo.getAno() + ");"; 
            System.out.println(comando);
            st.executeUpdate(comando);            
            resultado = true;
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            this.desconectar();
        }
        return resultado;
    }

    //Forma de imprimir direto
    public void listarTodos(){ 
        ResultSet resultado;       
        try {
            this.conectar();
            String comando = "SELECT * from tb_veiculos;"; 
            resultado = st.executeQuery(comando);
            while (resultado.next()) {                
                System.out.println(resultado.getString("MARCA")  + " " + resultado.getString("MODELO") + " " + resultado.getString("CHASSI") + " " + resultado.getString("ANO"));                
            }                     
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            this.desconectar();
        }        
    }


    public ArrayList<Veiculo> buscarTodos(){
        ArrayList<Veiculo> resultados = new ArrayList<Veiculo>();

        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_veiculos ORDER BY modelo;");
            while (rs.next()) {
                Veiculo aux = new Veiculo();
                aux.setCodigo(rs.getInt("CODIGO"));
                aux.setMarca(rs.getString("MARCA"));
                aux.setModelo(rs.getString("MODELO"));
                aux.setChassi(rs.getString("CHASSI"));
                aux.setAno(rs.getInt("ANO"));
                resultados.add(aux);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }

        return resultados;
    }

    public Veiculo buscarUm(int codigo){
        Veiculo aux = null;
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_veiculos WHERE codigo = " + codigo + ";");
            if (rs.next()) {
                aux = new Veiculo();
                aux.setCodigo(rs.getInt("CODIGO"));
                aux.setMarca(rs.getString("MARCA"));
                aux.setModelo(rs.getString("MODELO"));
                aux.setChassi(rs.getString("CHASSI"));
                aux.setAno(rs.getInt("ANO"));    
            }            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return aux;
    }

    public int alterarUm(Veiculo veiculo){
        int qtd = 0;
        try {
            this.conectar();
            String comando = "UPDATE tb_veiculos SET " +
            "marca = '" + veiculo.getMarca() + "'," +
            "modelo = '" + veiculo.getModelo() + "'," +
            "chassi = '" + veiculo.getChassi() + "'," +
            "ano = " + veiculo.getAno() +
            " WHERE codigo = " + veiculo.getCodigo() + ";";
            //System.out.println(comando);
            st.executeUpdate(comando);
            qtd = st.getUpdateCount();
        } catch (Exception e) {
            System.out.println("Erro ao inserir o registro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return qtd;
    }




    public int exlcluir(int codigo){
        int resultado = 0;
        try {
            this.conectar();
            String comando = "DELETE FROM tb_veiculos WHERE codigo = " + codigo + ";";            
            st.executeUpdate(comando);
            //getUpdate recupera quantos dados foram apagados do banco            
            resultado = st.getUpdateCount();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return resultado;
    }
    
    public ArrayList<Veiculo> buscarTodosFiltro(String campo, String filtro){        

        ArrayList<Veiculo> resultados = new ArrayList<Veiculo>();
        
        if(!campo.equals("marca") && !campo.equals("modelo") ){
            return resultados;
        }                

        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_veiculos WHERE " + campo + " LIKE '%" + filtro + "%';");
            while (rs.next()) {
                Veiculo aux = new Veiculo();
                aux.setCodigo(rs.getInt("CODIGO"));
                aux.setMarca(rs.getString("MARCA"));
                aux.setModelo(rs.getString("MODELO"));
                aux.setChassi(rs.getString("CHASSI"));
                aux.setAno(rs.getInt("ANO"));
                resultados.add(aux);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }

        return resultados;   
        
            
                
    }

}