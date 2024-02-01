package D1;

import common.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode listNode = ListNode.generateNode(10);
        ListNode.printList(reverseList(listNode));

    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, next = null;
        ListNode curr = head;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
