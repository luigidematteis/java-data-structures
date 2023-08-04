import arrays.GroupAnagrams;
import trees.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
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
}