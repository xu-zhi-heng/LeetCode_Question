package Tree;

public class 翻转二叉树_226 {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // swap
        root.left = right;
        root.right = left;

        return root;
    }
}
