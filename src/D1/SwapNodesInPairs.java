package D1;

import common.ListNode;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode listNode = ListNode.generateNode(10);
        ListNode.printList(listNode);
        ListNode nodeResult = swapPairs(listNode);
        ListNode.printList(nodeResult);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode curr =dummy;
        ListNode firstNode;
        ListNode thirdNode;
        while (curr.next != null && curr.next.next != null){
            firstNode = curr.next;
            thirdNode = curr.next.next.next;

            curr.next = curr.next.next;
            curr.next.next = firstNode;
            curr.next.next.next = thirdNode;

            curr = curr.next.next;
        }
        return dummy.next;
    }
}
