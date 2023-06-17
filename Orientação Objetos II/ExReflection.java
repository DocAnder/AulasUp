import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ExReflection{


    public static void main(String[] args) {
        
        try {
            Class c = Class.forName("Veiculo");//forName é utilizado quando sabemos o nome da classe;
            //Veiculo v = new Veiculo();
            //Class c = v.getClass();//Quando vou receber a classe como parametro
            

            System.out.println("--==Obter o nome da Classe==--");
            System.out.println(c.getName());
            System.out.println("--==Buscar Atributos da Classe==--");
            Field campos[] = c.getDeclaredFields();
            for (Field field : campos) {
                //System.out.println(field);
                System.out.println(field.toString());
                System.out.println(field.getName() + " - " + field.getType());
            }

            System.out.println("--==Buscar Metodos e seus Parametros da Classe==--");
            Method methods [] = c.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method.toString());
                System.out.println(method.getName());
                Parameter parametros [] = method.getParameters();
                for (Parameter p : parametros) {
                    System.out.println(p.getParameterizedType());
                    System.out.println(p.getName());// 0 = sem param, 1 = um param, etc...
                }




            }






        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }



    }

}