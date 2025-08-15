import java.util.Scanner;

public class ejercicios{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)){
        System.out.println("Enter a whole number: ");

        int x = sc.nextInt();

        int[] arreglo = new int[contador(x)];

        System.out.println("The value entered is: " + x);
        
        if (x%2==0){
            System.out.println("The number entered is even ");
        } else {
            System.out.println("The number entered is not even ");
        }

        int p=0;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0){
            p=p+1;
            break;
            }
        }
        if (p == 0){
            System.out.println(x + " It's a prime number");
            System.out.println("The first 10 multiplies are: ");
            for (int i = 1; i <= 10; i++) {
                System.out.println(i + ". "+ x*i);
            }
        }
        else {
            int index = 0;
            System.out.println (x + " It's not a prime number");
            for (int i = 2; i <= x; i++) {
                if (x % i ==0){
                    arreglo[index] = i;
                    index++;
                }
            }
            System.out.println("The divisors of " + x + " are: " );
            for (int i = 0; i < arreglo.length; i++) {
                System.out.print(arreglo[i]+ " ");
            }
            
        }
        
    }
    }

    public static int contador(int x) {
        int contador = 0;
        for (int i = 2; i <= x; i++) {
            if (x % i ==0){
                contador++;
            }
        }
        return contador;
    }
}

