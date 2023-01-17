package Tree;
public class 在二叉树中分配硬币_974 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        root.left.right.right = new TreeNode(0);
        distributeCoins(root);
    }

    static int ans;
    public static int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public static int dfs(TreeNode node) {
        if (node == null) return 0;
        int L = dfs(node.left);
        int R = dfs(node.right);
        ans += Math.abs(L) + Math.abs(R);
        return node.val + L + R - 1;
    }
}
