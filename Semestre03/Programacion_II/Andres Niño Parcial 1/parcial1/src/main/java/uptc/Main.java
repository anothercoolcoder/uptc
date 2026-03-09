package uptc;

import uptc.dao.PacienteDao;

public class Main {
    public static void main(String[] args) {
        PacienteDao pacienteDao = new PacienteDao("archivos/pacientes.xml");

    }
}