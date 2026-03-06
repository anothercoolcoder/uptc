package uptc.model;

public class PacienteModel {
    int id;
    String nombre;
    int edad;
    String genero;
    String enfermedad;
    String ciudad;
    HistorialMedicoModel hIstorialMedicoModel;

    
    public PacienteModel(int id, String nombre, int edad, String genero, String enfermedad, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.enfermedad = enfermedad;
        this.ciudad = ciudad;
    }
    public PacienteModel(int id, String nombre, int edad, String genero, String enfermedad, String ciudad,
            HistorialMedicoModel hIstorialMedicoModel) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.enfermedad = enfermedad;
        this.ciudad = ciudad;
        this.hIstorialMedicoModel = hIstorialMedicoModel;
    }
    public PacienteModel() {
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
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getEnfermedad() {
        return enfermedad;
    }
    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public HistorialMedicoModel gethIstorialMedicoModel() {
        return hIstorialMedicoModel;
    }
    public void sethIstorialMedicoModel(HistorialMedicoModel hIstorialMedicoModel) {
        this.hIstorialMedicoModel = hIstorialMedicoModel;
    }
    @Override
    public String toString() {
        return "PacienteModel [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", genero=" + genero
                + ", enfermedad=" + enfermedad + ", ciudad=" + ciudad + ", hIstorialMedicoModel=" + hIstorialMedicoModel
                + "]";
    }
    
    
}
