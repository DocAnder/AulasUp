public class tester {
    

    public static void main(String[] args) throws Exception {
        
        DaoGenerico dao = new DaoGenerico();

        Veiculo v = new Veiculo();

        v.setAno(2020);
        v.setChassi("123456");
        v.setMarca("Ford");
        v.setModelo("Ka");
        dao.inserir(v);



    }




}
