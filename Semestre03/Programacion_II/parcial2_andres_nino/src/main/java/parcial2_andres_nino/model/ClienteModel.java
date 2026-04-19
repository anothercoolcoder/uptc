package parcial2_andres_nino.model;

public class ClienteModel {
    int id;
    String nombre;
    int edad;
    boolean licencia;
    String password; //contraseña
    //atributos que quiere el negocio
    int prestamos;
    boolean deudas;
    boolean estado;
    public ClienteModel() {
    }
    public ClienteModel(int id, String nombre, int edad, boolean licencia, String password, int prestamos,
            boolean deudas, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.licencia = licencia;
        this.password = password;
        this.prestamos = prestamos;
        this.deudas = deudas;
        this.estado = estado;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public boolean isLicencia() {
        return licencia;
    }
    public void setLicencia(boolean licencia) {
        this.licencia = licencia;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getPrestamos() {
        return prestamos;
    }
    public void setPrestamos(int prestamos) {
        this.prestamos = prestamos;
    }
    public boolean isDeudas() {
        return deudas;
    }
    public void setDeudas(boolean deudas) {
        this.deudas = deudas;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
}
