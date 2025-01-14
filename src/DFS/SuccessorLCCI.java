package DFS;

import java.util.ArrayList;
import java.util.List;

public class SuccessorLCCI {
    public static void main(String[] args) {
        // 5,3,6,2,4,null,null,1
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = null;
        root.right.right = null;
        root.left.left.left = new TreeNode(1);
        System.out.println(inorderSuccessor(root, new TreeNode(6)));
    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).val == p.val) {
                if (i + 1 >= list.size()) {
                    return null;
                } else {
                    return list.get(i + 1);
                }
            }
        }
        return null;
    }

    public static void inorder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
}
