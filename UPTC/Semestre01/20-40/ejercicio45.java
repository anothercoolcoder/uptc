import java.util.Random;
import java.util.Scanner;

public class ejercicio45 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();

            System.out.println("Ingresa una distancia (número entero positivo):");
            int distancia = scanner.nextInt();

            System.out.println("Ingresa la cantidad de puntos:");
            int cantidadPuntos = scanner.nextInt();

            double[] puntos = new double[cantidadPuntos];
            puntos[0] = 0;
            puntos[cantidadPuntos - 1] = distancia;

            for (int i = 1; i < cantidadPuntos - 1; i++) {
                puntos[i] = puntos[i - 1] + random.nextDouble() * (distancia - puntos[i - 1]) / (cantidadPuntos - i);
            }

            System.out.println("Punto origen = 0");
            System.out.println("Punto destino = " + distancia);
            System.out.println("Lista de puntos generados:");

            for (double punto : puntos) {
                System.out.printf("%.2f\n", punto);
            }
        }
    }
}
