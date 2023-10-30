package D1;

import common.ListNode;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode listNode = ListNode.generateNode(10);
        ListNode result = removeNthFromEnd(listNode, 4);
        ListNode.printList(result);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        for (int i = 0; i <=n ; i++) {
            fast = fast.next;
        }
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }
}
