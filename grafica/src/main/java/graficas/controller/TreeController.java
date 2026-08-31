package graficas.controller;

import graficas.model.BinaryTree;
import graficas.model.Node;

public class TreeController {
    private final BinaryTree tree;

    public TreeController(BinaryTree tree) {
        this.tree = tree;
    }

    public BinaryTree getTree() {
        return tree;
    }

    public void insert(int value) {
        tree.setRoot(insertRecursive(tree.getRoot(), value));
    }

    private Node insertRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value, null, null);
        }
        if (value < current.getValue()) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setRight(insertRecursive(current.getRight(), value));
        }
        return current;
    }

    public boolean search(int value) {
        return searchRecursive(tree.getRoot(), value);
    }

    private boolean searchRecursive(Node current, int value) {
        if (current == null) return false;
        if (value == current.getValue()) return true;
        return value < current.getValue()
                ? searchRecursive(current.getLeft(), value)
                : searchRecursive(current.getRight(), value);
    }
}