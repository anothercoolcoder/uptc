package persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Product;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;

public class Persistence {

    private static final String FILE_NAME = "products.json";

    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public boolean save(HashMap<String, Product> products) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(products, writer);
            return true;
        } catch (IOException e) {
            System.err.println("Error al guardar productos: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public HashMap<String, Product> load() {
        File file = new File(FILE_NAME);

        // Si el archivo no existe, retornar HashMap vacío
        if (!file.exists()) {
            return new HashMap<>();
        }

        try (Reader reader = new FileReader(file)) {
            Type type = new TypeToken<HashMap<String, Product>>(){}.getType();
            HashMap<String, Product> loaded = gson.fromJson(reader, type);
            return loaded != null ? loaded : new HashMap<>();
        } catch (IOException e) {
            System.err.println("Error al cargar productos: " + e.getMessage());
            e.printStackTrace();
            return new HashMap<>();
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