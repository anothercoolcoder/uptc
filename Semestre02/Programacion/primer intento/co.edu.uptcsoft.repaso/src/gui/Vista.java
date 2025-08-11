package gui;

import logic.Estudiante;
import logic.Profesor;

import java.util.Scanner;

public class Vista {
public int a;
    public void igresoInfo(){

        Estudiante est1 = new Estudiante();
        System.out.println("El nombre es:  "+ est1.getNombre());
        System.out.println("El nombre es:  "+ est1.getCodigo());
        est1.setNombre("Maria");
        est1.setCodigo("12345");
        System.out.println("El nombre es:  "+ est1.getNombre());
        System.out.println("El nombre es:  "+ est1.getCodigo());
        Estudiante est2 = new Estudiante("Juan","54321");
        System.out.println("El nombre es:  "+ est2.getNombre());
        System.out.println("El nombre es:  "+ est2.getCodigo());
        System.out.println("El nombre es:  "+ est2.toString());
        System.out.println("El nombre es:  "+ est1.toString());
        Estudiante est3 = new Estudiante("David","98765");
        System.out.println("Por favor digite su nombre");
        Scanner sc = new Scanner(System.in);
        String nom = sc.next();
        System.out.println("Por favor digite su código");
        String cod = sc.next();
        Estudiante est4 = new Estudiante(nom,cod);
        System.out.println("El nombre es:  "+ est4.toString());
        est4.setNombre("Vicente");
        est4.setCodigo("12345678");
        System.out.println("El nombre es:  "+ est4.toString());

        Profesor prof1 = new Profesor("Vidal","1234");
        System.out.println(prof1.toString());
        prof1.setCurso("Prog I");
        System.out.println(prof1.toString());






    }
}
