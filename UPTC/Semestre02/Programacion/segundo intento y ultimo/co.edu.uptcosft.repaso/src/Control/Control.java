package Control;

import Logic.Calculator;
import Model.Number;

public class Control {
    public String receiveNumber(String number){
        Calculator calculator = new Calculator();

        double numberD  = Double.parseDouble(number);

        return calculator.posNeg(new Number(numberD));
    }
}
