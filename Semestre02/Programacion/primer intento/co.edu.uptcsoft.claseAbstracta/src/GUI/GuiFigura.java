package GUI;
import java.util.Scanner;
import CONTROL.ControlFigura;
import LOGIC.Figura;

public class GuiFigura {
    ControlFigura control = new ControlFigura();
    Scanner sc = new Scanner(System.in);
    public void createFigura(){
        Figura figura = null;
        while(true){
            System.out.println("Selecciona la figura");
            System.out.println("1. Circulo");
            System.out.println("2. Rectangulo");
            System.out.println("3. Triangulo");
            System.out.println("4. Salir");
            System.out.println("Opcion: ");
            byte opcion = sc.nextByte();
            sc.next();
            if (opcion == 4){
                System.out.println("Saliendo del programa");
                break;
            }
            switch (opcion){
                case 1:
                    System.out.println("Ingrese el radio del circulo");
                    String radio = sc.nextLine();
                    sc.next();

                    System.out.println(control.interfazCirculo(radio));
                    break;
                case 2:
                    System.out.println("Ingrese el largo del rectangulo");
                    String largo = sc.nextLine();
                    sc.next();

                    System.out.println("Ingrese el ancho del rectangulo");
                    String ancho = sc.nextLine();
                    sc.next();

                    System.out.println(control.interfazRectangulo(largo, ancho));
                    break;
                case 3:
                    System.out.println("Ingrese la base del triangulo");
                    String base = sc.nextLine();
                    sc.next();

                    System.out.println("Ingrese la altura del triangulo");
                    String altura = sc.nextLine();
                    sc.next();

                    System.out.println("Ingrese el lado 1 del triangulo");
                    String l1 = sc.nextLine();
                    sc.next();

                    System.out.println("Ingrese el lado 2 del triangulo");
                    String l2 = sc.nextLine();
                    sc.next();

                    System.out.println("Ingrese el lado 3 del triangulo");
                    String l3 = sc.nextLine();
                    sc.next();

                    System.out.println(control.interfazTriangulo(base, altura, l1, l2, l3));
                default:
                    System.out.println("Opcion no valida. Intente de nuevo");
                    continue;
            }
        }



    }
}
