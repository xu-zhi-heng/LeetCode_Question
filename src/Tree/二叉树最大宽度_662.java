package Tree;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class 二叉树最大宽度_662 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = null;
        root.right.right = new TreeNode(9);
        System.out.println(widthOfBinaryTree(root));

    }
    // BFS
    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 根据二叉树的性质， 左边的顺序为 index * 2， 右边的节点为 index * 2 + 1
        LinkedList<HashMap<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new HashMap<>(){
            {
                put(root, 1);
            }
        });
        int res = 1;
        LinkedList<HashMap<TreeNode, Integer>> temp = new LinkedList<>();
        while (!queue.isEmpty()) {
            HashMap<TreeNode, Integer> current = queue.poll();
            for (Map.Entry<TreeNode, Integer> map : current.entrySet()) {
                TreeNode node = map.getKey();
                int value = map.getValue();
                if (node.left != null) {
                    // new HashMap<>().put() 这种方法会返回空值
                    temp.offer(new HashMap<>(){
                        {
                            put(node.left, value * 2);
                        }
                    });
                }
                if (node.right != null) {
                    temp.offer(new HashMap<>(){
                        {
                            put(node.right, value * 2 + 1);
                        }
                    });
                }
            }
            if (queue.isEmpty()) {
                // 使用addAll方法，而不是直接赋值的原因是因为，当temp中的数据清空时，queue中的数据也会清空
                queue.addAll(temp);
                if (!temp.isEmpty()) {
                    HashMap<TreeNode, Integer> first = temp.getFirst();
                    int firstValue = 0;
                    for (Map.Entry<TreeNode, Integer> map : first.entrySet()) {
                        firstValue = map.getValue();
                    }
                    int lastValue = 0;
                    HashMap<TreeNode, Integer> last = temp.getLast();
                    for (Map.Entry<TreeNode, Integer> map : last.entrySet()) {
                        lastValue = map.getValue();
                    }
                    res = Math.max(res, lastValue - firstValue + 1);
                    temp.clear();
                }
            }
        }
        return res;
    }
}
