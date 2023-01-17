package Tree;

public class 二叉搜索树的最小绝对差_530 {
    static int current;
    static int poor;
    public int getMinimumDifference(TreeNode root) {
        poor = Integer.MAX_VALUE;
        current = -1;
        inOrderTraversal(root);
        return poor;
    }

    public static void inOrderTraversal(TreeNode node) {
        if(node == null) return;
        inOrderTraversal(node.left);
        if(current == -1) {
            current = node.val;
        }else {
            poor = Math.min(poor,node.val - current);
            current = node.val;
        }
        inOrderTraversal(node.right);
    }
}

