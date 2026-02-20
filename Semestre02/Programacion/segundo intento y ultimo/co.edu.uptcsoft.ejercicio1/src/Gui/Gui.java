package Gui;

import Control.Control;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Gui {
    private Scanner sc = new Scanner(System.in);
    Control control = new Control();
    int numberGrades = 0;
    int numberStudents = 0;
    double maxGrade = 0;
    double minGrade = 0;

    public void menu(){
        System.out.println("Bienvenido");
        askNumberGrades();
        askMaxGrade();
        askMinGrade();
        askSize();
    }
    public void askSize(){
        boolean tryAgain = true;

        do {
            try{
                System.out.println("¿Cuantos estudiantes quieres registrar?");
                numberStudents = sc.nextInt();
                sc.nextLine();
                if (numberStudents>=1){
                    System.out.println("El valor es valido");
                    tryAgain = false;
                } else if (numberStudents<0) {
                    System.out.println("Valor invalido");
                }

            } catch (NumberFormatException e) {
                System.out.println("El valor debe ser un numero entero");
            }
        } while (tryAgain);
        for (int i = 0; i < numberStudents; i++) {
            createStudent(i+1);
        }
    }
    public void askNumberGrades(){
        System.out.println("¿Cuantas notas tendra cada estudiante?");
        numberGrades = sc.nextInt();

    }
    public void createStudent(int i){
        System.out.println("Ingresa un nombre para el estudiante # " + i);
        String name = sc.nextLine();

        String[] grades = new String[numberGrades];
        for (int j = 0; j < numberGrades; j++) {
            grades[j] = askGrades(j);
        }

        System.out.println(control.interfaceStudent(name, grades));
    }
    public String askGrades(int i){
        double grade = 0;
        boolean tryAgain = true;

        do {
            try{
                System.out.println("Ingrese la nota #"+ (i+1));
                grade = sc.nextDouble();
                if (grade>=minGrade && grade <= maxGrade){
                    tryAgain = false;
                } else {
                    throw new IllegalArgumentException("La nota debe estar entre " + minGrade + " y " + maxGrade);
                }

            } catch (InputMismatchException e) {
                System.out.println("Debe ser un numero decimal");
                sc.next();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (tryAgain);
        return String.valueOf(grade);
    }
    public void askMaxGrade(){
        System.out.println("¿Cual sera la nota maxima?");
        maxGrade = sc.nextDouble();
    }
    public void askMinGrade(){
        System.out.println("¿Cual sera la nota  minima?");
        minGrade = sc.nextDouble();
    }


}
