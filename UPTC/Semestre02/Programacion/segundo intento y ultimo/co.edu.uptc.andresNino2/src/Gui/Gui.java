package Gui;

import Control.Control;
import Logic.LogicExceptions;

import java.util.Scanner;

public class Gui {
    public static Control control = new Control();
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        control.defaulter();
        menu();
    }
    public static void menu(){
        String value;
        while (true){
            System.out.println("Bienvenido a tu sistema de gastos");
            System.out.println("1. Registrar nuevo gasto");
            System.out.println("2. Mostrar gastos");
            System.out.println("3. Borrar un gasto");
            System.out.println("4. Salir");
            value = sc.nextLine();
            switch (value){
                case "1" -> registroGastos();
                case "2" -> mostrarGastos();
                case "3" -> borrarGasto();
                case "4" -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default -> System.out.println("Opcion no valida");
            }
        }
    }
    public static void registroGastos(){
        System.out.println("Registro de gastos");
        String nombre = askNombre();
        System.out.println("Escriba una categoria");
        String categoria = sc.nextLine();
        System.out.println("Escriba una descripcion");
        String descripcion = sc.nextLine();
        String valor = askValor();
        System.out.println(control.createGasto(nombre, categoria, descripcion, valor));
    }
    public static void nombreUnico(String nombre)throws LogicExceptions.NombreDuplicadoException {
        if (control.nombreUnico(nombre)){
            throw new LogicExceptions.NombreDuplicadoException("El nombre ya esta tomado");
        }
    }
    public static String askNombre(){
        String name;
        while (true){
            try{
                System.out.println("Ingrese nombre del gasto");
                name = sc.nextLine();
                nombreUnico(name);
                return name;
            } catch (LogicExceptions.NombreDuplicadoException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void validateGasto(String gasto)throws Exception{
        Double gastoD;
        try{
            gastoD = Double.parseDouble(gasto);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        if (gastoD < 0){
            throw new GuiExceptions.InvalidadGastoException("El valor del gasto tiene que ser positivo");
        }
    }
    public static String askValor(){
        String gasto;
        while (true){
            try{
                System.out.println("Ingrese el valor del gasto");
                gasto = sc.nextLine();
                validateGasto(gasto);
                return gasto;
            }catch (GuiExceptions.InvalidadGastoException e){
                System.out.println(e.getMessage());
                System.out.println("Intente de nuevo");
            } catch (Exception e) {
                System.out.println("El valor tiene que ser numerico");
            }
        }
    }
    public static void borrarGasto(){
        String nombre;
        while (true){
            try{
                System.out.println("Escriba el nombre del gasto que desea borrar");
                nombre = sc.nextLine();
                System.out.println(control.borrarGasto(nombre));
                break;
            } catch (LogicExceptions.GastoNoEncontradoException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void mostrarGastos(){
        System.out.println(control.mostrarGastos());
    }

}
