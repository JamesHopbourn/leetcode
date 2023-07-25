package W1D3.entity;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode next() {
        return next;
    }

    public int val(){
        return val;
    }

    public static void printList(ListNode head){
        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode generateNode(int n){
        ListNode head = new ListNode(0, null);
        ListNode curr = head;
        for (int i = 1; i <= n; i++) {
            curr.next = new ListNode(i, null);
            curr = curr.next;
        }
        return head;
    }

    public static ListNode generateNode(List<Integer> integerList) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        for (int val : integerList) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummyHead.next;
    }
}
