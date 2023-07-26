package W1D3LinkedList;


import common.ListNode;

import static common.ListNode.printList;

public class ReverseLinkedListAgain {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int i = 1; i < 5; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        printList(head);
        ListNode reverse = reverse(head);
        printList(reverse);
    }

    public static ListNode reverse(ListNode head){
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
