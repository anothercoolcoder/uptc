import java.util.Scanner;
public class ejercicio08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba un numero");
        double a = scanner.nextInt();
        System.out.println("Escriba un numero");
        double b = scanner.nextInt();

        if (a > b)
            System.out.println("El primero es mayor");
        else
            if(a < b)
            System.out.println("El segundo es mayor");
            else
            System.out.println("Son iguales");

            scanner.close();
}
}
