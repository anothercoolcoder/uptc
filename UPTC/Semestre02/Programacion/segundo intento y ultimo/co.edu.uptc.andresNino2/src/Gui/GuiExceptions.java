package Gui;

public class GuiExceptions {

    public static class InvalidNameException extends Exception{
        public InvalidNameException(String message){
            super(message);
        }
    }
    public static class InvalidadGastoException extends Exception{
        public InvalidadGastoException(String message){super(message);}
    }

}
