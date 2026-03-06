package uptc.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import uptc.model.HistorialMedicoModel;

public class HistorialMedicoDao{
    private final String persistencia = "archivos/pacientes.json";

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public List<HistorialMedicoModel> readFile(){
        try(Reader reader = new FileReader(persistencia)){
            Type typeList = new TypeToken<List<HistorialMedicoModel>>() {}.getType();
            List<HistorialMedicoModel> list = gson.fromJson(reader, typeList);
            return (list != null) ? list : new ArrayList<>();
        }catch(IOException e){
            return new ArrayList<>();
        }
    }
    public void writeFile(List<HistorialMedicoModel> historialMedicoModels){
        try(Writer writer = new FileWriter(persistencia)){
            gson.toJson(historialMedicoModels, writer);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public void create(HistorialMedicoModel h){
        List<HistorialMedicoModel> historialMedicoModels = readFile();
        historialMedicoModels.add(h);
        writeFile(historialMedicoModels);
    }
}