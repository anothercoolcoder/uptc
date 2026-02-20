import java.util.Scanner;

public class ejercicio40 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n;

            System.out.println("Ingresa el número de términos que deseas generar:");
            n = scanner.nextInt();

            while (true) {
                System.out.println("\nMenú:");
                System.out.println("1. Generar los n primeros términos de la sucesión aritmética");
                System.out.println("2. Generar los n primeros términos de la sucesión geométrica");
                System.out.println("3. Generar los n primeros términos de la sucesión de cúbicos");
                System.out.println("4. Generar los n primeros términos de la sucesión de Fibonacci");
                System.out.println("5. Salir");
                System.out.print("Selecciona una opción: ");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        generarAritmetica(n);
                        break;
                    case 2:
                        generarGeometrica(n);
                        break;
                    case 3:
                        generarCubicos(n);
                        break;
                    case 4:
                        generarFibonacci(n);
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        System.exit(0);
                    default:
                        System.out.println("Opción no válida. Intenta nuevamente.");
                }
            }
        }
    }

    public static void generarAritmetica(int n) {
        int a = 3;
        int d = 5;
        System.out.println("Sucesión aritmética:");
        for (int i = 0; i < n; i++) {
            System.out.print(a + (i * d) + " ");
        }
        System.out.println();
    }

    public static void generarGeometrica(int n) {
        int a = 3;
        int r = 3;
        System.out.println("Sucesión geométrica:");
        for (int i = 0; i < n; i++) {
            System.out.print((int) (a * Math.pow(r, i)) + " ");
        }
        System.out.println();
    }

    public static void generarCubicos(int n) {
        System.out.println("Sucesión de cúbicos:");
        for (int i = 1; i <= n; i++) {
            System.out.print((int) Math.pow(i, 3) + " ");
        }
        System.out.println();
    }

    public static void generarFibonacci(int n) {
        int a = 0;
        int b = 1;
        System.out.println("Sucesión de Fibonacci:");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int temp = a;
            a = b;
            b = temp + b;
        }
        System.out.println();
    }
}
