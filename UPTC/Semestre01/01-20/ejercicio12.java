import java.util.Scanner;
public class ejercicio12 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Escriba un numero");
            int a = scanner.nextInt();
            
            switch (a) {
                case 1 -> System.out.println("Ha ingresado el numero Uno");
                case 2 -> System.out.println("Ha ingresado el numero Dos");
                case 3 -> System.out.println("Ha ingresado el numero Tres");
                case 4 -> System.out.println("Ha ingresado el numero Cuatro");
                case 5 -> System.out.println("Ha ingresado el numero Cinco");
                default -> System.out.println("Ha ingresado un numero distinto de el rango de 1 a 5");
            }
        }
            }
}
