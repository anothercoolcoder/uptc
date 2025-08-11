import java.util.Scanner;
public class ejercicio28 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese un valor para N1");
            int n1 = scanner.nextInt();
            int n2;
            int totalmayor = 0;
            int totalmenor = 0;
                do {
                    System.out.println("Ingrese un valor para N2");
                    n2 = scanner.nextInt();

                    if ( n2 > n1) {
                        System.out.println(n2 +" Es mayor que "+ n1);
                        totalmayor = totalmayor + 1;
                    } else {
                        if (n2 < n1) {
                        
                        System.out.println(n2 +" Es menor que "+ n1);
                        totalmenor = totalmenor + 1;
                        } 
                        
                    }
                } while (n2 != n1);
                System.out.println("Los numeros son iguales");
                System.out.println("La cantidad de veces que fue mayor, es: " + totalmayor);
                System.out.println("La cantidad de veces que fue menor, es: " + totalmenor);
            
        }
    }
}
