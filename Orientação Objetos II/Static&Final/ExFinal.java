public class ExFinal {
    
    private final int id = 123;

    public static void main(String[] args) {
        
        final float pi = 3.14f;
        System.out.println(pi);

        ExFinal e1 = new ExFinal();
        System.out.println(e1.id);

        
    }
}
