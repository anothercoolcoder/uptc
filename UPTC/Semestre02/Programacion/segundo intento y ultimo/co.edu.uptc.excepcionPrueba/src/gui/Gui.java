package gui;

import control.Control;
import java.util.Scanner;
import logic.UserExceptions;
public class Gui {
    public static Scanner sc = new Scanner(System.in);
    public static Control control = new Control();
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        System.out.println("Registro de usuarios");
        String name = askName();
        String age = askAge();
        String email = askEmail();
        System.out.println(control.createUser(name, age, email));
    }
    public static void validateName(String name) throws UserExceptions.InvalidNameException{
        if (name == null || name.trim().length()<3){
            throw new UserExceptions.InvalidNameException("El nombre debe tener al menos 3 caracteres");
        }
    }
    public static String askName(){
        String name;
        while (true){
            try{
                System.out.println("Ingrese nombre del usuario");
                name = sc.nextLine();
                validateName(name);
                return name;
            } catch (UserExceptions.InvalidNameException e) {
                System.out.println(e.getMessage());
                System.out.println("Intente de nuevo");
            }
        }
    }
    public static void validateAge(String age) throws UserExceptions.InvalidAgeException{
        int ageP = Integer.parseInt(age);
        if (ageP < 18 || ageP > 120 ){
            throw new UserExceptions.InvalidAgeException("La edad debe estar entre 18 y 120 años");
        }
    }
    public static String askAge(){
        String age;
        while (true){
            try {
                System.out.println("Ingrese su edad");
                age = sc.nextLine();
                validateAge(age);
                return age;
            } catch (UserExceptions.InvalidAgeException e) {
                System.out.println(e.getMessage());
                System.out.println("Intente de nuevo");
            }
        }
    }
    public static void validateEmail(String email) throws UserExceptions.InvalidEmailException{
        if (!email.contains("@")){
            throw new UserExceptions.InvalidEmailException("El email debe contener '@' ");
        }
    }
    public static String askEmail(){
        String email;
        while (true){
            try{
                System.out.println("Ingrese el correo");
                email = sc.nextLine();
                validateEmail(email);
                return email;
            } catch (UserExceptions.InvalidEmailException e) {
                System.out.println(e.getMessage());
                System.out.println("Intente de nuevo");
            }
        }
    }
}
