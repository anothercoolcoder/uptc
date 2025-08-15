package logic;

public interface Accion {
    void nadar();

    default String mensaje(){
        return "Soy un animal";
    }
}
