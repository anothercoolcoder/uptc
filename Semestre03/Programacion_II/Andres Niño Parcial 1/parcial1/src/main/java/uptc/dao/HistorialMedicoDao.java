package uptc.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import uptc.model.*;

import uptc.model.HistorialMedicoModel;

public class HistorialMedicoDao{
    public final String persistencia = "archivos/pacientes.json";

    public Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public List<HistorialMedicoModel> readFile(){
    try(Reader reader = new FileReader(persistencia)){
        HistorialContainer contenedor = gson.fromJson(reader, HistorialContainer.class);
        
        return (contenedor != null && contenedor.getHistoriales() != null) 
               ? contenedor.getHistoriales() 
               : new ArrayList<>();
               
    } catch(IOException e){
        System.err.println("Error al leer el archivo: " + e.getMessage());
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