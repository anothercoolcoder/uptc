import java.util.Scanner;
public class ejercicio11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba un numero");
        double a = scanner.nextInt();

        if (a < 5 && a>1)
        System.out.println("El numero esta entre 1 y 5");
        else
        System.out.println("El numero no esta entre 1 y 5");
        scanner.close();
}
}
