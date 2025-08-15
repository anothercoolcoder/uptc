package CONTROL;

import LOGIC.Circulo;
import LOGIC.Rectangulo;
import LOGIC.Triangulo;

public class ControlFigura {
    public String interfazTriangulo(String base, String altura, String l1, String l2, String l3){
    double baseD = Double.parseDouble(base);
    double alturaD = Double.parseDouble(altura);
    double l1D = Double.parseDouble(l1);
    double l2D = Double.parseDouble(l2);
    double l3D = Double.parseDouble(l3);

    Triangulo triangulo = new Triangulo(baseD, alturaD, l1D, l2D, l3D);
    return String.valueOf(triangulo);
    }

    public String interfazCirculo(String radio){
        double radioD = Double.parseDouble(radio);

        Circulo circulo = new Circulo(radioD);
        return String.valueOf(circulo);
    }

    public String interfazRectangulo(String largo, String ancho){
        double largoD = Double.parseDouble(largo);
        double anchoD = Double.parseDouble(ancho);

        Rectangulo rectangulo = new Rectangulo(largoD, anchoD);
        return String.valueOf(rectangulo);
    }
}
