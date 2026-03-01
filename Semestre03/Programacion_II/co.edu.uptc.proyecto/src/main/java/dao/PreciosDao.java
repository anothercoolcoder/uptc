package dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.PrecioModel;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PreciosDao {
    private final String preciosFile = "Archivos/precios.json";

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private List<PrecioModel> readFile(){
        try(Reader reader = new FileReader(preciosFile)){
            Type typeList = new TypeToken<List<PrecioModel>>() {}.getType();
            List<PrecioModel> list = gson.fromJson(reader, typeList);
            return (list != null) ? list : new ArrayList<>();
        }catch(IOException e){
            return new ArrayList<>();
        }
    }

    private void writeFile(List<PrecioModel> precios){
        try(Writer writer = new FileWriter(preciosFile)){
            gson.toJson(precios, writer);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void create(PrecioModel p){
        List<PrecioModel> precioModels = readFile();
        if (readFile().stream().anyMatch(e -> e.getId() == p.getId())) {
            System.out.println("El archivo no puede tener duplicados");
        }else{
            precioModels.add(p);
        }
        writeFile(precioModels);
    }

    public List<PrecioModel> listPrecioModels(){
        return readFile();
    }

    public PrecioModel searchForId(int id){
        return readFile().stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }
    
    public void updatePrecioModel(PrecioModel updatePrecioModel){
        List<PrecioModel> PrecioModels = readFile();
        PrecioModels.replaceAll(e -> e.getId() == updatePrecioModel.getId() ? updatePrecioModel:e);
        writeFile(PrecioModels);
    }

    public void delete(int id){
        List<PrecioModel> PrecioModels = readFile();
        PrecioModels.removeIf(e -> e.getId() == id);
        writeFile(PrecioModels);
    }
}
