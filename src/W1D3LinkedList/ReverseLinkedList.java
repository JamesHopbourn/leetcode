package W1D3LinkedList;


import common.ListNode;

/**
 * https://leetcode.cn/problems/reverse-linked-list/
 * https://www.bilibili.com/video/BV1nB4y1i7eL/
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(0, null);
        ListNode curr = head;
        for (int i = 1; i < 5; i++) {
            curr.next = new ListNode(i, null);
            curr = curr.next;
        }
        // 输出                            
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        // 反转
        System.out.println();
        ListNode prev = null, next = null;
        while (head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        // 输出
        while (prev != null){
            System.out.print(prev.val + " ");
            prev = prev.next;
        }

    }

    public static ListNode reverseList(ListNode head) {
       ListNode curr = head;
       ListNode prev = null;
       ListNode temp = null;
       while (curr != null){
        temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
       }
       // 这里要想清楚，curr 在最前面指向 null， prev 才是新的头节点
       return prev;
    }
    
}
