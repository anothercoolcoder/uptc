package Logic;

public class Usuario {
    protected String nombre;
    protected String email;
    protected String id;

    public Usuario(String nombre, String email, String id) {
        this.nombre = nombre;
        this.email = email;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Nombre='" + nombre + '\'' +
                ", Correo='" + email + '\'' +
                ", Identificador ='" + id + '\'' +
                '}';
    }
}

