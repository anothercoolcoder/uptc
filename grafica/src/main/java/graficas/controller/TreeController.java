package graficas.controller;

import graficas.model.BinaryTree;
import graficas.model.Node;

public class TreeController {
    private final BinaryTree tree;

    public TreeController(BinaryTree tree) {
        this.tree = tree;
    }

    public void insert(int value) {
        Node updatedRoot = tree.insert(tree.getRoot(), value);
        tree.setRoot(updatedRoot);
    }

    public void delete(int value) {
        Node updatedRoot = tree.delete(tree.getRoot(), value);
        tree.setRoot(updatedRoot);
    }

    public void printTraversals() {
        System.out.print("PreOrder: ");
        tree.preOrder(tree.getRoot());
        System.out.println();
        System.out.print("InOrder: ");
        tree.inOrder(tree.getRoot());
        System.out.println();
        System.out.print("PostOrder: ");
        tree.postOrder(tree.getRoot());
        System.out.println();
    }

    public String getPreOrderText() {
        StringBuilder sb = new StringBuilder();
        buildPreOrder(tree.getRoot(), sb);
        return sb.toString().trim();
    }

    private void buildPreOrder(Node node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.getValue()).append(" ");
            buildPreOrder(node.getLeft(), sb);
            buildPreOrder(node.getRight(), sb);
        }
    }

    public String getInOrderText() {
        StringBuilder sb = new StringBuilder();
        buildInOrder(tree.getRoot(), sb);
        return sb.toString().trim();
    }

    private void buildInOrder(Node node, StringBuilder sb) {
        if (node != null) {
            buildInOrder(node.getLeft(), sb);
            sb.append(node.getValue()).append(" ");
            buildInOrder(node.getRight(), sb);
        }
    }

    public String getPostOrderText() {
        StringBuilder sb = new StringBuilder();
        buildPostOrder(tree.getRoot(), sb);
        return sb.toString().trim();
    }

    private void buildPostOrder(Node node, StringBuilder sb) {
        if (node != null) {
            buildPostOrder(node.getLeft(), sb);
            buildPostOrder(node.getRight(), sb);
            sb.append(node.getValue()).append(" ");
        }
    }
}