import java.util.Scanner;
public class name28 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese un numero");
            double n1 = sc.nextDouble();
            double n2 = 0;
            int mayor= 0;
            int menor= 0;

            do { 
                System.out.println("Ingrese un numero");
                n2 = sc.nextDouble();
                if (n1 > n2) {
                    System.out.println("El numero es mayor");
                    mayor++;
                }else {  
                }if(n1 < n2 ){
                    System.out.println("El numero es menor");
                    menor++;
                }
                
            } while (n1 != n2);
            System.out.println("Los numeros son iguales");
            System.out.println("La cantidad de veces que fue mayor es: " + mayor);
            System.out.println("La cantidad de veces que fue menor es: " + menor);
        }

    }
}
