package graficas.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TraversalsWindow {

    public static void display(String preOrder, String inOrder, String postOrder) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL); 
        window.setTitle("Recorridos del Árbol");
        window.setMinWidth(400);

        Label label = new Label("Resultados de los recorridos:");
        label.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setText(
            "PreOrden (raiz, izquierda, derecha):\n" + preOrder + "\n\n" +
            "InOrder (izquierda, raiz, derecha):\n" + inOrder + "\n\n" +
            "PostOrder (izquierda, derecha, raiz):\n" + postOrder
        );

        Button closeBtn = new Button("Cerrar");
        closeBtn.setOnAction(e -> window.close());

        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label, textArea, closeBtn);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}