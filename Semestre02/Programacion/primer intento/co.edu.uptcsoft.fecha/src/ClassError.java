import java.util.Scanner;

public class ClassError {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Digite su numero 1");
            int r1    = sc.nextInt();
            System.out.println("Digite su numero 2");
            int r2     = sc.nextInt();

            int res = r1/r2;
            System.out.println("Digite su precio");
        }
        catch (ArithmeticException e) {
            System.out.println("La division por cero es indefinida  "+e.getMessage());;
        } catch (Exception e) {
            System.out.println("Por favor, digita solo numeros      "+e.getMessage());
        }

//        catch ( Exception  |ArithmeticException){
//            System.out.println("La division es indefinida");
//        }
    }
}
