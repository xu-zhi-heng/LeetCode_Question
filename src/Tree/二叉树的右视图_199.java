package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的右视图_199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                // 因为队列是先进先出的，所以第一个值，一定是从右边可以看见的，和下面先右在左有关系，如果右没有，那么看到的一定是左
                if (i == 0) list.add(current.val);
                if (current != null) {
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                }
            }
        }
        return list;
    }
}
