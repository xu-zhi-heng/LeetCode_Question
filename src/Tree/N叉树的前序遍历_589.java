package Tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class N叉树的前序遍历_589 {
    public static void main(String[] args) {

    }

    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output_arr = new LinkedList<>();
        if (root == null) {
            return output_arr;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output_arr.add(node.val);
            Collections.reverse(node.children);
            for (Node child : node.children) {
                stack.add(child);
            }
        }
        return output_arr;
    }
}
