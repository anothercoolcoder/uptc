package Logic;

public class Pregunta {
    public String pregunta, respuesta, r1, r2, r3, r4,rUsuario;

    public Pregunta(String pregunta, String respuesta, String r1, String r2, String r3, String r4) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.r4 = r4;
    }
    @Override
    public String toString() {
        return
                "Pregunta = " + pregunta +
                ", a = " + r1 +
                ", b = " + r2 +
                ", c = " + r3 +
                ", d = " + r4;
    }
}
