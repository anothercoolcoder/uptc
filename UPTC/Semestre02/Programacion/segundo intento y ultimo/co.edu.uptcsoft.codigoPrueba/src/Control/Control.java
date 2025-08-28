package Control;

import Model.Videogame;

public class Control {
    Videogame videogame = new Videogame();

    public String interfaceVideoGame(String name, String genre, String price){
        videogame.setName(name);
        videogame.setGenre(genre);
        videogame.setPrice(Double.parseDouble(price));
        return "El juego "+ videogame.getName() + " ha sido creado exitosamente";
    }

    public String showGame(){
        if (videogame.getName() == null){
            return "No hay videojuegos registrados";
        } else {
            return videogame.toString();
        }
    }
    public String modifyGame(String name, String genre, String price){
        if (videogame.getName() == null){
            return "Primero tienes que crear el videojuego";
        } else {
            videogame.setName(name);
            videogame.setGenre(genre);
            videogame.setPrice(Double.parseDouble(price));
            return  "El nombre ha sido cambiado a:  " + videogame.getName() + '\n' +
                    "El genero ha sido cambiado a:  " + videogame.getGenre() + '\n' +
                    "El precio ha sido cambiado a:  " + videogame.getPrice();
        }
    }
    public boolean alreadyGameOrNot(){
        if (videogame.getName() == null){
            return false;
        } else {
            return true;
        }
    }

    public String showGameName(){
        return videogame.getName();
    }
    public String showGameGenre(){
        return videogame.getGenre();
    }
    public String showGamePrice(){
        return videogame.getPrice();
    }
}
