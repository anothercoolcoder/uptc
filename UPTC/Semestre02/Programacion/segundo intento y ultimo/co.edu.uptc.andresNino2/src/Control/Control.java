package Control;

import Logic.Logic;
import Logic.LogicExceptions;

public class Control {
    Logic logic = new Logic();
    public String createGasto(String nombre, String categoria, String descripcion, String valor){
        return logic.createGasto(nombre, categoria, descripcion, Double.parseDouble(valor));
    }
    public void defaulter(){
        logic.defaulter();
    }
    public String borrarGasto(String nombre) throws LogicExceptions.GastoNoEncontradoException {
        return logic.borrarGasto(nombre);
    }
    public String mostrarGastos(){
        return logic.mostrarGastos();
    }
    public boolean nombreUnico(String nombre)throws LogicExceptions.NombreDuplicadoException {
        return logic.verificarNombreUnico(nombre);
    }
}
