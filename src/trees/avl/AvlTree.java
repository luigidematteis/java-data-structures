package trees.avl;

import models.AvlNode;

import java.util.ArrayList;
import java.util.List;

public class AvlTree {

    AvlNode root;

    public AvlTree() {
        this.root = null;
    }

    private int height(AvlNode node) {
        return node != null ? node.getHeight() : -1;
    }

    private void updateHeight(AvlNode node) {
        AvlNode leftChild = node.getLeftChild();
        AvlNode rightChild = node.getRightChild();
        node.height = Math.max(height(leftChild), height(rightChild));
    }

    private int balanceFactor(AvlNode node) {
        return height(node.getRightChild()) - height(node.getLeftChild());
    }

    public AvlNode insert(int data) {
        insertNode(data);

        updateHeight(this.root);

        return rebalance(this.root);
    }

    private AvlNode rebalance(AvlNode node) {
        int balanceFactor = balanceFactor(node);

        if (balanceFactor < -1) {
            if (balanceFactor(node.getRightChild()) <= 0) {
                node = rotateRight(node);
            } else {
                node.setLeftChild(rotateLeft(node.getLeftChild()));
                node = rotateRight(node);
            }
        }

        if (balanceFactor > 1) {
            if (balanceFactor(node.getRightChild()) >= 0) {
                node = rotateLeft(node);
            } else {
                node.setRightChild(rotateRight(node.getRightChild()));
                node = rotateLeft(node);
            }
        }
        return node;
    }

    /**
     *           9
     *      4        20
     *   1    6    15   170
     *
     */
    private void insertNode(int data) {
        AvlNode nodeToInsert = new AvlNode(data);
        if (this.root == null) {
            this.root = new AvlNode(data);
        } else {
            AvlNode currentNode = this.root;
            while (true) {
                if (data < currentNode.getData()) {
                    if (currentNode.getLeftChild() == null) {
                        currentNode.setLeftChild(nodeToInsert);
                        return;
                    }
                    currentNode = currentNode.getLeftChild();
                } else {
                    if (currentNode.getRightChild() == null) {
                        currentNode.setRightChild(nodeToInsert);
                        return;
                    }
                    currentNode = currentNode.getRightChild();
                }
            }
        }
    }

    private AvlNode rotateRight(AvlNode node) {
        AvlNode leftChild = node.getLeftChild();

        node.setLeftChild(leftChild.getRightChild());
        leftChild.setRightChild(node);

        updateHeight(node);
        updateHeight(leftChild);

        return leftChild;
    }

    private AvlNode rotateLeft(AvlNode node) {
        AvlNode rightChild = node.getRightChild();

        node.setRightChild(rightChild.getLeftChild());
        rightChild.setLeftChild(node);

        updateHeight(node);
        updateHeight(rightChild);

        return rightChild;
    }

    public List<Integer> printAvlTree() {
        return inorderTraversal(this.root);
    }

    public List<Integer> inorderTraversal(AvlNode root) {
        List<Integer> treeInOrderValues = new ArrayList<>();
        traversal(root, treeInOrderValues);
        return treeInOrderValues;
    }

    private List<Integer> traversal(AvlNode node, List<Integer> treeInOrderValues) {
        if (node == null) return treeInOrderValues;
        if (node.getLeftChild() != null) {
            traversal(node.getLeftChild(), treeInOrderValues);
        }
        treeInOrderValues.add(node.getData());
        if (node.getRightChild() != null) {
            traversal(node.getRightChild(), treeInOrderValues);
        }
        return treeInOrderValues;
    }

}
