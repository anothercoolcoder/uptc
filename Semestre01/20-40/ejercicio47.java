import java.util.Scanner;

public class ejercicio47 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;
            double a = 0, b = 1;
            int n = 10;

            do {
                System.out.println("\nMenú:");
                System.out.println("1. Calcular área bajo la función y = 4");
                System.out.println("2. Calcular área bajo la función y = x^2");
                System.out.println("3. Establecer límites para el dominio de la función (eje x)");
                System.out.println("4. Establecer el número de intervalos según los límites");
                System.out.println("5. Salir");
                System.out.print("Selecciona una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1 -> {
                        double area1 = calcularAreaConstante(a, b, n);
                        System.out.printf("El área bajo la función y = 4 en el intervalo [%.2f, %.2f] es %.2f\n", a, b, area1);
                    }
                    case 2 -> {
                        double area2 = calcularAreaCuadratica(a, b, n);
                        System.out.printf("El área bajo la función y = x^2 en el intervalo [%.2f, %.2f] es %.2f\n", a, b, area2);
                    }
                    case 3 -> {
                        System.out.print("Ingresa el límite inferior (a): ");
                        a = scanner.nextDouble();
                        System.out.print("Ingresa el límite superior (b): ");
                        b = scanner.nextDouble();
                        if (a < 0 || b <= a) {
                            System.out.println("Límites no válidos. Deben ser a >= 0 y b > a.");
                            a = 0;
                            b = 1;
                        }
                    }
                    case 4 -> {
                        System.out.print("Ingresa el número de intervalos: ");
                        n = scanner.nextInt();
                        if (n <= 0) {
                            System.out.println("Número de intervalos no válido. Debe ser mayor que 0.");
                            n = 10;
                        }
                    }
                    case 5 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción no válida. Intenta nuevamente.");
                }
            } while (opcion != 5);
        }
    }

    public static double calcularAreaConstante(double a, double b, int n) {
        double area = 0;
        double dx = (b - a) / n;
        for (int i = 0; i < n; i++) {
            area += 4 * dx;  // y = 4, constante
        }
        return area;
    }

    public static double calcularAreaCuadratica(double a, double b, int n) {
        double area = 0;
        double dx = (b - a) / n;
        for (int i = 0; i < n; i++) {
            double x = a + i * dx;
            area += x * x * dx;  // y = x^2
        }
        return area;
    }
}
