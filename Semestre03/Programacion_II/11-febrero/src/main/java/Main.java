import view.*;
import gui.*;
import data.*;
import dao.*;

public class Main {
      public static void main(String[] args) {
            Data.cargar();
            PrincipalWindow principal = new PrincipalWindow();
            principal.main();
      }
}
