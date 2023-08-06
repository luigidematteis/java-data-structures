import arrays.GroupAnagrams;
import trees.avl.AvlTree;
import trees.bst.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
       System.out.println("Hello!");
    }

    public static void runDemoWithBinarySearchTree() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(15);
        tree.insert(170);
        tree.insert(9);
        tree.insert(4);
        tree.insert(20);
        tree.insert(1);
        tree.insert(6);
        System.out.println(tree.listTree());
        System.out.println(tree.lookup(7));
        System.out.println(tree.lookup(9));
    }

    public static void runDemoWithAvlTree() {
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

    public static void runDemoWithGroupAnagrams() {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strings = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams.groupAnagrams(strings);
    }
}