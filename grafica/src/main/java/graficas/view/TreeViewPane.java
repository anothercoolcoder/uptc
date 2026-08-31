package graficas.view;

import graficas.model.BinaryTree;
import graficas.model.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class TreeViewPane extends Pane {
    private final BinaryTree tree;
    private final double radius = 20.0;
    private final double verticalGap = 50.0;

    public TreeViewPane(BinaryTree tree) {
        this.tree = tree;
    }

    public void render() {
        this.getChildren().clear();
        if (tree.getRoot() != null) {
            displayTree(tree.getRoot(), getWidth() / 2, 40, getWidth() / 4);
        }
    }

    private void displayTree(Node node, double x, double y, double horizontalGap) {
        if (node.getLeft() != null) {
            getChildren().add(new Line(x - horizontalGap, y + verticalGap, x, y));
            displayTree(node.getLeft(), x - horizontalGap, y + verticalGap, horizontalGap / 2);
        }

        if (node.getRight() != null) {
            getChildren().add(new Line(x + horizontalGap, y + verticalGap, x, y));
            displayTree(node.getRight(), x + horizontalGap, y + verticalGap, horizontalGap / 2);
        }

        Circle circle = new Circle(x, y, radius);
        circle.setFill(Color.LIGHTBLUE);
        circle.setStroke(Color.DARKBLUE);

        Text text = new Text(x - 5, y + 4, String.valueOf(node.getValue()));

        getChildren().addAll(circle, text);
    }
}