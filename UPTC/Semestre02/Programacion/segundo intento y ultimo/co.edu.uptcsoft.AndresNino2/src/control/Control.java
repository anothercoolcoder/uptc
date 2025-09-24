package control;

import logic.Logic;

public class Control {
    Logic logic = new Logic();
    public void defaulter(){
        logic.defaulter();
    }
    public String showContent(){
        return logic.showContent();
    }
    public String descargarContenidos(String name){
        return logic.descargarContenidos(name);
    }
    public String createMovie(String name, String duration, String director){
        return logic.createMovie(name, Integer.parseInt(duration), director);
    }
    public String createSong(String name, String duration, String cantante){
        return logic.createSong(name, Integer.parseInt(duration), cantante);
    }
    public String createPodcast(String name, String duration, String host){
        return logic.createPodcast(name, Integer.parseInt(duration), host);
    }
}
