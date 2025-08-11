import java.util.Scanner;

public class ejercicio44 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingresa un texto:");
            String texto = scanner.nextLine();

            if (texto.contains("Hola")) {
                System.out.println("El texto contiene la palabra 'Hola'.");
            } else {
                System.out.println("El texto NO contiene la palabra 'Hola'.");
            }
        }
    }
}
