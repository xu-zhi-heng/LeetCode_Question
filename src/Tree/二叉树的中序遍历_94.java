package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的中序遍历_94 {
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return res;
        }
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            res.add(current.val);
            current = current.right;
        }
        return res;
    }
}
