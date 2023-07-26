package W1D4LinkedList;

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/
 */

import common.ListNode;

import java.util.Arrays;

import static common.ListNode.generateNode;

/**
 * * https://programmercarl.com/%E9%9D%A2%E8%AF%95%E9%A2%9802.07.%E9%93%BE%E8%A1%A8%E7%9B%B8%E4%BA%A4.html
 * TODO 另外一种思路是把 A 的尾节点指向 B 的头节点，然后判断是否有环
 * https://www.bilibili.com/video/BV1u341187v3/
 */

public class IntersectionOfTwoLinkedListsLcci {
    public static void main(String[] args) {
        ListNode listNodeA = generateNode(Arrays.asList(1, 2, 3, 4, 5, 6));
        ListNode listNodeB = generateNode(Arrays.asList(7, 8, 4, 5, 6));

        // 找到 A 的尾节点
        ListNode curr = listNodeA;
        while (curr.next != null){
            curr = curr.next;
        }
        // 链接 A尾 B头
        curr.next = listNodeB;
        // 创建快慢指针
        ListNode fast, slow = listNodeA;
        
    }
}
