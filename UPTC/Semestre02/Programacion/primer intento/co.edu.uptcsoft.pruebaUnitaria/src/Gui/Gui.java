package Gui;

import static Logic.LoginApp.login;

public class Gui {
    public void vista(){

        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.print("Usuario: ");
        String user = scanner.nextLine();

        System.out.print("Contraseña: ");
        String pass = scanner.nextLine();

        if (login(user, pass)) {
            System.out.println("Correcto.");
        } else {
            System.out.println("Incorrecto.");
        }

        scanner.close();
    }
}
