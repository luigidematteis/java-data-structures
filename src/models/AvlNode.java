package models;

public class AvlNode {

    AvlNode rightChild;
    AvlNode leftChild;
    public int height;
    int data;

    public AvlNode(int data) {
        this.data = data;
    }

    public AvlNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(AvlNode rightChild) {
        this.rightChild = rightChild;
    }

    public AvlNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(AvlNode leftChild) {
        this.leftChild = leftChild;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
