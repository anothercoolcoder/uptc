import java.util.Scanner;
public class ejercicio27 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numero;
            do {
                System.out.println("Escriba un numero entre 0 y 9");
                numero = scanner.nextInt();

                switch (numero) {
                    case 0 -> System.out.println("Hola");

                    case 1 -> System.out.println("¿Como estas?");
                    
                    case 2 -> System.out.println("Muy bien, ¿y vos?");
                    
                    case 3 -> System.out.println("Yo bien, por aca montando bicicleta");
                    
                    case 4 -> System.out.println("Que bueno, te felicito");
                    
                    case 5 -> System.out.println("Muchas gracias, ¿vos que has hecho");
                    
                    case 6 -> System.out.println("Bucear");
                    
                    case 7 -> System.out.println("¿Si, donde?");
                    
                    case 8 -> System.out.println("Estuve en la isla gorgona");
                
                    default -> {
                        
                    }
                } 
            } while (  numero < 9
                    && numero > 0);
            System.out.println("Fin del programa");
        }
    }
}
