package LOGICA;

public class Usuario {
    private String nombre, direccion, eps, telefono, vacuna;
    private byte edad;
    private boolean carnet;

    public Usuario(String nombre1, String direccion1, String eps1, String telefono1, byte edad1) {
        setNombre(nombre1);
        setDireccion(direccion1);
        setEdad(edad1);
        setEps(eps1);
        setTelefono(telefono1);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", eps='" + eps + '\'' +
                ", telefono='" + telefono + '\'' +
                ", vacuna='" + vacuna + '\'' +
                ", edad=" + edad +
                ", carnet=" + carnet +
                '}';
    }
}
