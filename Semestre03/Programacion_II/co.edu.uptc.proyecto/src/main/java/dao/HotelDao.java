package dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.RoomModel;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HotelDao {
    private final String persistencia = "Archivos/persistencia.json";

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private List<RoomModel> readFile(){
        try(Reader reader = new FileReader(persistencia)){
            Type typeList = new TypeToken<List<RoomModel>>() {}.getType();
            List<RoomModel> list = gson.fromJson(reader, typeList);
            return (list != null) ? list : new ArrayList<>();
        }catch(IOException e){
            return new ArrayList<>();
        }
    }

    private void writeFile(List<RoomModel> roomModels){
        try(Writer writer = new FileWriter(persistencia)){
            gson.toJson(roomModels, writer);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void create(RoomModel r){
        List<RoomModel> roomModels = readFile();
        if (readFile().stream().anyMatch(e -> e.getId() == r.getId())) {
            System.out.println("El sistema no puede tener duplicados");
        }else{
            roomModels.add(r);
        }
        writeFile(roomModels);
    }

    public List<RoomModel> listRoomModels(){
        return readFile();
    }

    public RoomModel searchForId(int id){
        return readFile().stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }
    
    public void updateRoomModel(RoomModel updateRoomModel){
        List<RoomModel> roomModels = readFile();
        roomModels.replaceAll(e -> e.getId() == updateRoomModel.getId() ? updateRoomModel:e);
        writeFile(roomModels);
    }

    public void delete(int id){
        List<RoomModel> roomModels = readFile();
        roomModels.removeIf(e -> e.getId() == id);
        writeFile(roomModels);
    }
}
