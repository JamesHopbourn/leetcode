package D2;

import common.ListNode;

import java.util.Arrays;

import static common.ListNode.generateNode;

public class DetectCycle {
    public static void main(String[] args) {
        ListNode head = generateNode(Arrays.asList(3, 2, 0, -4));
        // 创建一个环
        head.next.next.next.next = head.next;
        System.out.println("last => " + head.next.next.next.val);
        System.out.println("loop => " + head.next.next.next.next.val);

        System.out.println(detectCycle(head));

    }

    public static boolean detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast =fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return false;
    }

}
