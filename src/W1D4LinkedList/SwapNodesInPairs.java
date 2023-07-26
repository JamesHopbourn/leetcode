package W1D4LinkedList;


import common.ListNode;

import static common.ListNode.printList;

/**
 * https://www.bilibili.com/video/BV1YT411g7br/
 * https://programmercarl.com/0024.%E4%B8%A4%E4%B8%A4%E4%BA%A4%E6%8D%A2%E9%93%BE%E8%A1%A8%E4%B8%AD%E7%9A%84%E8%8A%82%E7%82%B9.html
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int i = 1; i < 5; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        printList(head);
//        ListNode node = function(head);
        ListNode node = func(head);
        printList(node);
    }

    public static ListNode function(ListNode head){
        // base case 退出提交
        if(head == null || head.next == null) return head;
        // 获取当前节点的下一个节点
        ListNode next = head.next;
        // 进行递归
        ListNode newNode = function(next.next);
        // 这里进行交换
        next.next = head;
        head.next = newNode;

        return next;
    }

    public static ListNode func(ListNode head){
        ListNode dummyNode = new ListNode(-1, head);
        ListNode curr = dummyNode;
        ListNode firstNode;
        ListNode thirdNode;
        while (curr.next != null && curr.next.next != null){
            // 保存两个节点
            firstNode = curr.next;
            thirdNode = curr.next.next.next;
            // 链接节点
            curr.next = curr.next.next;
            curr.next.next = firstNode;
            curr.next.next.next = thirdNode;
            // 移动
            curr = curr.next.next;
        }
        return dummyNode.next;
    }
}
                     