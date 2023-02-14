package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的所有路径_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<String> paths = new LinkedList<>();
        Queue<TreeNode> nodes = new LinkedList<>();

        paths.offer(Integer.toString(root.val));
        nodes.offer(root);

        while (!nodes.isEmpty()) {
            String path = paths.poll();
            TreeNode node = nodes.poll();

            if (node.left == null && node.right == null) {
                result.add(path);
            } else {
                if (node.left != null) {
                    paths.offer(path + "->" + node.left.val);
                    nodes.offer(node.left);
                }
                if (node.right != null) {
                    paths.offer(path + "->" + node.right.val);
                    nodes.offer(node.right);
                }
            }
        }
        return result;
    }
}
