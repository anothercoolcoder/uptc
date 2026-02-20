package LOGIC;

public class Rectangulo extends Figura{
    public double largo, ancho;
    public Rectangulo(double largo, double ancho){
        this.largo = largo;
        this.ancho = ancho;
    }
    @Override
    public double calcularArea() {
        return largo*ancho;
    }

    @Override
    public double calcularPerimetro() {
        return 2*(largo+ancho);
    }
}
