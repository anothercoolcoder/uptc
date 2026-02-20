import java.util.Scanner;
public class ejercicio23 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int total = 0;
            for (int i = 1; i < 8; i++){
                System.out.println("Ingrese un valor para la variable, #"+ i);
                int valor = scanner.nextInt();
                total = total + valor;
            }
            System.out.println("El resultado final es, "+ total);
        }
    }
}
