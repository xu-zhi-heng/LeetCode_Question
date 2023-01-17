package Tree;

public class 对称二叉树_101 {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode root1, TreeNode root2) {
        // 如果都为空，那就不需要比较了
        if (root1 == null && root2 == null) return true;
        // 如果一个为空，另一个不为空，则直接不对称
        if (root1 == null || root2 == null) return false;
        // 判断两个节点的值是否相等，并且递归比较左右子树
        return (root1.val == root2.val) && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }
}
