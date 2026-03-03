package uptc.controller;

import javax.swing.table.DefaultTableModel;
import uptc.dao.PaisDao;

public class PaisController {

    private PaisDao paisDao;
    private String ruta = "File/persistencia.xml";

    public PaisController() {
        this.paisDao = new PaisDao(ruta);
    }
    
    public void cargarDepartamentosEnTabla(DefaultTableModel modeloTabla, String nombrePaisBuscado) {
        
        modeloTabla.setRowCount(0);
        paisDao.obtenerPaises().stream()
        .filter(p-> p.getNombre().equalsIgnoreCase(nombrePaisBuscado))
        .flatMap(p -> p.getDepartamentos().stream())
        .forEach(depto -> modeloTabla.addRow(new Object[]{depto}));
    }
}