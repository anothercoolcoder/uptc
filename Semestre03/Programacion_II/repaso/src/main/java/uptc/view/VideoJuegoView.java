package uptc.view;

import uptc.controller.VideoJuegoController;

public class VideoJuegoView {
    private VideoJuegoController videoJuegoController = new VideoJuegoController();

    public void createVideoGame(){
        videoJuegoController.createVideoGame(1, 12, "Mewgenics", "Roguelite", 54000);
        videoJuegoController.createVideoGame(2, 15, "Hades", "Roguelite", 20000);
        videoJuegoController.createVideoGame(3, 53, "Halo", "Shooter", 40000);
    }
    public void list(){
        videoJuegoController.listVideoJuegos().forEach(System.out::println);
    }
}
