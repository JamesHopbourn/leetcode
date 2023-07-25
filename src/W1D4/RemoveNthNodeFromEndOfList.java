package W1D4;


import W1D3.entity.ListNode;

import static W1D3.entity.ListNode.generateNode;
import static W1D3.entity.ListNode.printList;

/**
 * https://www.bilibili.com/video/BV1vW4y1U7Gf/
 * https://ls8sck0zrg.feishu.cn/wiki/RrmGw6MYBikTfDkF7uyciOzAnuc
 * https://programmercarl.com/0019.%E5%88%A0%E9%99%A4%E9%93%BE%E8%A1%A8%E7%9A%84%E5%80%92%E6%95%B0%E7%AC%ACN%E4%B8%AA%E8%8A%82%E7%82%B9.html
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode node = generateNode(3);
        printList(node);
        ListNode result = function(node, 2);
        printList(result);
    }

    public static ListNode function(ListNode head, int index){
        ListNode dummyHead = new ListNode(-1, head);
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;

        // 快指针先走
        // TODO 为什么是 i < index
        /*
        原始：0 -> 1 -> 2 -> 3 -> NULL
        虚拟：D -> 0 -> 1 -> 2 -> 3 -> NULL
        指针：D(Slow) -> 0 -> 1(Fast) -> 2 -> 3 -> NULL
        前进：D -> 0 -> 1(Slow) -> 2 -> 3(Fast) -> NULL
        链接：slow.next = slow.next.next;
        返回：dummyHead.next
         */
        for (int i = 0; i < index; i++) {
            fast = fast.next;
        }

        System.out.println("快指针指向 => " + fast.val);
        // 中止条件是 fast.next 已经走到尾了
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        // 已经走到尾之后可以进行链表重新链接
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
