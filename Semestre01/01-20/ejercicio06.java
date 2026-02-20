import java.util.Scanner;
public class ejercicio06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un numero entero");
        int A = scanner.nextInt();
        System.out.println("Ingrese un numero entero");
        int B = scanner.nextInt();
        int t = 0;
        t = A;
        A = B;
        B = t;
        System.out.println("El valor de la variable A, es: "+ A);
        System.out.println("El valor de la variable B, es: "+ B);
        scanner.close();
    }
}
