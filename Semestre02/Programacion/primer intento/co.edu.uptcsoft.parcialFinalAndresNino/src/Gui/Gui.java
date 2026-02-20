package Gui;
import Control.Control;
import javax.swing.*;

public class Gui {
    Control control = new Control();

    public void vista(){
        String input = askNumber();
        JOptionPane.showMessageDialog(null,control.interfazCadena(input));
    }
    public String askNumber(){
        String input = null;
        while (true){
            try{
                input = JOptionPane.showInputDialog(null, "Escribe un numero");
                return input;
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Tiene que ser un valor numerico entero");
            }
        }
    }
}
