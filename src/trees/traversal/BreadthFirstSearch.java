package trees.traversal;

import models.TreeNode;
import trees.bst.BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    public List<Integer> breadthFirstSearch(BinarySearchTree tree) {
        TreeNode currentNode = tree.getRootNode();
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(currentNode);

        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            list.add(currentNode.val);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return list;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null) {
            int leftMax = nodeMax(root.left);
            if (leftMax >= root.val) return false;
        }

        if (root.right != null) {
            int rightMin = nodeMin(root.right);
            if (rightMin <= root.val) return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    private int nodeMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    private int nodeMax(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

}
