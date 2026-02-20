package Logic;

public interface ControlVelocidad {
    default int Acelerar(){
        return 0;
    }
    default int Frenar(){
        return 0;
    }
}
