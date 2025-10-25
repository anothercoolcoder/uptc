package logic;

import logic.LogicExceptions.DispositivoNoEncontradoException;
import logic.LogicExceptions.CodigoDuplicadoException;
import model.Computer;
import model.Dispositivo;
import model.Tablet;
import model.Phone;

import java.util.ArrayList;

public class Logic {

    private ArrayList<Dispositivo> dispositivos = new ArrayList<>();

    // Carga inicial por defecto
    public void defaulter() {
        dispositivos.add(new Tablet("1", "Samsung", "12000", 12, true, false));
        dispositivos.add(new Tablet("2", "Samsung", "12000", 12, true, false));
    }

    // Crear y añadir dispositivos
    public String tablet(String codigo, String marca, String precio, double screenSize, boolean sim, boolean stylus)
            throws CodigoDuplicadoException {
        verificarCodigoUnico(codigo);
        dispositivos.add(new Tablet(codigo, marca, precio, screenSize, sim, stylus));
        return "✅ La tablet ha sido creada y añadida exitosamente.";
    }

    public String phone(String codigo, String marca, String precio, String number, String os, int cameras)
            throws CodigoDuplicadoException {
        verificarCodigoUnico(codigo);
        dispositivos.add(new Phone(codigo, marca, precio, number, os, cameras));
        return "✅ El teléfono ha sido creado y añadido exitosamente.";
    }

    public String computer(String codigo, String marca, String precio, String os, int ram, boolean gpu)
            throws CodigoDuplicadoException {
        verificarCodigoUnico(codigo);
        dispositivos.add(new Computer(codigo, marca, precio, os, gpu, ram));
        return "✅ La computadora ha sido creada y añadida exitosamente.";
    }

    // Buscar dispositivo
    public Dispositivo searchDeviceObject(String codigo) throws DispositivoNoEncontradoException {
        for (Dispositivo d : dispositivos) {
            if (d.getCodigo().equals(codigo)) {
                return d;
            }
        }
        throw new DispositivoNoEncontradoException(codigo);
    }

    public String searchDevice(String codigo) throws DispositivoNoEncontradoException {
        return searchDeviceObject(codigo).toString();
    }

    // Eliminar dispositivo
    public String deleteDevice(String codigo) throws DispositivoNoEncontradoException {
        Dispositivo dispositivo = searchDeviceObject(codigo);
        dispositivos.remove(dispositivo);
        return "🗑️ El dispositivo con código " + codigo + " ha sido borrado exitosamente.";
    }

    // Mostrar todos
    public String showDevices() {
        if (dispositivos.isEmpty()) {
            return "No hay dispositivos registrados actualmente.";
        }
        StringBuilder st = new StringBuilder("📋 Lista de dispositivos:\n");
        int index = 1;
        for (Dispositivo d : dispositivos) {
            st.append(index++).append(". ").append(d.toString()).append("\n");
        }
        return st.toString();
    }

    // Validar código duplicado antes de agregar
    private void verificarCodigoUnico(String codigo) throws CodigoDuplicadoException {
        for (Dispositivo d : dispositivos) {
            if (d.getCodigo().equals(codigo)) {
                throw new CodigoDuplicadoException(codigo);
            }
        }
    }
}
