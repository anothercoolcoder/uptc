package dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.*;

public class EstudianteDao {
    private final String archivo = "File/estudiantes.json";
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private List<Estudiante> leerArchivo() {
        try (Reader reader = new FileReader(archivo)) {
            Type tipoLista = new TypeToken<List<Estudiante>>() {
            }.getType();
            List<Estudiante> lista = gson.fromJson(reader, tipoLista);
            return lista != null ? lista : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private void escribirArchivo(List<Estudiante> estudiantes) {
        try (Writer writer = new FileWriter(archivo)) {
            gson.toJson(estudiantes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crear(Estudiante e) {
        List<Estudiante> estudiantes = leerArchivo();
        if (!leerArchivo().stream().anyMatch(k -> k.getId() == e.getId())) {
            estudiantes.add(e);
            escribirArchivo(estudiantes);
        }else{
            System.out.println("No puede haber duplicados");
        }
    }

    public List<Estudiante> listar() {
        return leerArchivo();
    }

    public Estudiante buscarPorId(int id) {
        return leerArchivo().stream()
                .filter(estudiante -> estudiante.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void actualizar(Estudiante estudianteActualizado) {
        List<Estudiante> estudiantes = leerArchivo();

        estudiantes.replaceAll(e -> e.getId() == estudianteActualizado.getId()
                ? estudianteActualizado
                : e);
        escribirArchivo(estudiantes);
    }

    public void eliminar(int id) {
        List<Estudiante> estudiantes = leerArchivo();
        estudiantes.removeIf(e -> e.getId() == id);
        escribirArchivo(estudiantes);
    }

}