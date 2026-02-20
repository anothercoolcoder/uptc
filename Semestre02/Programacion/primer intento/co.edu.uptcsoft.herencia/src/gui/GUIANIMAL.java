package gui;
import control.ControllerAnimal;
import java.util.Scanner;
public class GUIANIMAL {
    ControllerAnimal control = new ControllerAnimal();
    Scanner sc = new Scanner(System.in);
    public void createAnimal(){

        System.out.println("Digite el nombre");
        String nom = sc.nextLine();
        System.out.println("Digite la comida");
        String com = sc.nextLine();
        System.out.println("Digite la edad");
        String eda = sc.nextLine();
        System.out.println("Digite la raza");
        String raza = sc.nextLine();

        System.out.println(control.interfazDog(nom, com, eda, raza));

    }

}
