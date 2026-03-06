package uptc.model;

public class HistorialMedicoModel {
    int idPaciente;
    double altura;
    int peso;
    boolean fumador;
    public HistorialMedicoModel() {
    }
    public HistorialMedicoModel(int idPaciente, double altura, int peso, boolean fumador) {
        this.idPaciente = idPaciente;
        this.altura = altura;
        this.peso = peso;
        this.fumador = fumador;
    }
    public int getIdPaciente() {
        return idPaciente;
    }
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public boolean isFumador() {
        return fumador;
    }
    public void setFumador(boolean fumador) {
        this.fumador = fumador;
    }
    
    
    
}
