// BinaryTree.java
package graficas.model;

public class BinaryTree {
    private Node root;
    public BinaryTree() {
        this.root = null;
    }


    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getValue() + " ");
            inOrder(node.getRight());
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }

    public Node search(Node node, int value) {
        if (node == null || node.getValue() == value) {
            return node;
        }
        if (value < node.getValue()) {
            return search(node.getLeft(), value);
        }
        return search(node.getRight(), value);
    }

    public Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value, null, null);
        }
        if (value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insert(node.getRight(), value));
        }
        return node;
    }

    public Node delete(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (value < node.getValue()) {
            node.setLeft(delete(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(delete(node.getRight(), value));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            }
            if (node.getRight() == null) {
                return node.getLeft();
            }
            node.setValue(minValue(node.getRight()));
            node.setRight(delete(node.getRight(), node.getValue()));
        }
        return node;
    }

    private int minValue(Node node) {
        int minValue = node.getValue();
        while (node.getLeft() != null) {
            minValue = node.getLeft().getValue();
            node = node.getLeft();
        }
        return minValue;
    }

    private int maxValue(Node node) {
        int maxValue = node.getValue();
        while (node.getRight() != null) {
            maxValue = node.getRight().getValue();
            node = node.getRight();
        }
        return maxValue;
    }
}