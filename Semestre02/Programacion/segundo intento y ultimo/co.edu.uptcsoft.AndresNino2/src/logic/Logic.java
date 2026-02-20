package logic;

import model.*;

public class Logic {
    Library library = new Library();

    public void defaulter(){
        Musica musica = new Musica("Una cancion", 2, "Andres");
        Pelicula pelicula = new Pelicula("Una pelicula", 2, "Julian");
        Podcast podcast = new Podcast("Un podcast", 3, "Jesus");
        library.contents.add(musica);
        library.contents.add(pelicula);
        library.contents.add(podcast);
    }
    public String createMovie(String name, int duracion, String director){
        Pelicula pelicula = new Pelicula(name, duracion, director);
        library.contents.add(pelicula);
        return "Ha sido agregado exitosamente, la pelicula titulada: " + pelicula.getTitulo();
    }
    public String createSong(String name, int duracion, String director){
        Musica musica = new Musica(name, duracion, director);
        library.contents.add(musica);
        return "Ha sido agregado exitosamente, la cancion titulada: " + musica.getTitulo();
    }
    public String createPodcast(String name, int duracion, String director){
        Podcast podcast = new Podcast(name, duracion, director);
        library.contents.add(podcast);
        return "Ha sido agregado exitosamente, el podcast titulado: " + podcast.getTitulo();
    }
    public String showContent(){
        StringBuilder st = new StringBuilder();
        int count= 1;
        for (Content c: library.contents){
            st.append("#").append(count).append(". ").append(c.toString()).append("\n");
            count++;
        }
        return st.toString();
    }
    public String descargarContenidos(String name){
        int indexItem = searchItem(name);
        if (indexItem == -1) return "Contenido audiovisual, no encontrado";

        Content content = library.contents.get(indexItem);
        if (content instanceof Downloadable){
            return ((Downloadable) content).descargar();
        }else{
            return "Este contenido, no se puede descargar";
        }
    }
    public int searchItem(String name){
        for (int i = 0; i < library.contents.size(); i++) {
            if (library.contents.get(i).getTitulo().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }
}
