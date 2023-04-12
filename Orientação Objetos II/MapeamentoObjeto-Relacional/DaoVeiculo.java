import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    public void listarTodos(){ 
        ResultSet resultado;       
        try {
            this.conectar();
            String comando = "SELECT * from tb_veiculos;"; 
            resultado = st.executeQuery(comando);
            while (resultado.next()) {                
                System.out.println(resultado.getString("MARCA"));
                System.out.println(resultado.getString("MODELO"));
            }                     
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            this.desconectar();
        }        
    }

}
