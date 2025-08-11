package Logic;

public class Leccion {
    private String titulo;
    private String contenido;
    private int duracion; // en minutos

    public Leccion(String titulo, String contenido, int duracion) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.duracion = duracion;
    }

    public String getTitulo() { return titulo; }
    public String getContenido() { return contenido; }
    public int getDuracion() { return duracion; }
}
