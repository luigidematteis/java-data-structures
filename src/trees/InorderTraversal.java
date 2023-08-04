package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> treeInOrderValues = new ArrayList<>();
        traversal(root, treeInOrderValues);
        return treeInOrderValues;
    }

/**
 *           9
 *      4        20
 *   1    6    15   170
 *
 */
    private List<Integer> traversal(TreeNode node, List<Integer> treeInOrderValues) {
        if (node == null) return treeInOrderValues;
        if (node.left != null) {
            traversal(node.left, treeInOrderValues);
        }
        treeInOrderValues.add(node.val);
        if (node.right != null) {
            traversal(node.right, treeInOrderValues);
        }
        return treeInOrderValues;
    }

}
