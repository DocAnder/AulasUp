public class OperacoesMatematicas {
    
    public int somar (int a, int b){
        return a + b;
    }

    public int subtrair (int a, int b){
        return a - b;
    }

    public int multiplicar (int a, int b){
        return a * b;
    }

    public int dividir(int a, int b) throws DivisaoPorZeroException{
        if (b == 0) {
            throw new DivisaoPorZeroException(); //faz a chamada do erro personalizado.
        }
        return a / b;
    }

}
