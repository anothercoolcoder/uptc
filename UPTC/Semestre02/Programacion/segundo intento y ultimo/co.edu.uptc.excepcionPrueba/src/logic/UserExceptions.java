package logic;

public class UserExceptions{

    public static class InvalidNameException extends Exception{
        public InvalidNameException(String message){
            super(message);
        }
    }
    public static class InvalidAgeException extends Exception{
        public InvalidAgeException(String message){
            super(message);
        }
    }
    public static class InvalidEmailException extends Exception{
        public InvalidEmailException(String message){
            super(message);
        }
    }
}
