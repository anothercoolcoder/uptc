package Logic;
import Model.Number;
public class Calculator {
    public String posNeg(Number e){
        if (e.getValue() > 0){
            return "El valor "+ e.getValue() +" es positivo";
        }else {
            return "El valor "+ e.getValue() +" es negativo";
        }
    }
}
