package Gui;

import Control.Control;

import java.util.Scanner;

public class Gui {
    static Scanner scanner = new Scanner(System.in);
    static Control control = new Control();

    public static void main(String[] args) {
        String value;
        do {
            System.out.println("Menu videojuego");
            System.out.println("1. Crear videojuego");
            System.out.println("2. Mostrar videojuego");
            System.out.println("3. Modificar videojuego");
            System.out.println("4. Salir");
            value = scanner.nextLine();
            switch (Integer.parseInt(value)){
                case 1:
                    createVideoGame();
                    break;
                case 2:
                    showVideoGame();
                    break;
                case 3:
                    modifyVideoGame();
                    break;
                case 4:
                    exit();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (Integer.parseInt(value) != 4);

    }
    public static void createVideoGame(){
        if(control.alreadyGameOrNot() == false){
            System.out.println("Escriba el nombre del juego");
            String name = scanner.nextLine();
            System.out.println("Escriba el genero del juego");
            String genre = scanner.nextLine();
            System.out.println("Ingrese el precio del juego");
            String price = scanner.nextLine();
            System.out.println(control.interfaceVideoGame(name, genre, price));
        }else{
            System.out.println("Ya existe un juego, no puedes crear otro.");
        }

    }
    public static void showVideoGame(){
        System.out.println(control.showGame());
    }
    public static void modifyVideoGame(){
        if(control.alreadyGameOrNot() == true){
            System.out.println("Modificar juego");
            System.out.print("Nuevo nombre (actual: " + control.showGameName() + "): ");
            String name = scanner.nextLine();

            System.out.print("Nuevo género (actual: " + control.showGameGenre() + "): ");
            String genre = scanner.nextLine();

            System.out.print("Nuevo precio (actual: $" + control.showGamePrice() + "): ");
            String price = scanner.nextLine();

            System.out.println(control.modifyGame(name, genre, price));
        } else{
            System.out.println("No hay juegos registrados");
        }

    }
    public static void exit(){
        System.out.println("Saliendo del programa...");
    }
}
