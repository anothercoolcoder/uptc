package Model;

import java.text.DecimalFormat;

public class Gasto {
    public String nombre, categoria, descripcion;
    public double valor;
    DecimalFormat df = new DecimalFormat("$#,###.00");
    public Gasto(String nombre, String categoria, String descripcion, double valor) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return  "Nombre: " + nombre + " | " +
                "Categoria: " + categoria + " | " +
                "Descripcion: " + descripcion + " | " +
                "Valor: " + df.format(getValor());
    }
}
