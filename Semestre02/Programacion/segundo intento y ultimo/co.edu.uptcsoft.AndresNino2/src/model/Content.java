package model;

public abstract class Content {
    protected String titulo;
    protected double duracion;

    public Content(String titulo, double duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public abstract String toString();
}
