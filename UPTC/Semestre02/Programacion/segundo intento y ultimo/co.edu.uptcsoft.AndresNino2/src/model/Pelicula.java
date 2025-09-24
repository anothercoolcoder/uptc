package model;

public class Pelicula extends Content{
    public String director;

    public Pelicula(String titulo, double duracion, String director) {
        super(titulo, duracion);
        this.director = director;
    }

    @Override
    public String toString() {
        return  "Titulo: " + titulo +  " \t| " +
                "Duracion: " + duracion + " \t| "+
                "Director: " + director;
    }
}
