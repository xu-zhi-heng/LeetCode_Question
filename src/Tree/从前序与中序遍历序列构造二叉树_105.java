package Tree;

// 不是很理解
public class 从前序与中序遍历序列构造二叉树_105 {
    public static void main(String[] args) {

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) return null;

        // 前序遍历， 第一个数字就是头节点
        TreeNode root = new TreeNode(preorder[preStart]);

        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }

        root.left = helper(preStart + 1, inStart,inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
