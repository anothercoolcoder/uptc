import java.util.Scanner;
public class ejercicio22 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese un valor para N");
            int n = scanner.nextInt();
            for(int i = 0; i < n + 1; i++)
                if (i== 1)
                    System.out.println("Primera iteracion (Hola mundo)");
                else
                    System.out.println("Iteracion, " + i);
                    
        }
    }
}
