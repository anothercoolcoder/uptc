package Model;

public class Peaje {

    public double tarifaG, tarifaP;
    public String[] cantidadPuertas;
    public int count;

    public Peaje(double tarifaG, double tarifaP, int Size) {
        this.tarifaG = tarifaG;
        this.tarifaP = tarifaP;
        cantidadPuertas = new String[Size];
    }

    public void addDoor(String puerta){
        if (count <= cantidadPuertas.length){
            cantidadPuertas[count] = puerta;
            count++;
        }
    }

    public double getTarifaG() {
        return tarifaG;
    }

    public void setTarifaG(double tarifaG) {
        this.tarifaG = tarifaG;
    }

    public double getTarifaP() {
        return tarifaP;
    }

    public void setTarifaP(double tarifaP) {
        this.tarifaP = tarifaP;
    }

    public String[] getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(String[] cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String[] showDoors(){
        return cantidadPuertas;
    }
    @Override
    public String toString() {
        return  "Tarifa de grandes: $" + tarifaG + "\n"+
                "Tarifa de pequeños: $" + tarifaP +"\n"+
                "Numero de puertas: " + (cantidadPuertas.length);
    }
}
