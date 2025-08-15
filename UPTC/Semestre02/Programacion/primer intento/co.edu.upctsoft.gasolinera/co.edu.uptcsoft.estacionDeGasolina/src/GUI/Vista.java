package GUI;
import LOGICA.Dispensador;
import LOGICA.Vehiculo;

import java.util.Scanner;
public class Vista {
    public void ingresoInfo(){

        Scanner sc = new Scanner(System.in);

        //Solicitando valores -> Dispensador
        System.out.println("Precio del combustible: ");
        int precio = sc.nextInt();
        System.out.println("Cantidad de combustible: (Para el dispensador)");
        int cantidadBodega = sc.nextInt();
        Dispensador disp1 = new Dispensador(cantidadBodega, precio);

        //bienvenida
        System.out.println("Bienvenido usuario");
        System.out.println("El dia de hoy, los precios para el combustible son: $" + precio+ " pesos colombianos (cop) por galon.");

        //valores del vehiculo
        System.out.println("Capacidad del tanque: (En galones)");
        byte cap = sc.nextByte();
        System.out.println("Nivel del tanque: (En galones)");
        byte nivel = sc.nextByte();
        
        while (nivel > cap || nivel < 0){
            System.out.println("El nivel del tanque no puede ser mayor que la capacidad del tanque, intentelo de nuevo: ");
            nivel = sc.nextByte();
        }

        //Creando el vehículo
        Vehiculo veh1 = new Vehiculo(cap, nivel);

        int diferencia = disp1.getDiferencia(veh1);
        disp1.tanqueo(veh1,diferencia);
    }
}

