/**
 * @author sunmengyuan
 * @date 2021-07-07
 */
public class ReverseListNode {
    static class ListNode {
        private int val;
        private ListNode next;
        private ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode x = reverse(node);
        System.out.println(x);

    }

    static ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
