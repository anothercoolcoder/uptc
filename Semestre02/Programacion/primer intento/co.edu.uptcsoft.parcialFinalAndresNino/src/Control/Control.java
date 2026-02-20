package Control;

import Logic.Cadena;

public class Control {
    public String interfazCadena(String valor){
        int valorD = Integer.parseInt(valor);
        Cadena cadena = new Cadena(valorD);
        return String.valueOf(cadena.descomponer(valorD));

    }
}
