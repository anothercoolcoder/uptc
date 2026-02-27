package uptc.controller;

import uptc.dao.VideoJuegoDao;
import uptc.model.VideoJuegoModel;
import java.util.List;

public class VideoJuegoController {
    private VideoJuegoDao dao = new VideoJuegoDao();

    public void createVideoGame(int id, int stock, String titulo, String categoria, double precio){
        dao.create(new VideoJuegoModel(id, stock, titulo, categoria, precio));
    }
    public List<VideoJuegoModel> listVideoJuegos(){
        return dao.listVideoJuegos();
    }
    public void updateVideoJuegoModel(int id, int stock, String titulo, String categoria, double precio){
        dao.update(new VideoJuegoModel(id, stock, titulo, categoria, precio));
    }
    public void delete(int id){
        dao.delete(id);
    }
}
