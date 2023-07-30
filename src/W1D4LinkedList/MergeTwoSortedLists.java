package W1D4LinkedList;

import common.ListNode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/">21. 合并两个有序链表 - 力扣（LeetCode）</a>
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/">合并两个有序链表</a>
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode listNode = mergeTwoLists(ListNode.generateNode(Arrays.asList(1, 3, 4)), ListNode.generateNode(Arrays.asList(1, 2, 4)));
        ListNode.printList(listNode);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        curr.next = list1 == null ? list1 : list2;
        return dummy.next;
    }
}
