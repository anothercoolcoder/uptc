package dao;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.RoomModel;

public class HotelDao {
    private final String file = "File/hotel.json";
    private Gson gson = new Gson();

    private List<RoomModel> readFile(){
        // manejo de exepciones
        try(Reader reader = new FileReader(file)) {
            Type typeList = new TypeToken<List<RoomModel>>(){}.getType();
            List<RoomModel> list = gson.fromJson(reader,typeList);
            return list != null ? list : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
    private void write(List<RoomModel> rooms){
        File folder = new File("File");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        try (Writer writer = new FileWriter(file)){
            gson.toJson(rooms, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void create(RoomModel e){
        List<RoomModel> roomModels = readFile();
        roomModels.add(e);
        write(roomModels);
    }
    public List<RoomModel> list(){
        return readFile();
    }
    public RoomModel searchId(int id){
        return readFile().stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }
    public void update(RoomModel updateRoom) {
        List<RoomModel> students = readFile();
        students.replaceAll(e -> e.getId() == updateRoom.getId()
                ? updateRoom : e);
        write(students);
    }
    public void remove(int id) {
        List<RoomModel> roomModels = readFile();
        roomModels.removeIf(e -> e.getId() == id);
        write(roomModels);
    }

}
