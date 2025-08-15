import java.util.Scanner;
public class ejercicio03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el radio de una circunferencia");
        double radio = scanner.nextDouble();
        double longitud = (2 * 3.14) * radio;
        System.out.println("La longitud de ese radio, es: "+ longitud);
        scanner.close();
    }
}
