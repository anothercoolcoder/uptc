package Logic;

public class Leccion {
    private String titulo;
    private String contenido;
    private int duracion;
    private boolean completada;

    public Leccion(String titulo, String contenido, int duracion) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.duracion = duracion;
        this.completada = false;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public String getTitulo() { return titulo; }
    public String getContenido() { return contenido; }
    public int getDuracion() { return duracion; }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setContenido(String contenido){
        this.contenido = contenido;
    }
    public void setDuracion(int duracion){
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return titulo + " " + contenido + " " + duracion + " min" + (completada ? " ✅" : " ❌");
    }
}
