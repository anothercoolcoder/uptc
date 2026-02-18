import view.StudentView;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentView view = new StudentView();
            view.setLocationRelativeTo(null); // center window
            view.setVisible(true);
        });
    }
}