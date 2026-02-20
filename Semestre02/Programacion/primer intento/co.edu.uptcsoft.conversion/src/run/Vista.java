package run;
import java.util.Scanner;
public class Vista {
    public void IngresoInfo () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un texto");
        String valor = sc.nextLine();
        int valor1;
        try {
            valor1 = Integer.parseInt(valor);
        }
        catch (NumberFormatException e) {
            valor1 = 0;
        }
        sout

        System.out.println("El valor que usted ha agregado es: " + valor1);
    }
}
