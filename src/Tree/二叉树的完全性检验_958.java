package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的完全性检验_958 {
    public boolean isCompleteTree(TreeNode root) {
        /**
         * 遍历整数树，因为是完整的树，null应该是最后一个值，所以当出现null之后，后面再出现其他值的时候，就可以判断了
         */
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root == null) {
                flag = true;
            } else {
                if (flag) return false;
                queue.offer(root.left);
                queue.offer(root.right);
            }
        }
        return flag;
    }
}
