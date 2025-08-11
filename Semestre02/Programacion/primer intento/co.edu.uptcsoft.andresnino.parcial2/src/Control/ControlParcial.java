package Control;

import Logic.Pregunta;

public class ControlParcial {
    public String interfazPregunta(String preg, String respuesta, String r1, String r2, String r3, String r4){
    Pregunta pregunta = new Pregunta(preg, respuesta, r1, r2, r3, r4);
    return String.valueOf(pregunta);
    }
}
