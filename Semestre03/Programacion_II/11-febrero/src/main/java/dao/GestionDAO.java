package dao;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;


import model.Carrera;
import model.Facultad;
import java.util.List;
import java.util.Map;
import java.io.FileReader;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class GestionDAO {
	 private List<Facultad> facultades = new ArrayList<>();
	    private List<Carrera> carreras = new ArrayList<>();


	    public GestionDAO() {
	        cargarFacultades();
	        cargarCarreras();
	        enlazarFacultadesCarreras();
	    }


	    private void cargarFacultades() {
    try {
        Type t = new TypeToken<List<Facultad>>(){}.getType();
        // Asegúrate de que la ruta "Archivos/facultades.json" sea la correcta
        List<Facultad> listaCargada = new Gson().fromJson(new FileReader("File/facultades.json"), t);
        this.facultades = (listaCargada != null) ? listaCargada : new ArrayList<>();
    } catch (Exception e) {
        this.facultades = new ArrayList<>();
        e.printStackTrace();
    }
}

private void cargarCarreras() {
    try {
        // Usamos la misma carpeta que en facultades para ser consistentes
        java.io.File archivo = new java.io.File("File/carreras.json");
        
        if (!archivo.exists()) {
            System.out.println("El archivo carreras.json no existe en la carpeta File/");
            this.carreras = new ArrayList<>();
            return;
        }

        Type t = new TypeToken<List<Carrera>>(){}.getType();
        List<Carrera> listaCargada = new Gson().fromJson(new FileReader(archivo), t);
        
        this.carreras = (listaCargada != null) ? listaCargada : new ArrayList<>();
        System.out.println("Carreras cargadas con éxito: " + carreras.size());
        
    } catch (Exception e) {
        System.err.println("Error al cargar carreras: " + e.getMessage());
        this.carreras = new ArrayList<>();
    }
}


	    private void enlazarFacultadesCarreras() {
    Map<Integer, Facultad> mapaFacultades = new HashMap<>();
    for (Facultad f : facultades) {
        f.setCarreras(new ArrayList<>()); 
        mapaFacultades.put(f.getId(), f);
    }

    for (Carrera c : carreras) {
        Facultad f = mapaFacultades.get(c.getFacultadID());
        if (f != null) {
            f.agregarCarrera(c); 
        }
    }
}


	    public List<Facultad> getFacultades() {
	        return facultades;
	    }

        public List<Facultad> getElements(){
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
