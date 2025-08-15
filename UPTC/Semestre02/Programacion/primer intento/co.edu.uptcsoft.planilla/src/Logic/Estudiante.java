package Logic;

import java.util.Arrays;

public class Estudiante {
    public String nombre;
    public double[] notas;

    public Estudiante(String nombre,double[] notas) {
        this.nombre = nombre;
        this.notas = notas;
    }
    public String getNombre() {
        return nombre;
    }
    public double getDefinitiva(){
        double sum = 0;
        for (double nota : notas) {
            sum += nota;
        }

        return sum/notas.length;
    }
    public String getNotas(){
        return Arrays.toString(notas);
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setNota(int index, double nota){
        if(index >= 0 && index < notas.length){
            this.notas[index] = nota;
        }
    }
    public int cantidadNotas(){
        return notas.length;
    }
    @Override
    public String toString() {
        return  nombre + ": " +
                getNotas() +
                "| Nota definitiva: " + String.format("%.2f",getDefinitiva());
    }
}
