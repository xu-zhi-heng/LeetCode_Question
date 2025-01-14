package DFS;

import java.util.*;

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

    public TreeNode(int val) {
        this.val = val;
    }

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


    public static void print(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            System.out.println(poll.val);
            if (poll.left != null) {
                deque.offer(poll.left);
            }
            if (poll.right != null) {
                deque.offer(poll.right);
            }
        }
    }

    public static TreeNode createBT(Integer[] arr){
        if(arr.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean isLeft = true;//是左子树
        for(int i = 1; i< arr.length; i++){
            TreeNode node = queue.peek(); //peek()获取第一个元素，不移除
            if(isLeft){
                if(arr[i] != null){
                    node.left = new TreeNode(arr[i]);
                    queue.offer(node.left); //offer(E e) 在队列尾部添加一个元素，并返回是否成功
                }
                isLeft = false;
            } else {
                if(arr[i] != null){
                    node.right = new TreeNode(arr[i]);
                    queue.offer(node.right);
                }
                //右节点加入队列尾部，删除第一个元素，保证队列里保存的是根节点
                queue.poll(); //poll()  删除队列中第一个元素，并返回该元素的值,
                isLeft = true;
            }
        }
        return root;
    }

}