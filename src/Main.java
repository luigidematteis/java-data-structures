import arrays.GroupAnagrams;
import arrays.LongestSubstring;
import challenges.AddTwoNumbers;
import challenges.RotatedSortedArray;
import models.ListNode;
import trees.avl.AvlTree;
import trees.bst.BinarySearchTree;
import trees.traversal.BreadthFirstSearch;

public class Main {
    public static void main(String[] args) {
       System.out.println("Hello!");

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        addTwoNumbers.addTwoNumbers(l1, l2);
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

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        System.out.println(breadthFirstSearch.breadthFirstSearch(tree));
    }

    public static void runDemoWithLongestSubString() {
        LongestSubstring longestSubstring = new LongestSubstring();
        longestSubstring.lengthOfLongestSubstring("umvejcuuk");
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

    public static void runDemoWithRotatedSortedArray() {
        RotatedSortedArray rotatedSortedArray = new RotatedSortedArray();
        int[] nums = {4,5,6,7,0,1,2,3};
        rotatedSortedArray.search(nums, 4);
    }
}