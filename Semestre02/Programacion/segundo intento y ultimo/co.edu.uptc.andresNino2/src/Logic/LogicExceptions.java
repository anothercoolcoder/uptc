package Logic;

public class LogicExceptions {
    public static class GastoNoEncontradoException extends Exception{
        public GastoNoEncontradoException(String message){super(message);}
    }
    public static class NombreDuplicadoException extends Exception{
        public NombreDuplicadoException(String message){super(message);}
    }
}
