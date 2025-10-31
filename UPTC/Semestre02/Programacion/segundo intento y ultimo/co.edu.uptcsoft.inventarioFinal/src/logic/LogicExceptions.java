package logic;

public class LogicExceptions {
    public static class DuplicateId extends Exception{
        public DuplicateId(String message){super(message);}
    }
}
