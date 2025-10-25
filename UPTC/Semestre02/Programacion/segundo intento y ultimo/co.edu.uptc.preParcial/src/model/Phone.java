package model;

public class Phone extends Dispositivo implements Operable{
    public String number, os;
    public int cameras;

    public Phone(String codigo, String marca, String precio, String number, String os, int cameras) {
        super(codigo, marca, precio);
        this.number = number;
        this.os = os;
        this.cameras = cameras;
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
