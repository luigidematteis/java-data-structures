package trees.bst;

import models.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    /**
     *           9
     *      4        20
     *   1    6    15   170
     *
     */
    public List<Integer> breadthFirstSearch(TreeNode root) {
        List<Integer> treeValues = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode currentNode = root;
        queue.add(currentNode);
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            treeValues.add(currentNode.val);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return treeValues;
    }
}
