package logic;

public class Profesor {
    private String nom, cod,curso;

    public Profesor(String nom, String cod, String curso) {
        this.nom = nom;
        this.cod = cod;
        this.curso = curso;
    }

    public Profesor(String nom, String cod) {
        this.nom = nom;
        this.cod = cod;
        this.curso = "No tiene asignado curso";
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nom='" + nom + '\'' +
                ", cod='" + cod + '\'' +
                ", curso='" + curso + '\'' +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
