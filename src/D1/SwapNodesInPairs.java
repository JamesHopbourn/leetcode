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
        ListNode pre = new ListNode(0, head);
        ListNode curr = pre;
        while(curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            curr.next = second;
            first.next = second.next;
            second.next = first;
            curr = first;
        }
        return pre.next;
    }


    /**
     *         // 创建一个虚拟头节点，并将其指向传入的头节点
     *         ListNode pre = new ListNode(0, head);
     *         // 创建一个指针 curr，指向虚拟头节点
     *         ListNode curr = pre;
     *
     *         // 循环条件：当前节点的下一个节点和下一个节点的下一个节点都不为空
     *         while (curr.next != null && curr.next.next != null) {
     *             // 定义两个指针，分别指向相邻的两个节点
     *             ListNode first = curr.next;
     *             ListNode second = curr.next.next;
     *
     *             // 调整节点的指向关系，实现节点交换
     *             curr.next = second;         // 将当前节点的下一个节点指向第二个节点
     *             first.next = second.next;   // 将第一个节点的下一个节点指向第二个节点的下一个节点，断开与第二个节点的连接
     *             second.next = first;        // 将第二个节点的下一个节点指向第一个节点，完成节点交换
     *
     *             // 将 curr 指向已经完成交换的节点，为下一次交换做准备
     *             curr = first;
     *         }
     *
     *         // 返回虚拟头节点的下一个节点，即交换后的链表头
     *         return pre.next;
     */
}
