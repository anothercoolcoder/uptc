package graficas.view;

import graficas.controller.TreeController;
import graficas.model.BinaryTree;
import graficas.model.Node;
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
        Node initialRoot = new Node(10, null, null);
        BinaryTree tree = new BinaryTree(initialRoot);
        TreeController controller = new TreeController(tree);

        controller.insert(5);
        controller.insert(15);
        controller.insert(2);
        controller.insert(7);

        TreeViewPane treePane = new TreeViewPane(tree);

        TextField inputField = new TextField();
        inputField.setPromptText("Valor int");
        
        Button insertBtn = new Button("Insertar");
        Button deleteBtn = new Button("Eliminar");
        Button traversalsBtn = new Button("Ver Recorridos"); 

        insertBtn.setOnAction(e -> {
            if (!inputField.getText().trim().isEmpty()) {
                try {
                    int val = Integer.parseInt(inputField.getText().trim());
                    controller.insert(val);
                    treePane.render();
                    inputField.clear();
                } catch (NumberFormatException ex) {
                    System.out.println("Formato numérico no válido");
                }
            }
        });

        deleteBtn.setOnAction(e -> {
            if (!inputField.getText().trim().isEmpty()) {
                try {
                    int val = Integer.parseInt(inputField.getText().trim());
                    controller.delete(val);
                    treePane.render();
                    inputField.clear();
                } catch (NumberFormatException ex) {
                    System.out.println("Formato numérico no válido");
                }
            }
        });

        traversalsBtn.setOnAction(e -> {
            TraversalsWindow.display(
                controller.getPreOrderText(),
                controller.getInOrderText(),
                controller.getPostOrderText()
            );
        });

        HBox controls = new HBox(10, inputField, insertBtn, deleteBtn, traversalsBtn);
        controls.setAlignment(Pos.CENTER);
        controls.setStyle("-fx-padding: 10px;");

        BorderPane mainLayout = new BorderPane();
        mainLayout.setCenter(treePane);
        mainLayout.setBottom(controls);

        Scene scene = new Scene(mainLayout, 800, 600);

        primaryStage.setTitle("Visualizador Árbol Binario");
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