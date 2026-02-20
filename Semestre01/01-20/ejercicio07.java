import java.util.Scanner;
public class ejercicio07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba un numero");
        double a = scanner.nextInt();
        System.out.println("Escriba un numero");
        double b = scanner.nextInt();

        if (a == b)
        System.out.println("Son iguales");
        else
        System.out.println("No son iguales");
        scanner.close();
    }
}
