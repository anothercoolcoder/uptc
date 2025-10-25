package Logic;

import Model.Gasto;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Logic {
    ArrayList<Gasto> gastos = new ArrayList<>();
    DecimalFormat df = new DecimalFormat("$#,###.00");

    public void defaulter(){
        Gasto gasto1 = new Gasto("Pizza", "Comida", "Pizza de pollo", 2500); gastos.add(gasto1);
        Gasto transmi = new Gasto("Trasnmilenio", "Transporte", "Usme a Patio bonito", 3000); gastos.add(transmi);
    }
    public String createGasto(String nombre, String categoria, String descripcion, double valor){
        Gasto gasto = new Gasto(nombre, categoria, descripcion, valor);
        gastos.add(gasto);
        return "Ha sido creado exitosamente";
    }
    public Gasto buscarGastoObjeto(String codigo)throws LogicExceptions.GastoNoEncontradoException{
        for (Gasto g: gastos){
            if (g.getNombre().equalsIgnoreCase(codigo)){
                return g;
            }
        }
        throw new LogicExceptions.GastoNoEncontradoException(codigo);
    }
    public String borrarGasto(String codigo) {
        try{
            Gasto gasto = buscarGastoObjeto(codigo);
            gastos.remove(gasto);
            return "Ha sido removido exitosamente";
        } catch (LogicExceptions.GastoNoEncontradoException e) {
            return "Gasto no encontrado, vuelva a intentar";
        }

    }
    public String mostrarGastos() {
        if (gastos.isEmpty()) {
            return "No hay gastos registrados actualmente.";
        }
        StringBuilder st = new StringBuilder(" Lista de gastos:\n");
        int index = 1;
        double gastosTotal = 0;
        for (Gasto d : gastos) {
            st.append(index++).append(". ").append(d.toString()).append("\n");
            gastosTotal += (d.getValor());
        }
        st.append("\n").append("El total de tus gastos es: ").append(df.format(gastosTotal)).append("\n");
        return st.toString();
    }
    public boolean verificarNombreUnico(String nombre){
        try{
            for (Gasto d : gastos) {
                if (d.getNombre().equals(nombre)) {
                    throw new LogicExceptions.NombreDuplicadoException(nombre);
                }
            }
        } catch (LogicExceptions.NombreDuplicadoException e) {
            return true;
        }
        return false;
    }

}
