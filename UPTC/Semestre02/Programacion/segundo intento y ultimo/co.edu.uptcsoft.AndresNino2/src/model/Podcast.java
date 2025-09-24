package model;

public class Podcast extends Content implements Downloadable{
    public String host;

    public Podcast(String titulo, double duracion, String host) {
        super(titulo, duracion);
        this.host = host;
    }

    @Override
    public String descargar() {
        return titulo + " ha sido descargado";
    }

    @Override
    public String toString() {
        return  "Titulo: " + titulo +  " \t| " +
                "Duracion: " + duracion + " \t| "+
                "Presentador: " + host;
    }
}
