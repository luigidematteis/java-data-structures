package trees;

public class BinarySearchTree {

    TreeNode root;

    BinarySearchTree() {
        this.root = null;
    }

    public void insert(int value) {
        TreeNode node = new TreeNode(value);
        if (this.root == null) {
            this.root = node;
        }
    }
}
