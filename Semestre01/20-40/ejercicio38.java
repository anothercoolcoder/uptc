import java.util.Scanner;

public class ejercicio38 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingresa una distancia (número entero positivo):");
            int distancia = scanner.nextInt();

            System.out.println("Ingresa la cantidad de puntos:");
            int cantidadPuntos = scanner.nextInt();

            double intervalo = (double) distancia / cantidadPuntos;

            System.out.println("Punto origen = 0");
            System.out.println("Punto destino = " + distancia);
            System.out.println("Lista de puntos generados:");

            for (int i = 0; i < cantidadPuntos; i++) {
                double punto = i * intervalo;
                System.out.println(punto);
            }
        }
    }
}
