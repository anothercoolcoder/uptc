package model;

public class Musica extends Content implements Downloadable{
    public String artista;

    public Musica(String titulo, double duracion, String artista) {
        super(titulo, duracion);
        this.artista = artista;
    }

    @Override
    public String descargar() {
        return titulo + " ha sido descargada";
    }

    @Override
    public String toString() {
        return  "Titulo: " + titulo +  " \t| " +
                "Duracion: " + duracion + " \t| "+
                "Artista: " + artista;
    }
}
