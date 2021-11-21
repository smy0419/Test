package newcoder;

public class 链表中环的入口节点 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;

        System.out.println(entryOfLoop(node1));
    }

    static ListNode entryOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode low = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
            if (fast == low) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        low = pHead;
        while (fast != low) {
            fast = fast.next;
            low = low.next;
        }
        return low;
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
