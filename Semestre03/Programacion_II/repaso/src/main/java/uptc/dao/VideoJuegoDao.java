package uptc.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import uptc.model.VideoJuegoModel;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class VideoJuegoDao {
    private final String file = "Archivo/inventario.json";
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private List<VideoJuegoModel> readFile(){
        try (Reader reader = new FileReader(file)) {
            Type typeList = new TypeToken<List<VideoJuegoModel>>() {}.getType();
            List<VideoJuegoModel> list = gson.fromJson(reader, typeList);
            return (list != null) ? list : new ArrayList<>();
        } catch (IOException e){
            return new ArrayList<>();
        }
    }

    private void writeFile(List<VideoJuegoModel> videoJuegoModels){
        try (Writer writer = new FileWriter(file)){
            gson.toJson(videoJuegoModels, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void create(VideoJuegoModel v){
        List<VideoJuegoModel> videoJuegoModels = readFile();
        videoJuegoModels.add(v);
        writeFile(videoJuegoModels);
    }

    public List<VideoJuegoModel> listVideoJuegos(){
        return readFile();
    }

    public VideoJuegoModel searchForId(int id){
        return readFile().stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public void update(VideoJuegoModel updateVideoJuegoModel){
        List<VideoJuegoModel> videoJuegoModels = readFile();
        videoJuegoModels.replaceAll(e -> e.getId() == updateVideoJuegoModel.getId() ? updateVideoJuegoModel:e);
        writeFile(videoJuegoModels);
    }
    public void delete (int id){
        List<VideoJuegoModel> videoJuegoModels = readFile();
        videoJuegoModels.removeIf(e -> e.getId() == id);
        writeFile(videoJuegoModels);
    }
    
}
