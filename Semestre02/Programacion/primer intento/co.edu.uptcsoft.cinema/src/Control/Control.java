package Control;

import Logic.Asiento;
import java.util.HashSet;
import java.util.Set;

public class Control {
    private int filas;
    private int columnas;
    private Set<Asiento> asientosOcupados;

    public Control(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.asientosOcupados = new HashSet<>();
    }

    public boolean asientoValido(int fila, int columna) {
        return fila >= 1 && fila <= filas && columna >= 1 && columna <= columnas;
    }

    public boolean asientoOcupado(int fila, int columna) {
        return asientosOcupados.contains(new Asiento(fila, columna));
    }

    public boolean reservarAsiento(int fila, int columna) {
        Asiento asiento = new Asiento(fila, columna);
        if (asientosOcupados.contains(asiento)) {
            return false;
        } else {
            asientosOcupados.add(asiento);
            return true;
        }
    }
}
