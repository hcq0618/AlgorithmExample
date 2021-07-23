package hcq.algorithm.example.interviews.garena;

import java.util.ArrayList;
import java.util.List;

/*删除单链表中倒数第N个节点
 example:
 [1,2,3], n=2
 output:
 [1,3]
 */
public class RemoveLastNthNode {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        n3.next = n4;
        ListNode n2 = new ListNode(2);
        n2.next = n3;
        ListNode n1 = new ListNode(1);
        n1.next = n2;

        //        ListNode result = removeLastNthNode(n1, 2);
        //        System.out.println(result == null ? null : result.next.val);

        //        ListNode result = removeLastNthNode2(n1, 3);
        //        System.out.println(result.next.val);

        ListNode result = removeLastNthNode3(n1, 3);
        System.out.println(result.next.val);
    }

    //方法1：单链表变成list
    public static ListNode removeLastNthNode(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }

        int size = list.size();
        if (n >= size) {
            return head;
        }
        if (size == 1) {
            return null;
        }

        int index = size - n;
        ListNode previous = list.get(index - 1);
        previous.next = list.get(index).next;
        return head;
    }

    //方法2：先反转链接 删除 再反转回去
    public static ListNode removeLastNthNode2(ListNode head, int n) {
        head = reverseLinkList(head);

        ListNode temp = head;
        while (n > 1) {
            temp = temp.next;
            n--;
        }

        ListNode previous = temp.next;

        head = reverseLinkList(head);

        previous.next = temp.next;

        return head;
    }

    private static ListNode reverseLinkList(ListNode head) {
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nextNode;

        while (curNode != null) {
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }

        return preNode;
    }

    //方法3：快慢指针 俩指针间隔为n 快指针先到头 循环停止 慢指针位置为倒数第N个节点
    public static ListNode removeLastNthNode3(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode previous = null;

        while (fast != null) {
            n--;
            if (n < 0) {
                previous = slow;
                slow = slow.next;
            }
            fast = fast.next;
        }

        if (previous != null) {
            previous.next = slow.next;
        }

        return head;
    }
}
