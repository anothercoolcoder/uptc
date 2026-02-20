package gui;

import control.Control;

import java.util.Scanner;

public class Gui {
    public static Scanner scanner = new Scanner(System.in);
    public static Control control = new Control();
    public static void main(String[] args) {
        control.defaulter();
        menu();
    }
    public static void menu(){
        String value;
        do{
            System.out.println("Seleccione una opcion");
            System.out.println("1. Crear empleado");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Salir");
            value = scanner.nextLine();
            switch (value){
                case "1": createEmployee();break;
                case "2": showNomine();break;
                case "3":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("El valor es invalido");
                    break;
            }
        }while (!value.equals("3"));
    }
    public static void createEmployee(){
        String value;
        do{
            System.out.println("Seleccione una opcione");
            System.out.println("1. Empleado por horas");
            System.out.println("2. Empleado permanente");
            System.out.println("3. Salir...");
            value = scanner.nextLine();
            switch (value){
                case "1":createPermanetEmployee();break;
                case "2":createHourlyEmployee();break;
                case "3":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Valor invalido");
                    break;
            }
        }while (!value.equals("3"));

    }
    public static void showNomine(){
        System.out.println(control.showNomine());
    }
    public static void createPermanetEmployee(){
        System.out.println("Escriba el nombre");
        String name = scanner.nextLine();
        System.out.println("Escriba el id");
        String id = scanner.nextLine();
        System.out.println("Escriba salario del mes");
        String baseSalary = scanner.nextLine();
        System.out.println("Escriba cantidad de dias trabajados");
        String workedDays = scanner.nextLine();
        System.out.println("Escriba cantidad de horas extras ");
        String lateHours = scanner.nextLine();
        System.out.println("Escriba cantidad de horas nocturnas");
        String nigthHours = scanner.nextLine();
        System.out.println("Escriba cantidad de horas dominicales");
        String sundayHours = scanner.nextLine();

        System.out.println(control.createPermanentEmployee(name, id, baseSalary, workedDays,lateHours,nigthHours,sundayHours));
    }
    public static void createHourlyEmployee(){
        System.out.println("Escriba el nombre");
        String name = scanner.nextLine();
        System.out.println("Escriba el id");
        String id = scanner.nextLine();
        System.out.println("Escriba tarifa hora");
        String tarifeHour = scanner.nextLine();
        System.out.println("Escriba cantidad de horas trabajados");
        String workedHours = scanner.nextLine();
        System.out.println("Escriba cantidad de horas extras ");
        String lateHours = scanner.nextLine();
        System.out.println("Escriba cantidad de horas nocturnas");
        String nigthHours = scanner.nextLine();
        System.out.println("Escriba cantidad de horas dominicales");
        String sundayHours = scanner.nextLine();
        System.out.println(control.createHourlyEmployee(name, id, tarifeHour,workedHours,lateHours,nigthHours,sundayHours));
    }
}
