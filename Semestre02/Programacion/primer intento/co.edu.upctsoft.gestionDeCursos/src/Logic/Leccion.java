package Logic;

public class Leccion {
    private String titulo, contenido;
    private int duracion;

    public Leccion(String titulo, String contenido, int duracion) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Leccion{" +
                "titulo='" + titulo + '\'' +
                ", contenido='" + contenido + '\'' +
                ", duracion=" + duracion + "min"+
                '}';
    }
}
