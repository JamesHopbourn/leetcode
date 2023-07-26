package W1D4LinkedList;


import common.ListNode;

import java.util.Arrays;

import static common.ListNode.generateNode;
import static common.ListNode.printList;

/**
 * https://www.bilibili.com/video/BV1Wi4y1R7P7/
 * https://leetcode.cn/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode listA = generateNode(Arrays.asList(9, 7));
        ListNode listB = generateNode(Arrays.asList(6, 6));
        // 因为计算的长度位置，直接使用虚拟节点来存储结果
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int sum = 0;
        while (listA != null || listB != null || sum != 0) {
            if (listA != null) {
                sum += listA.val;
                listA = listA.next;
            }
            if (listB != null) {
                sum += listB.val;
                listB = listB.next;
            }
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            // 不用再创建一个进位的变量，直接使用 sum/10 去参与下一轮的运算
            sum /= 10;
        }
        printList(dummy.next);
    }
}
