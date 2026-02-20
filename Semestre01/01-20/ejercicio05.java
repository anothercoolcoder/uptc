import java.util.Scanner;
public class ejercicio05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ingrese un numero para dividendo");
        double primero = scanner.nextDouble();
        System.out.println("ingrese un numero para divisor");
        double segundo = scanner.nextDouble();

        double resultado = primero/segundo;
        double residuo = primero % segundo;
        System.out.println("El resultado de la division, es " + resultado);
        System.out.println("El residuo de la division, es " + residuo);
        scanner.close();
    }
}
