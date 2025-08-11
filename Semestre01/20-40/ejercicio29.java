import java.util.Scanner;
public class ejercicio29 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese un numero para la base");
            int base = scanner.nextInt();
            System.out.println("Ingrese un numero para la base");
            int exponente = scanner.nextInt();
            int resultado = 1;
            if(exponente == 0) {
                resultado = 1;
            }else {
                for (int i = 1; i <= exponente; i++) {
                    resultado = resultado * base;
                }
            }
            
            System.out.println(base + " elevado a " + exponente + " es igual a " + resultado);
        }

    }
}
