package trees;

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

    public List<Integer> listTree() {
        InorderTraversal traversal = new InorderTraversal();
        return traversal.inorderTraversal(this.root);
    }
}
