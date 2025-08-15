import java.util.Scanner;
public class tenis {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNextLine()) {
                System.out.println("Escriba la secuencia");
                String secuencia = sc.nextLine();
                if (secuencia.isEmpty()) break;
                
                int puntosA = 0, puntosB = 0;
                int juegosA = 0, juegosB = 0;
                boolean servicioA = true;
                
                for (int i = 0; i < secuencia.length(); i++) {
                    char punto = secuencia.charAt(i);
                    
                    if (punto == 'S') {
                        if (servicioA) puntosA++;
                        else puntosB++;
                    } else if (punto == 'R') {
                        if (servicioA) puntosB++;
                        else puntosA++;
                    }
                    
                    if (puntosA >= 4 && puntosA >= puntosB + 2) {
                        juegosA++;
                        puntosA = 0;
                        puntosB = 0;
                        servicioA = !servicioA;
                        
                        if (juegosA >= 6 && juegosA >= juegosB + 2) {
                            break;
                        }
                    } else if (puntosB >= 4 && puntosB >= puntosA + 2) {
                        juegosB++;
                        puntosA = 0;
                        puntosB = 0;
                        servicioA = !servicioA;
                        
                        if (juegosB >= 6 && juegosB >= juegosA + 2) {
                            break;
                        }
                    }
                }
                
                System.out.println(juegosA + "-" + juegosB);
            }
        }
    }
}