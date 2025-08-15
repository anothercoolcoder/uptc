package LOGIC;

public abstract class Figura {
    public abstract double calcularArea();

    public abstract double calcularPerimetro();

    public void mostrarInformacion(){
        System.out.println("Area " + calcularArea());
        System.out.println("Perimetro " + calcularPerimetro());
    }

}
