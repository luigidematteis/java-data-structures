package trees.bst;

import models.TreeNode;
import trees.traversal.InorderTraversal;

import java.util.List;

public class BinarySearchTree {

    TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    /**
     *           9
     *      4        20
     *   1    6    15   170
     *
     */
    public void insert(int value) {
        TreeNode node = new TreeNode(value);
        if (this.root == null) {
            this.root = node;
        } else {
            TreeNode currentNode = this.root;
            while (true) {
                if (value < currentNode.val) {
                    if (currentNode.left == null) {
                        currentNode.left = node;
                        return;
                    }
                    currentNode = currentNode.left;
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = node;
                        return;
                    }
                    currentNode = currentNode.right;
                }
            }
        }
    }

    public boolean lookup(int value) {
        if (this.root == null) {
            return false;
        }
        TreeNode currentNode = this.root;
        while (currentNode != null) {
            if (value < currentNode.val) {
                currentNode = currentNode.left;
            } else if (value > currentNode.val){
                currentNode = currentNode.right;
            } else {
                return true;
            }
        }

        return false;
    }

    public List<Integer> listTree() {
        InorderTraversal traversal = new InorderTraversal();
        return traversal.inorderTraversal(this.root);
    }

    public TreeNode getRootNode() {
        return this.root;
    }
}
