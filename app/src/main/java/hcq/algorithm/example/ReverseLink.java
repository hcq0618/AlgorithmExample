package hcq.algorithm.example;

/**
 * 输入一个链表的头结点，反转该链表，并返回反转后链表的头结点。
 * <p/>
 * 微软面试题
 * <p/>
 * Created by hcq0618 on 2016/1/7.
 */
public class ReverseLink {

    public static class Node {
        int n;
        Node next;

        public Node(int n, Node next) {
            this.n = n;
            this.next = next;
        }
    }

    public Node solution(Node node) {
        if (node == null)
            return null;

        Node next = node.next;
        node.next = null;
        Node preNode = node;

        while (next != null) {
            Node nextnext = next.next;
            next.next = preNode;
            preNode = next;

            next = nextnext;
        }

        return preNode;
    }
}
