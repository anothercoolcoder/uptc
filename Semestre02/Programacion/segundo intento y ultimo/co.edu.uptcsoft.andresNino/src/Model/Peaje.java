package Model;

import java.util.ArrayList;

public class Peaje {

    public double tarifaG, tarifaP;
    public ArrayList<Puerta> puertas;
    public Peaje(double tarifaG, double tarifaP, int size) {
        this.tarifaG = tarifaG;
        this.tarifaP = tarifaP;
        this.puertas = new ArrayList<>(size);
    }
    public void addDoor(Puerta puerta){
        puertas.add(puerta);
    }
    public String showDoors(){
        return puertas.toString();
    }
    @Override
    public String toString() {
        return  "Tarifa de grandes: $" + tarifaG + "\n"+
                "Tarifa de pequeños: $" + tarifaP +"\n";
    }
}
