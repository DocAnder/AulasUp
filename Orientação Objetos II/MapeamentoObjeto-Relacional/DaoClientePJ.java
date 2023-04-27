
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoClientePJ {
    
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

    public boolean inserir(ClientePJ cli){
        boolean resultado = false;
        try {
            this.conectar();
            PreparedStatement pst = conn.prepareStatement(
              "INSERT INTO tb_clientes_pj (cod_cli_pj, nome, cnpj)"
              + "VALUES (NULL, ?,?);",
              Statement.RETURN_GENERATED_KEYS  
            );
            pst.setString(1, cli.getNome());
            pst.setString(2, cli.getCnpj());
            pst.executeUpdate();
            
            ResultSet rs = pst.getGeneratedKeys();
            int idCliente = 0;
            if(rs.next()){
                idCliente = rs.getInt(1);
                PreparedStatement pstEnd = conn.prepareStatement(
                    "INSERT INTO tb_enderecos_pj (cod_end, cod_cli_pj, rua, numero, bairro, cep)"
                    + "VALUES (NULL, ?,?,?,?,?);");
                pstEnd.setInt(1, idCliente);
                pstEnd.setString(2, cli.getEnderecoPJ().getRua());
                pstEnd.setInt(3, cli.getEnderecoPJ().getNumero());
                pstEnd.setString(4, cli.getEnderecoPJ().getBairro());
                pstEnd.setString(5, cli.getEnderecoPJ().getCep());
                pstEnd.executeUpdate();
                resultado = true;
            }        
            
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


    public ArrayList<ClientePJ> buscarTodos(){
        ArrayList<ClientePJ> resultados = new ArrayList<ClientePJ>();

        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_clientes_pj as c, tb_enderecos_pj as e WHERE c.cod_cli_pj = e.cod_cli_pj ORDER BY c.nome;");
            while (rs.next()) {
                ClientePJ aux = new ClientePJ();
                aux.setCodigoCliente(rs.getInt("cod_cli_pj"));
                aux.setNome(rs.getString("nome"));
                aux.setCnpj(rs.getString("cnpj"));

                EnderecoPJ endAux = new EnderecoPJ();
                endAux.setCodigo(rs.getInt("cod_end"));
                endAux.setRua(rs.getString("rua"));
                endAux.setNumero(rs.getInt("numero"));
                endAux.setBairro(rs.getString("bairro"));
                endAux.setCep(rs.getString("cep"));

                aux.setEnderecoPJ(endAux);                
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
            PreparedStatement pstEnd = conn.prepareStatement(
                    "DELETE FROM tb_enderecos_pj WHERE cod_cli_pj = ?");
            pstEnd.setInt(1, codigo);            
            pstEnd.executeUpdate();

            PreparedStatement pstCli = conn.prepareStatement(
                    "DELETE FROM tb_clientes_pj WHERE cod_cli_pj = ?");
            pstCli.setInt(1, codigo);
            pstCli.executeUpdate();
            //getUpdate recupera quantos dados foram apagados do banco
            resultado = pstCli.getUpdateCount();   
            
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return resultado;
    }

}