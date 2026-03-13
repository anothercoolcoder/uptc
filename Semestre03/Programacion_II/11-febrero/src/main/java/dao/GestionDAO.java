package dao;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.*;

public class GestionDao {
    private List<Facultad> facultades = new ArrayList<>();
    private List<Carrera> carreras = new ArrayList<>();

    public GestionDao() {
        cargarFacultades();
        cargarCarreras();
        enlazarFacultadesCarreras();
    }

    private void cargarFacultades() {
        try {
            Type t = new TypeToken<List<Facultad>>() {
            }.getType();
            facultades = new Gson().fromJson(new FileReader("File/facultades.json"), t);
        } catch (Exception e) {
            facultades = new ArrayList<>();
        }
    }

    private void cargarCarreras() {
    try {
        Type t = new TypeToken<List<Carrera>>() {}.getType();
        java.io.File archivo = new java.io.File("File/carreras.json");
        
        if (!archivo.exists()) {
            System.err.println("ERROR: No se encuentra el archivo en: " + archivo.getAbsolutePath());
            return;
        }
        
        carreras = new Gson().fromJson(new java.io.FileReader(archivo), t);
        System.out.println("Carreras leídas: " + (carreras != null ? carreras.size() : "null"));
        
    } catch (Exception e) {
        System.err.println("ERROR crítico al procesar el JSON:");
        e.printStackTrace();
    }
}

    private void enlazarFacultadesCarreras() {
        Map<Integer, Facultad> map = new HashMap<>();
        for (Facultad f : facultades) {
            map.put(f.getId(), f);
        }
        for (Carrera c : carreras) {
            Facultad f = map.get(c.getFacultadID());
            if (f != null) {
                f.agregarCarrera(c);
            }
        }
    }

    public List<Facultad> getFacultades() {
        return facultades;
    }

    public List<Carrera> getCarrerasPorFacultad(Facultad f) {
        return f.getCarreras();
    }

    public Carrera getCarreraPorCodigo(int codigo) {
        return carreras.stream()
                .filter(c -> c.getCodigoCarrera() == codigo)

                .findFirst()
                .orElse(null);
    }
}
