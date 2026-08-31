package graficas.view;

import graficas.controller.TreeController;
import graficas.model.BinaryTree;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        BinaryTree tree = new BinaryTree();
        TreeController controller = new TreeController(tree);

        // Valores iniciales
        controller.insert(10);
        controller.insert(5);
        controller.insert(15);
        controller.insert(2);
        controller.insert(7);

        TreeViewPane treePane = new TreeViewPane(tree);

        TextField inputField = new TextField();
        inputField.setPromptText("Ingrese valor");
        Button insertBtn = new Button("Insertar");

        insertBtn.setOnAction(e -> {
            if (!inputField.getText().trim().isEmpty()) {
                try {
                    int val = Integer.parseInt(inputField.getText().trim());
                    controller.insert(val);
                    treePane.render();
                    inputField.clear();
                } catch (NumberFormatException ex) {
                    System.out.println("Ingrese un número válido");
                }
            }
        });

        HBox controls = new HBox(10, inputField, insertBtn);
        controls.setAlignment(Pos.CENTER);
        controls.setStyle("-fx-padding: 10px;");

        BorderPane mainLayout = new BorderPane();
        mainLayout.setCenter(treePane);
        mainLayout.setBottom(controls);

        Scene scene = new Scene(mainLayout, 700, 500);

        primaryStage.setTitle("Árbol Binario - MVC");
        primaryStage.setScene(scene);
        primaryStage.show();

        treePane.render();
        scene.widthProperty().addListener(ov -> treePane.render());
        scene.heightProperty().addListener(ov -> treePane.render());
    }

    public static void main(String[] args) {
        launch(args);
    }
}