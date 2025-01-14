package List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public ListNode createListNode(int[] nums) {
        ListNode root = new ListNode(0);
        ListNode node = new ListNode();
        root.next = node;
        for (int i = 0; i < nums.length; i++) {
            node.val = nums[i];
            if (i + 1 != nums.length) {
                node.next = new ListNode();
                node = node.next;
            }
        }

        return root.next;
    }
}
