import java.util.Scanner;

public class ejercicio36 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingresa un número de dos cifras: ");
            int numero = scanner.nextInt();

            System.out.println("Las combinaciones que suman " + numero + " son:");
            for (int i = 0; i <= numero; i++) {
                for (int j = 0; j <= numero - i; j++) {
                    int k = numero - i - j;
                    if (k >= 0) {
                        System.out.println(i + " + " + j + " + " + k + " = " + numero);
                    }
                }
            }
        }
    }
}
