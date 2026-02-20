package Logic;

public class Asiento {
    private int fila;
    private int columna;

    public Asiento(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Asiento)) return false;
        Asiento otro = (Asiento) obj;
        return this.fila == otro.fila && this.columna == otro.columna;
    }

    @Override
    public int hashCode() {
        return fila * 31 + columna;
    }

    @Override
    public String toString() {
        return fila + "-" + columna;
    }
}
