package DFS;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的中序遍历_94 {
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        inorder(res, root);
        return res;
    }

    // 递归
    public void inorder(List list, TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }

    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}