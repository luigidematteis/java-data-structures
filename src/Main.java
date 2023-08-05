import trees.avl.AvlTree;
import trees.bst.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
       System.out.println("Hello!");

       createAvlTree();
    }

    public static void createBinarySearchTree() {
       BinarySearchTree tree = new BinarySearchTree();
       tree.insert(15);
       tree.insert(170);
       tree.insert(9);
       tree.insert(4);
       tree.insert(20);
       tree.insert(1);
       tree.insert(6);
       System.out.println(tree.listTree());
    }

    public static void createAvlTree() {
        AvlTree avlTree = new AvlTree();
        avlTree.insert(15);
        avlTree.insert(170);
        avlTree.insert(9);
        avlTree.insert(4);
        avlTree.insert(20);
        avlTree.insert(1);
        avlTree.insert(6);
        System.out.println(avlTree.printAvlTree());
    }
}