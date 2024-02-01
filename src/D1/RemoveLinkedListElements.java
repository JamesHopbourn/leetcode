package D1;

import common.ListNode;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode listNode = ListNode.generateNode(10);
        ListNode temp = listNode;
        while (temp.next != null){
            System.out.print(temp.val);
            temp = temp.next;
        }
        System.out.println();
        ListNode result = removeElements(listNode, 3);
        while (result.next != null){
            System.out.print(result.val);
            result = result.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode prev = dummyHead;
        while (prev.next != null){
            if (val == prev.next.val){
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
}
