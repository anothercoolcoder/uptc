package LOGIC;

public class Circulo extends Figura {
    public double radio;

    public Circulo(double radio){
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return 0;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

}
