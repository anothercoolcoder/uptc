import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionSimple {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a, b;
        try{
            System.out.print("Ingrese un número: ");
            a = sc.nextInt();

            System.out.print("Ingrese otro número: ");
            b = sc.nextInt();
            if (a < 0 || b < 0){
                throw new InputMismatchException ("No pueden ser valores negativos");
            }
            int resultado = a / b;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Division en cero");
        } catch (InputMismatchException e){
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Valores numericos");
        }
    }
}

