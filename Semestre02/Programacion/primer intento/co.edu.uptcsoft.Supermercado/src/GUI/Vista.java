package GUI;

import Controller.Control;
import java.util.Scanner;

public class Vista{
    Control co = new Control();
    Scanner sc = new Scanner(System.in);

    public void vl() {
        String[][] productos = co.produtos();
        String proSelec, cantProducto;
        String op1, op2;
        int pSeleccion = 0;

        String menu = "\tBienvenido a su Supermercado de confianza"
                        + "\n A continuacion vera la lista de los productos actuales \n";
                // lista de los productos
                for (int i = 0; i < productos.length; i++) {
                    productos[i][0] = (i + 1) + ". " + productos[i][0];
                    productos[i][1] = "$" + productos[i][1];
                    for (int j = 0; j < productos[i].length; j++) {
                        menu += (productos[i][j] + " ");
                    }
                    menu += (" ");
                }

        // segundo bucle para mostrar facturas
        do {
            // primer bucle para saber si quiere añadir el producto con cantidad

            do {
                //imprimir menu
                System.out.println(menu);
                // seleccion de producto
                System.out.println("Ingrese el numero del producto que desea comprar");
                proSelec = sc.nextLine();
                System.out.println("Ingrese la opcion al implementar"
                        + "\n1.Seleccionar la cantidad del producto seleccionado \n2.No añadir el producto seleccionado y volver al menu");
                op1 = sc.nextLine();
            } while (op1 =="2");

            // sale del bucle y pregunta la cantidad
            System.out.println("Ingrese la cantidad del producto");
            cantProducto = sc.nextLine();
            // llama a carrito
            pSeleccion++;
            System.out.println(co.mCarrito(proSelec, cantProducto,pSeleccion));
            System.out.println("Ingrese la opcion al implementar"
                    + "\n1.Añadir producto \n2.Imprimir factura y pagar");
            op2 = sc.nextLine();
        } while (op2.equals("1"));
        // llama a carrito para pagar
        System.out.println(co.mostrarFactura());

    }
}
