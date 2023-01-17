package Tree;

import java.util.LinkedList;
import java.util.List;

public class N叉树的后序遍历_590 {
    public static void main(String[] args) {

    }

    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output_arr = new LinkedList<>();
        if (root == null) {
            return output_arr;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            // 取出栈中的最后一个元素，并从栈中删除该元素
            Node node = stack.pollLast();
            // 将该元素的值放入到结果的第一个位置，逆序存放
            output_arr.addFirst(node.val);
            for (Node child : node.children) {
                stack.add(child);
            }
        }
        return output_arr;
    }
}
