import java.util.Scanner;
public class ejercicio04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el valor de el radio de un circulo");
        double radio = scanner.nextDouble();
        double area = 3.14*(radio * radio);
        System.out.println("El area es igual a " + area);
        scanner.close();
    }
}
