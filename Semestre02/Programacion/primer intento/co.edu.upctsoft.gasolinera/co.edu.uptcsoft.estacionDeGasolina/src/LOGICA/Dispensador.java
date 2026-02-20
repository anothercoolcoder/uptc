package LOGICA;

import java.util.Scanner;

public class Dispensador {
    private int capacidadBodega, valor, ventaG, ventaP;

    public Dispensador(int capacidadBodega, int valor, int ventaG, int ventaP) {
        this.capacidadBodega = capacidadBodega;
        this.valor = valor;
        this.ventaG = ventaG;
        this.ventaP = ventaP;
    }

    public Dispensador(int capacidadBodega, int valor){

    }

    public int getCapacidadBodega() {
        return capacidadBodega;
    }

    public void setCapacidadBodega(int capacidadBodega) {
        this.capacidadBodega = capacidadBodega;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getVentaG() {
        return ventaG;
    }

    public void setVentaG(int ventaG) {
        this.ventaG = ventaG;
    }

    public int getVentaP() {
        return ventaP;
    }

    public void setVentaP(int ventaP) {
        this.ventaP = ventaP;
    }

    public static int getDiferencia(Vehiculo veh1) {
        int diferencia = veh1.getCapacidad() - veh1.getNivel();
        System.out.print("la diferencia entre el nivel del combustible y la capacidad total, es " + diferencia);
        return diferencia;
    }

    public void tanqueo(Vehiculo vehiculo, int diferencia){
        System.out.println("¿Como desea tanquear su vehiculo?");
        System.out.println("1. Lleno");
        System.out.println("2. Parcial.");
        Scanner sc = new Scanner(System.in);
        byte tanqueo = sc.nextByte();

        if (tanqueo == 1){
            vehiculo.setNivel(vehiculo.getCapacidad());
            System.out.println("El vehiculo se ha tanqueado completamente, thx");
        }else{
            System.out.println("¿Cuanto desea llenar?");
            int tanqueoParcial = sc.nextByte();
            while (tanqueoParcial >= diferencia || tanqueoParcial < 0){
                System.out.println("El valor tiene que ser menor a la diferencia total, porque sino seria un tanqueo total y no puede ser cero ni negativo.");
                tanqueoParcial = sc.nextByte();

            }

            byte valorFinal = (byte) (tanqueoParcial + vehiculo.getNivel());
            vehiculo.setNivel(valorFinal);
            System.out.println("El nivel de su tanque es: " + vehiculo.getNivel());

            //actualizar bodega
            this.capacidadBodega = this.getCapacidadBodega() - tanqueoParcial;
            System.out.println("Quedan " + this.getCapacidadBodega() + " Galones en bodega.");
        }
    }
}