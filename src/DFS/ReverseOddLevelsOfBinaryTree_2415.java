package DFS;

import java.util.*;

public class ReverseOddLevelsOfBinaryTree_2415 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(13);
        root.right = new TreeNode(11);
        TreeNode.print(root);
        TreeNode treeNode = reverseOddLevels(root);
        TreeNode.print(treeNode);
    }

    public static TreeNode reverseOddLevels(TreeNode root) {
        int level = 0;
        int count = 0;
        List<Integer> tempList = new ArrayList<>();
        List<Integer> valList = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            count++;
            if (count == (int) Math.pow(2, level)) {
                level++;
            }
            if ((level - 1) % 2 != 0) {
                tempList.add(poll.val);
            }
            if (!tempList.isEmpty() && (level - 1) % 2 == 0) {
                Collections.reverse(tempList);
                valList.addAll(tempList);
                tempList.clear();
            }
            if (poll.left != null) {
                deque.offer(poll.left);
            }
            if (poll.right != null) {
                deque.offer(poll.right);
            }
        }
        if (!tempList.isEmpty()) {
            Collections.reverse(tempList);
            valList.addAll(tempList);
            tempList.clear();
        }
        count = 0;
        level = 0;
        int index = 0;
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            count++;
            if (count == (int) Math.pow(2, level)) {
                level++;
            }
            if ((level - 1) % 2 != 0) {
                poll.val = valList.get(index);
                index++;
            }
            if (poll.left != null) {
                deque.offer(poll.left);
            }
            if (poll.right != null) {
                deque.offer(poll.right);
            }
        }
        return root;
    }
}
