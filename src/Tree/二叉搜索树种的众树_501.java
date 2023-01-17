package Tree;

import java.util.ArrayList;
import java.util.List;

public class 二叉搜索树种的众树_501 {
    public static void main(String[] args) {

    }
    static List<Integer> mList = new ArrayList<>();
    static int curent = 0;//表示当前节点的值
    static int count = 0;//表示当前节点的数量
    static int maxCount = 0;//最大的重复数量
    public static int[] findMode(TreeNode root) {
        inOrderTraversal(root);
        int[] res = new int[mList.size()];
        for(int i = 0;i < mList.size(); i++) {
            res[i] = mList.get(i);
        }
        return res;
    }
    public static void inOrderTraversal(TreeNode node) {
        if(node == null) return;
        inOrderTraversal(node.left);
        int nodeValue = node.val;
        if(curent == nodeValue) {
            count++;
        }else {
            curent = nodeValue;
            count = 1;
        }
        if(count == maxCount) {
            mList.add(nodeValue);
        }else if(count > maxCount) {
            mList.clear();
            mList.add(nodeValue);
            maxCount = count;
        }
        inOrderTraversal(node.right);
    }
}
