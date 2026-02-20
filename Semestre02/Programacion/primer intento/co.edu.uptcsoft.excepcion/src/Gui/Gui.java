package Gui;

import javax.swing.*;

public class Gui {
    public void vista(){
        boolean tryAgain = true;
        do{
            try{
                String valor = (JOptionPane.showInputDialog(null,"Ingresa un valor entre 0 y 5"));
                double valorD = Double.parseDouble(valor);
                if(valorD >= 0 && valorD <= 5){
                    JOptionPane.showMessageDialog(null, "El valor es correcto = " + valorD);
                    tryAgain = false;
                }
                else if (valorD < 0 || valorD > 5){
                    throw new NumberFormatException("Valor fuera de rango");
                }
            }

            catch (NumberFormatException e1){
                JOptionPane.showMessageDialog(null, "El valor ingresado no se encuentra en el rango");
            }


        } while (tryAgain);
    }
}
