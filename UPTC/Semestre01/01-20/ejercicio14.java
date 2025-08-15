import java.util.Scanner;
public class ejercicio14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba un numero");
        double a = scanner.nextInt();
        System.out.println("Escriba un numero");
        double b = scanner.nextInt();
        System.out.println("Escriba un numero");
        double c = scanner.nextInt();

        if (b > c && b > a)
        System.out.println(b + " Si es mayor que " + c +" Y mayor que " + a);
        else
        System.out.println(b + " No es mayor que " + c +" Y mayor que " + a);
        scanner.close();
    }
}