import java.util.Scanner;

public class ejercicio37 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingresa 10 números reales:");

            for (int i = 0; i < 10; i++) {
                double x = scanner.nextDouble();
                double fx;

                if (x < 0) {
                    fx = 0;
                } else if (x >= 0 && x <= 1) {
                    fx = x;
                } else if (x > 1 && x <= 2) {
                    fx = 2 - x;
                } else {
                    fx = 0;
                }

                System.out.println("f(" + x + ") = " + fx);
            }
        }
    }
}
