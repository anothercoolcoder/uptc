package Gui;
import Control.Controller;

import java.util.Scanner;
public class GuiPago {
    public void createPago(){
        Controller controller = new Controller();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de la tarjeta");
        String num = sc.nextLine();
        System.out.println("Ingrese el monto");
        String monto = sc.nextLine();
        System.out.println(controller.interfazTarjeta(num, monto));

    }
}
