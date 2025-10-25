package model;

public class Computer extends Dispositivo implements Operable{
    public String os;
    public boolean gpu;
    public int ram;

    public Computer(String codigo, String marca, String precio, String os, boolean gpu, int ram) {
        super(codigo, marca, precio);
        this.os = os;
        this.gpu = gpu;
        this.ram = ram;
    }

    @Override
    public String encender() {
        return "";
    }

    @Override
    public String apagar() {
        return "";
    }
}
