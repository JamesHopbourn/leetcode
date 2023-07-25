package W1D3;


import W1D3.entity.ListNode;

/**
 * https://www.bilibili.com/video/BV1Lg411K7py/
 */
public class Reverse {
    public static void main(String[] args) {
        ListNode head = new ListNode(0, null);
        ListNode cur = head;
        for (int i = 1; i < 4; i++) {
            cur.next = new ListNode(i, null);
            cur = cur.next;
        }

        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

        System.out.println("**************");

        //反转链表
        ListNode node = reverseLinkedList(head);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static ListNode reverseLinkedList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode prev = null, next = null;
        while (head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 反转链表
     **/
    private static ListNode reverseLinkedList(ListNode head, int a) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null, next = null;
        while (head.next != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head.next = prev;
        return head;
    }

}
