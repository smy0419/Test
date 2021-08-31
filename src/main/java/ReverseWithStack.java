import java.util.Stack;

/**
 * @author sunmengyuan
 * @date 2021-08-31
 * 利用栈的特性高效反转单向链表
 */
public class ReverseWithStack<T> {
    static class ListNode<T> {
        T val;
        ListNode<T> next;

        public ListNode(T val) {
            this.val = val;
        }
    }

    public ListNode<T> reverse(ListNode<T> head) {
        if (head == null || head.next == null) {
            return null;
        }
        Stack<ListNode<T>> stack = new Stack<>();
        ListNode<T> currentNode = head;
        while (currentNode != null) {
            stack.push(currentNode);
            ListNode<T> nextNode = currentNode.next;
            currentNode.next = null;
            currentNode = nextNode;
        }

        head = stack.pop();
        currentNode = head;
        while (!stack.isEmpty()) {
            currentNode.next = stack.pop();
            currentNode = currentNode.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ReverseWithStack<Integer> r = new ReverseWithStack<>();
        ListNode<Integer> head = new ListNode<>(0);
        ListNode<Integer> currentNode = head;
        for (int i = 1; i <= 5; i++) {
            if (currentNode.next == null) {
                ListNode<Integer> nextNode = new ListNode<>(i);
                currentNode.next = nextNode;
                currentNode = nextNode;
            }
        }
        head = r.reverse(head);
        System.out.println(head);
    }


}
