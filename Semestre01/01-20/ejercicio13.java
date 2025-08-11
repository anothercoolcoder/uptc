import java.util.Scanner;
public class ejercicio13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba un numero");
        double a = scanner.nextInt();
        System.out.println("Escriba un numero");
        double b = scanner.nextInt();
        double suma = a +b;
        if (suma > 0)
        System.out.println("La suma es mayor que cero");
        else
        if (suma == 0)
        System.out.println("La suma es igual a cero");
        else
        System.out.println("La suma es menor a cero");
        scanner.close();  
    }
}