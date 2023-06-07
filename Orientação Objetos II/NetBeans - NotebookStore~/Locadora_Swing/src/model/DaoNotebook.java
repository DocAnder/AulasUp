package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DaoNotebook {
    
    private Connection conn;
    private Statement st;


    private void conectar(){
        try {
            this.conn = GerenciadorConexao.pegarConexao();
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

    public boolean inserir(Notebook notebook){
        boolean resultado = false;
        try {
            this.conectar();
            PreparedStatement pst = conn.prepareStatement(
            "INSERT INTO Notebooks (id, modelo, marca, preco, cor, gpu) VALUES (NULL, ?,?,?,?,?)");
            pst.setString(1, notebook.getModelo());
            pst.setString(2, notebook.getMarca());
            pst.setDouble(3, notebook.getPreco());
            pst.setString(4, notebook.getCor());
            pst.setBoolean(5, notebook.getGpu());
            pst.executeUpdate();
            resultado = true;
        } catch (Exception e) {
            System.out.println("Erro ao acessar o banco: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return resultado;
    }

    public int excluir(int codigo){
        int resultado = 0;
        try {
            this.conectar();
            String comando = "DELETE FROM Notebooks WHERE id = " + codigo + ";";            
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

    public void listarTodos(){
        ResultSet todos; 
        try {
            this.conectar();
            String comando = "SELECT * FROM notebooks;";
            todos = st.executeQuery(comando);
            while (todos.next()) {
                System.out.println(
                    todos.getInt("id") + " " + todos.getString("modelo") + " " + todos.getString("marca") + " " + todos.getDouble("preco") 
                    + " " + todos.getString("cor") + " " + todos.getBoolean("gpu")
                );
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar notebooks: " + e.getMessage());
        }finally{
            this.desconectar();
        }
    }

    public Notebook buscarUm(int codigo){
        Notebook aux = null;
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM Notebooks WHERE id = " + codigo + ";");
            if (rs.next()) {
                aux = new Notebook();
                aux.setCodigo(rs.getInt("id"));
                aux.setModelo(rs.getString("modelo"));
                aux.setMarca(rs.getString("marca"));
                aux.setCor(rs.getString("cor"));
                aux.setPreco(rs.getDouble("preco"));   
                aux.setGpu(rs.getBoolean("gpu"));                
            }
        } catch (Exception e) {
            System.out.println("Erro ao acessar o item: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return aux;
    }

    public ArrayList<Notebook> buscarTodos(){
        ArrayList<Notebook> notebooks = new ArrayList<>();
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM Notebooks");
            while (rs.next()) {
                Notebook aux = new Notebook();                
                aux.setCodigo(rs.getInt("id"));
                aux.setModelo(rs.getString("modelo"));
                aux.setMarca(rs.getString("marca"));
                aux.setCor(rs.getString("cor"));
                aux.setPreco(rs.getDouble("preco"));   
                aux.setGpu(rs.getBoolean("gpu"));  
                notebooks.add(aux);
            }
        } catch (Exception e) {
            System.out.println("Erro ao acessar todos os noteboos " + e.getMessage());
        }finally{
            //this.desconectar();
        }
        return notebooks;
    }
    
    
    public int alterar(Notebook v){
        int qtde = 0;
        int gpu = 0;
        if(v.getGpu()){
            gpu = 1;
        }
        try {
            this.conectar();
            String comando = "UPDATE Notebooks SET "
                + " modelo = '" + v.getModelo() + "',"
                + " marca = '" + v.getMarca() + "',"
                + " preco = '" + v.getPreco() + "',"
                + " cor = '" + v.getCor() + "',"
                + " gpu = '" + gpu+ "'"    
                + " WHERE id = " + v.getCodigo() + ";";
            System.out.println(comando);
            st.executeUpdate(comando);
            qtde = st.getUpdateCount();
        } catch (Exception e) {
            System.out.println("Erro ao inserir registro: "
                + e.getMessage());
        }finally{
            this.desconectar();
        }
        return qtde;
    }
    
    
    public ArrayList<Notebook> buscarTodosFiltro(String campo, String filtro){
        ArrayList<Notebook> resultados = new ArrayList<Notebook>();
        
        if(!campo.equals("marca") && !campo.equals("modelo")){
            return resultados;
        }
        
        try {
            this.conectar();
            ResultSet rs = st.executeQuery(
                "SELECT * FROM Notebooks WHERE "
                    + campo + " LIKE '%" + filtro 
                    + "%' ORDER BY modelo;");
            while(rs.next()){
                Notebook v = new Notebook();
                v.setCodigo(rs.getInt("id"));
                v.setMarca(rs.getString("marca"));
                v.setModelo(rs.getString("modelo"));
                v.setCor(rs.getString("cor"));
                v.setPreco(rs.getDouble("preco"));
                v.setGpu(rs.getBoolean("gpu"));
                resultados.add(v);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return resultados;
    }




}
