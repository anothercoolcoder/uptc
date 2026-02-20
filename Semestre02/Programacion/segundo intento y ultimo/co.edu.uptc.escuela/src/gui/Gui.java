package gui;

import model.Cuadrado;
import model.Figura;
import model.Triangle;

public class Gui {
    public static void main(String[] args) {
        Figura figura = new Cuadrado();
        figura.calcFigura();
        Figura figura1 = new Triangle();
        figura.calcFigura();
        System.out.println(figura instanceof Figura);
    }
}
