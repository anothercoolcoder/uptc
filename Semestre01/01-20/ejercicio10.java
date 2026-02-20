import java.util.Scanner;
public class ejercicio10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba un numero");
        double a = scanner.nextInt();

        if ( a % 2 == 0)
        System.out.println("El numero es par");
        else
        System.out.println("El numero no es par");
        scanner.close();
    }
}
