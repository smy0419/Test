/**
 * 字节算法题。
 * 求俩个单链表是否相交，输出第一个相交的节点
 * 时间复杂度和空间复杂度最低
 * 示例代码时间复杂度O(n^2)
 */
public class NodeTest {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;


        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node4.next = node5;
        node5.next = node1;

//        boolean flag = false;
        for (Node node = node1;node != null;node = node.next) {
//            System.out.println(node.i);
            Node currentNode = node;
            for (Node nodeTwo = node4;nodeTwo != null;nodeTwo = nodeTwo.next) {
//                System.out.println(nodeTwo.i);
                if (nodeTwo == currentNode) {
                    System.out.println("两个链相交");
//                    flag = true;
                    break;
                }
            }
        }
    }




    static class Node {
        int i;
        Node next;
        public Node (int i ){
            this.i = i;
        }

        public static  boolean hasNext(Node node) {
            return  node.next != null;
        }
    }
}
