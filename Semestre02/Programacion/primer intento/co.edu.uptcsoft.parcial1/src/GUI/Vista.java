package GUI;
import LOGICA.Eps;
import LOGICA.Usuario;

import java.util.Scanner;
public class Vista {
    public void ingreso () {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese su nombre");
        String nombre1 = sc.nextLine();

        System.out.println("Ingrese su direccion");
        String direccion1 = sc.nextLine();

        System.out.println("Ingrese su eps");
        String eps1 = sc.nextLine();

        System.out.println("Ingrese su telefono");
        String telefono1 = sc.nextLine();

        System.out.println("Ingrese su edad");
        byte edad1 = sc.nextByte();

        Usuario usuario1 = new Usuario(nombre1, direccion1, eps1, telefono1, edad1);
        System.out.println("El usuario tiene carnet de vacunacion " + usuario1.toString());
        Eps eps = new Eps();

    }
}

