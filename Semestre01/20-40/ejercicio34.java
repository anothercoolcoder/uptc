import java.util.Scanner;
public class ejercicio34 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese un numero");
            int numero = scanner.nextInt();
            operacion(numero);
        }
    }
    public static void operacion(int n){
        boolean primo = true;
        int temp = n;
        int suma = 0;
        //cifras y sumita, papa
        String cifras = "";
        while ( n > 0) {
            suma = suma + n %10;
            int digito = n % 10;
            cifras = digito + "+" + cifras;
            n = n /10;
        }
        if(cifras.endsWith("+")) {
            cifras = cifras.substring(0, cifras.length() - 1);
        }
        // primo
        if (n <= 1) {
            primo = false;

        } else {
            for(int i = 2; i <= n -1; i++){
                if (n%i ==0) {
                    primo = false;
                    break;
                }
            }
        }

        if (primo){
            System.out.println( temp + " Si cumple, porque "+ cifras + " = "+ suma +", "+ suma +  " Si es primo" );
        } else {
            System.out.println( temp + " No cumple, porque "+ cifras + " = "+ suma +", "+ suma +  " no es primo" );
        }
    }
}
