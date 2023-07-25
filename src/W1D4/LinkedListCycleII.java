package W1D4;

import W1D3.entity.ListNode;

import java.util.Arrays;

import static W1D3.entity.ListNode.generateNode;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 * https://www.bilibili.com/video/BV1if4y1d7ob/
 * https://ls8sck0zrg.feishu.cn/wiki/RrmGw6MYBikTfDkF7uyciOzAnuc
 */

/**
 * ----x----------
 *       |       |
 *       z       y
 *       |       |
 *       ----*----
 * slow = x + y
 * fast = x + y + n(y+z)
 * 因为 fast 比 slow 快一倍，建立倍数关系
 * 2slow = fast
 * 2(x + y) = x + y + n(y + z)
 * x + y = n(y + z)
 * x + y = n(y + z)
 * x + y = (y + z) + (n - 1)(y + z)
 * x = z + (n - 1)(y + z)
 * 令 n = 1
 * x = z
 */
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

    public static ListNode getEnterPoint(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                ListNode pointA = fast;
                ListNode pointB = slow;
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
