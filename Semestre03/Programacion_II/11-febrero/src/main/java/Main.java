import view.*;
import gui.*;
import data.*;
import dao.*;

public class Main {
      public static void main(String[] args) {
      RedisDataUsers red = new RedisDataUsers();
      red.cargar();
      UsuariosDAO us = new UsuariosDAO();
      EstudiantesDAOMySQL esm = new EstudiantesDAOMySQL();
      System.out.println(esm.listar());

      System.out.println(us.validarUsuario("jorge", "jorgeUPTC"));
      System.out.println(us.validarUsuario("jorge", "asdsadas"));
      PrincipalWindow pw = new PrincipalWindow();
      pw.main();
      }
}
