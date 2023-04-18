import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoCliente {
    
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

    public boolean inserir(Cliente cliente){
        boolean resultado = false;
        try {
            this.conectar();
            String comando = "INSERT INTO tb_clientes VALUES(NULL,"
            + "'" + cliente.getNome() + "'," + "'" + cliente.getCpf() + "');";            
            st.executeUpdate(comando);
            
            ArrayList<Endereco> enderecos = cliente.getEnderecos();
            for (Endereco endereco : enderecos) {
                comando = "INSERT INTO tb_endereco VALUES(LAST_INSERT_ID(),"
                + "'" + endereco.getRua() + "'," + endereco.getCep() + "," 
                + "'" + endereco.getBairro() + "'," + "'" + endereco.getCidade() + "');";
                //System.out.println(comando);
                st.executeUpdate(comando);    
            }

            //comando = "INSERT INTO tb_endereco VALUES(LAST_INSERT_ID(), 'rua do 1'," + 11111111 + ", 'barro do 1', 'cidade do 1');";
            //st.executeUpdate(comando);
            //comando = "INSERT INTO tb_endereco VALUES(LAST_INSERT_ID(), 'rua do 1 outra'," + 2222222 + ", 'barro do 1 outra', 'cidade do 1 outra');";
            //st.executeUpdate(comando);      

            resultado = true;
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            this.desconectar();
        }
        return resultado;
    }

    public Cliente buscarUm(int codigo){
        Cliente aux = null;
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_clientes WHERE codigo = " + codigo + ";");
            if (rs.next()) {
                aux = new Cliente(rs.getString("NOME"), rs.getString("CPF"));
                aux.setCodigo(rs.getInt("CODIGO"));
                ResultSet enderecos = st.executeQuery("SELECT * FROM tb_endereco WHERE codigo_cliente = " + codigo + ";");
                while (enderecos.next()) {
                    Endereco endAuxiliar = new Endereco(enderecos.getString("RUA"), enderecos.getString("BAIRRO"), enderecos.getInt("CEP"), enderecos.getString("CIDADE"));
                    aux.setEnderecos(endAuxiliar);                    
                }                
            }            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return aux;
    }


    public ArrayList<Cliente> buscarTodos(){
        ArrayList<Cliente> resultados = new ArrayList<Cliente>();
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_clientes ORDER BY nome;");
            while (rs.next()) {
                Cliente aux = new Cliente();
                aux.setCodigo(rs.getInt("CODIGO"));
                aux.setNome(rs.getString("NOME"));
                aux.setCpf(rs.getString("CPF"));                
                resultados.add(aux);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return resultados;
    }

    public int exlcluir(int codigo){
        int resultado = 0;
        try {
            this.conectar();
            String comando = "DELETE FROM tb_clientes WHERE codigo = " + codigo + ";";
            String comando2 = "DELETE FROM tb_endereco WHERE codigo_cliente = " + codigo + ";";            
            st.executeUpdate(comando);
            //getUpdate recupera quantos dados foram apagados do banco            
            resultado = st.getUpdateCount();
            st.executeUpdate(comando2);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return resultado;
    }

    public int alterarUm(Cliente cliente){
        int qtd = 0;
        try {
            this.conectar();
            String comando = "UPDATE tb_clientes SET " +
            "nome = '" + cliente.getNome() + "'," +
            "cpf = '" + cliente.getCpf() + "' WHERE codigo = " + cliente.getCodigo() + ";";
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



}
