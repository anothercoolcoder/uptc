package Logic;

import java.util.Objects;

public class Estudiante {
    public int codigo;

    public Estudiante(int codigo) {
        this.codigo = codigo;
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Estudiante)) return false;
        Estudiante that = (Estudiante) o;
        return codigo == that.codigo;
    }
    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
