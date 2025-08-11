import java.util.Scanner;
public class ejercicio15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba un numero");
        double a = scanner.nextInt();
        System.out.println("Escriba un numero");
        double b = scanner.nextInt();
        double multiplicacion = a * b;
        double suma = a + b;
        System.out.println(a + " + " + b +" = "+ suma );
        System.out.println(a + " * " + b+  " = "+ multiplicacion );

        if (suma > multiplicacion)
        System.out.println("La suma es mayor");
        else 
        System.out.println("La multiplicacion es mayor");
        scanner.close();
    }
}