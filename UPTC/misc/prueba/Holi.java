import javax.swing.JOptionPane;

public class Holi{
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Ingresa el nombre");
        JOptionPane.showMessageDialog(null,"Nombre: " + name + "!");
    }
}