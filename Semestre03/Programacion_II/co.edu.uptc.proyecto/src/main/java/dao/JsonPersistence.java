package dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.ClienteModel;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonPersistence {
    private final String PATH = "files/persistencia.json";
    private final Gson gson;

    public JsonPersistence() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

public void guardarTodo(List<ClienteModel> clientes) {
    try (Writer writer = new FileWriter(PATH)) {

        System.out.println("GUARDANDO JSON EN: " + new File(PATH).getAbsolutePath()); // 🔥 DEBUG

        gson.toJson(clientes, writer);

    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public List<ClienteModel> leerTodos() {
        File file = new File(PATH);
        if (!file.exists()) {
            return new ArrayList<>(); 
        }

        try (Reader reader = new FileReader(PATH)) {
            Type listType = new TypeToken<ArrayList<ClienteModel>>(){}.getType();
            List<ClienteModel> lista = gson.fromJson(reader, listType);
            return (lista != null) ? lista : new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}