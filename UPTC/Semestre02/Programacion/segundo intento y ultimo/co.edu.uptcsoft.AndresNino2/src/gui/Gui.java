package gui;

import control.Control;

import java.util.Scanner;

public class Gui {
    static Control control = new Control();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        control.defaulter();
        menu();
    }
    public static void menu(){
        System.out.println("Bienvenido");
        String value;
        do {
            System.out.println("1. Mostrar contenidos digitales");
            System.out.println("2. Descargar contenidos");
            System.out.println("3. Crear contenidos");
            System.out.println("4. Salir");

            value = sc.nextLine();
            switch (value){
                case "1" -> showContents();
                case "2" -> descargarContenidos();
                case "3" -> crearContenidos();
                case "4" -> System.out.println("Saliendo...");
                default -> System.out.println("Valor invalido");
            }

        }while (!value.equals("4"));

    }
    public static void showContents(){
        System.out.println(control.showContent());
    }
    public static void descargarContenidos(){
        showContents();
        System.out.println("Escribe el titulo de lo que deseas descargar");
        String name = sc.nextLine();
        System.out.println(control.descargarContenidos(name));
    }
    public static void crearContenidos(){
        String value;
        do {
            System.out.println("1. Crear pelicula");
            System.out.println("2. Crear podcast");
            System.out.println("3. Crear cancion");
            System.out.println("4. Salir");

            value = sc.nextLine();
            switch (value){
                case "1" -> createMovie();
                case "2" -> createPodcast();
                case "3" -> createSong();
                case "4" -> System.out.println("Saliendo...");
                default -> System.out.println("Valor invalido");
            }

        }while (!value.equals("4"));

    }
    public static void createMovie(){
        System.out.println("Escriba el nombre de la pelicula");
        String name = sc.nextLine();
        System.out.println("Escriba la duracion de la pelicula (en numeros enteros)");
        String duration = sc.nextLine();
        System.out.println("Escriba el nombre del director");
        String director = sc.nextLine();
        System.out.println(control.createMovie(name, duration, director));
    }
    public static void createSong(){
        System.out.println("Escriba el nombre de la cancion");
        String name = sc.nextLine();
        System.out.println("Escriba la duracion de la cancion (en numeros enteros)");
        String duration = sc.nextLine();
        System.out.println("Escriba el nombre del cantante");
        String director = sc.nextLine();
        System.out.println(control.createSong(name, duration, director));
    }
    public static void createPodcast(){
        System.out.println("Escriba el nombre del podcast");
        String name = sc.nextLine();
        System.out.println("Escriba la duracion del podcast (en numeros enteros)");
        String duration = sc.nextLine();
        System.out.println("Escriba el nombre del host");
        String director = sc.nextLine();
        System.out.println(control.createPodcast(name, duration, director));
    }
}
