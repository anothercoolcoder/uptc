import java.util.Scanner;
public class ejercicio09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba un numero");
        double a = scanner.nextInt();
        System.out.println("Escriba un numero");
        double b = scanner.nextInt();

        if (a % b == 0)
            System.out.println("Son multiplos");
        else
            if (b % a == 0)
            System.out.println("Son multiplos");
            else
            System.out.println("No son multiplos");
            scanner.close();
}
}
