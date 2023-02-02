package newcoder;

public class 删除有序链表中的重复元素 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(deleteDuplicates(node1));
    }

    static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(head.val);
        ListNode poc = newHead;
        while (head != null) {
            if (head.val != poc.val) {
                poc.next = new ListNode(head.val);
                poc = poc.next;
            }
            head = head.next;
        }
        return newHead;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }
}
