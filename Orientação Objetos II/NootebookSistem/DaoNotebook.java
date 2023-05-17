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

    public boolean inserir(Notebook notebook){
        boolean resultado = false;
        try {
            this.conectar();
            PreparedStatement pst = conn.prepareStatement(
            "INSERT INTO tb_notebooks (modelo, marca, preco, cor, disponivel) VALUES (NULL, ?,?,?,?,?)");
            pst.setString(1, notebook.getModelo());
            pst.setString(2, notebook.getMarca());
            pst.setDouble(3, notebook.getPreco());
            pst.setString(4, notebook.getCor());
            pst.setBoolean(5, notebook.getDisponivel());
            pst.executeUpdate();
            resultado = true;
        } catch (Exception e) {
            System.out.println("Erro ao acessar o banco: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return resultado;
    }

    public void listarTodos(){
        ResultSet todos; 
        try {
            this.conectar();
            String comando = "SELECT * FROM tb_notebooks;";
            todos = st.executeQuery(comando);
            while (todos.next()) {
                System.out.println(
                    todos.getInt("id") + " " + todos.getString("modelo") + " " + todos.getString("marca") + " " + todos.getDouble("preco") 
                    + " " + todos.getString("cor") + " " + todos.getBoolean("disponivel")
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
            ResultSet rs = st.executeQuery("SELECT * FROM tb_notebooks WHERE id = " + codigo + ";");
            if (rs.next()) {
                aux = new Notebook();
                aux.setCodigo(rs.getInt("id"));
                aux.setModelo(rs.getString("marca"));
                aux.setMarca(rs.getString("marca"));
                aux.setCor(rs.getString("cor"));
                aux.setPreco(rs.getDouble("preco"));   
                aux.setDisponivel(rs.getBoolean("disponivel"));                
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
            ResultSet rs = st.executeQuery(
                "SELECT * FROM tb_notebooks"
            );
            while (rs.next()) {
                Notebook aux = new Notebook();                
                aux.setCodigo(rs.getInt("id"));
                aux.setModelo(rs.getString("marca"));
                aux.setMarca(rs.getString("marca"));
                aux.setCor(rs.getString("cor"));
                aux.setPreco(rs.getDouble("preco"));   
                aux.setDisponivel(rs.getBoolean("disponivel"));  
                notebooks.add(aux);
            }
        } catch (Exception e) {
            System.out.println("Erro ao acessar todos os noteboos " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return notebooks;
    }

}
