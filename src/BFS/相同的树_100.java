package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class 相同的树_100 {
    public static void main(String[] args) {

    }

    // 深度优先 DFS: 一步步往下去找
    public static boolean isSameTree_1(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        } else if(p == null || q == null) {
            return false;
        } else if(p.val != q.val) {
            return false;
        } else {
            return isSameTree_1(p.left, q.left) && isSameTree_1(p.right, q.right);
        }
    }

    // 广度优先 BFS
    public static boolean isSameTree_2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();
        queueP.offer(p);
        queueQ.offer(q);
        while (!queueP.isEmpty() && !queueQ.isEmpty()) {
            TreeNode node1 = queueP.poll();
            TreeNode node2 = queueQ.poll();

            if (node1.val != node2.val) {
                return false;
            }
            TreeNode left1 = node1.left;
            TreeNode right1 = node1.right;
            TreeNode left2 = node2.left;
            TreeNode right2 = node2.right;

            // ^：异或运算, 代表只要两个其中有一个为空，一个不为空，则为false
            if(left1 == null ^ left2 == null) {
                return false;
            }
            if(right1 == null ^ right2 == null) {
                return false;
            }

            if(left1 != null) {
                queueP.offer(left1);
            }
            if(right1 != null) {
                queueP.offer(right1);
            }
            if(left2 != null) {
                queueQ.offer(left2);
            }
            if(right2 != null) {
                queueQ.offer(right2);
            }
        }
        return queueP.isEmpty() && queueQ.isEmpty();
    }
}
