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
        node.next.next.next.next.next = new ListNode(6);

        ListNode x = reverseWithLoop(node);
        System.out.println(x.val);

    }

    /**
     * 递归反转链表
     *
     * @param head
     * @return
     */
    static ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 循环反转链表
     *
     * @param head
     * @return
     */
    static ListNode reverseWithLoop(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
