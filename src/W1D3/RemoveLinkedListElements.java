package W1D3;


import W1D3.entity.ListNode;

/**
 * https://www.bilibili.com/video/BV18B4y1s7R9/
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(6);
        ListNode listNode1 = new ListNode(5, listNode);
        ListNode listNode2 = new ListNode(4, listNode1);
        ListNode listNode3 = new ListNode(3, listNode2);
        ListNode listNode4 = new ListNode(6, listNode3);
        ListNode listNode5 = new ListNode(2, listNode4);
        ListNode node = new ListNode(1, listNode5);

        while (node.next != null){
            System.out.print(node.val() + " ");
            node = node.next;
        }

        ListNode function = dummy(node, 6);

        while (function.next != null){
            System.out.print(node.val() + " ");
            node = node.next;
        }
    }

    public static ListNode dummy(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        while (prev.next != null){
            if (prev.next.val == val){
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummy.next;
    }

    public static ListNode function(ListNode head, int target){
        while (head != null && head.val() == target){
            head = head.next;
        }
        ListNode curr = head;
        while (curr != null && curr.next != null){
            if (curr.next.val() == target){
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
