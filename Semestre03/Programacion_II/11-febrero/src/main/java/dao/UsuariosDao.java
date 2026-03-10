package dao;

import java.io.FileInputStream;
import java.util.Properties;

public class UsuariosDao {
    Properties pr = new Properties();

    public UsuariosDao(){
        try{
            pr.load(new FileInputStream("File/usuarios.properties"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public boolean validarUsuario(String usuario, String password){
        String clave = pr.getProperty(usuario);
        if (clave != null && clave.equals(password)) {
            return true;
        }
        return false;
    }
}
