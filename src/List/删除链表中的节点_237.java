package List;

public class 删除链表中的节点_237 {
    public static void main(String[] args) {

    }
    // 无语，人家两步写出来，我还想着从给点的节点开始旋转两次完成
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
