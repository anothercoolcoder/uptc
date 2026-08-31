package graficas.model;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node getRoot() { return root; }
    public void setRoot(Node root) { this.root = root; }
}