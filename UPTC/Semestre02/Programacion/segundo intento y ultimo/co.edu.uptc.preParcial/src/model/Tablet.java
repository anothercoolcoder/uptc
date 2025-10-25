package model;

public class Tablet extends Dispositivo implements Operable{
    public double screenSize;
    public boolean sim, stylus;

    public Tablet(String codigo, String marca, String precio, double screenSize, boolean sim, boolean stylus) {
        super(codigo, marca, precio);
        this.screenSize = screenSize;
        this.sim = sim;
        this.stylus = stylus;
    }

    @Override
    public String encender() {
        return "La tablet esta encendiendo, tamaño de pantalla: " + screenSize + " pulgadas";
    }

    @Override
    public String apagar() {
        return "La tablet esta siendo apagada.";
    }

    @Override
    public String toString() {
        return "Tablet -> " +
                "Tamaño de pantalla: " + screenSize + " | " +
                "Disponibilidad de sim: " + sim + " | " +
                "Disponibilidad de lapiz: " + stylus + " | " +
                "Identificador: " + codigo + " | " +
                "Marca: " + marca + " | " +
                "Precio: " + precio;
    }
}
