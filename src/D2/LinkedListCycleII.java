package D2;

import common.ListNode;

import java.util.Arrays;

import static common.ListNode.generateNode;

public class LinkedListCycleII {
    public static void main(String[] args) {
        ListNode head = generateNode(Arrays.asList(3, 2, 0, -4));
        // 创建一个环
        head.next.next.next.next = head.next;
        System.out.println("last => " + head.next.next.next.val);
        System.out.println("loop => " + head.next.next.next.next.val);
        System.out.println("环的入口：" + getEnterPoint(head).val);

        ListNode listNode = generateNode(Arrays.asList(1, 2));
        listNode.next.next = listNode;
        System.out.println("环的入口：" + getEnterPoint(listNode).val);

    }

    private static ListNode getEnterPoint(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                ListNode pointA = slow;
                ListNode pointB = fast;
                while (pointA != pointB){
                    pointA = pointA.next;
                    pointB = pointB.next;
                }
                return pointA;
            }
        }
        return null;
    }
}
