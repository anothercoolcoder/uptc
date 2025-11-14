package persistence;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Product;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class Persistence {

    private static final String FILE_NAME = "products.json";
    private final Gson gson = new Gson();

    public void save(List<?> list) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(list, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  List<Product> load() {
        try (Reader reader = new FileReader(FILE_NAME)) {
            Type type = TypeToken.getParameterized(List.class, clazz).getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            return null; // archivo no existe aún → primera ejecución
        }
    }
}
