package persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Product;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Persistence {

    private static final String FILE_NAME = "products.json";

    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public boolean save(List<Product> list) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(list, writer);
            return true;
        } catch (IOException e) {
            System.err.println("Error al guardar productos: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Product> load() {
        File file = new File(FILE_NAME);

        // Si el archivo no existe, retornar lista vacía
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (Reader reader = new FileReader(file)) {
            Type type = new TypeToken<List<Product>>(){}.getType();
            List<Product> loaded = gson.fromJson(reader, type);
            return loaded != null ? loaded : new ArrayList<>();
        } catch (IOException e) {
            System.err.println("Error al cargar productos: " + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public boolean fileExists() {
        return new File(FILE_NAME).exists();
    }

    public boolean deleteFile() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }
}