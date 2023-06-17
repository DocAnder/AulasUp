import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoGenerico {
    
    private Connection conn;
    private Statement st;
    private final String TB_PREFIX = "tb_";
    private final String TB_SUFFIX = "s ";

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
        } catch (SQLException e){
            System.out.println("Erro ao encerrar conexão: " + e.getMessage());
        }
    }

    public void inserir (Object o) throws Exception {
       Class c = o.getClass(); 
       Field fields[] = c.getDeclaredFields();

       //Primeiro montar a query para o PreparedStatment;
       String query = "INSERT INTO " + TB_PREFIX + c.getSimpleName().toLowerCase() + TB_SUFFIX;
       String campos = "(";
       String aliases = " VALUES (";
       boolean separa = false;
       for(Field f : fields){
        if(separa){
            campos = campos + ", ";
            aliases = aliases + ", ";
        }
        campos = campos + f.getName();
        aliases = aliases + "?";
        separa = true;
       }
       campos = campos + ") ";
       aliases = aliases + ") ";

       query = query + campos + aliases;

       System.out.println(campos);
       System.out.println(aliases);
       System.out.println(query);       

       //Criar o PreparedStatment e setar os valores;
       this.conectar();
       PreparedStatement pst = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

       int numParam = 0;
       for( Field f : fields){
        numParam++;
        f.setAccessible(true);
        System.out.println("tipo: " + f.getType());
        if(f.getType().isAssignableFrom(String.class)){
            if(f.get(o) != null){
                pst.setString(numParam, f.get(o).toString());
            }else{
                pst.setString(numParam, "");
            }            
        }else if(f.getType().isAssignableFrom(Integer.class) || f.getType().isAssignableFrom(Integer.TYPE)){
            pst.setInt(numParam, Integer.parseInt(f.get(o).toString()));

        }
       }
       pst.executeUpdate();
       this.desconectar();
    }







}
