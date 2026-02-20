import java.util.Scanner;
public class ejercicio26 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String letra;
            int avisador = 0;
            do {
                System.out.println("Escriba una letra");
                letra = scanner.nextLine();

                switch (letra) {
                    case "a", "A" : 
                    case "b", "B" : 
                    case "c", "C" : 
                    case "d", "D" :
                    case "e", "E" : 
                    case "f", "F" :
                        System.out.println("Ha ingresado la letra : " + letra);
                    default : {
                        avisador = avisador +1;
                        break;
                    }
                } 
            } while (avisador == 0);
            System.out.println("Ha escrito un valor erroneo");
        }
    }
}
