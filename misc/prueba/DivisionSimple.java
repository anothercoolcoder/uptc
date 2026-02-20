import java.util.Scanner;

public class DivisionSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese un número: ");
        int a = sc.nextInt();

        System.out.print("Ingrese otro número: ");
        int b = sc.nextInt();

        int resultado = a / b;
        System.out.println("Resultado: " + resultado);
    }
}