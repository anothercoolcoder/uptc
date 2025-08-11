package Logic;

public abstract class Usuario {
    protected String nombre;
    protected String email;
    protected String id;

    public Usuario(String nombre, String email, String id) {
        this.nombre = nombre;
        this.email = email;
        this.id = id;
    }

    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getId() { return id; }
    public abstract String getTipoUsuario();
}
