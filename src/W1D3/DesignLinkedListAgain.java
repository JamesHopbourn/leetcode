package W1D3;

import W1D3.entity.ListNode;

/**
 * https://leetcode.cn/problems/design-linked-list/
 * https://www.bilibili.com/video/BV1FU4y1X7WD/
 */
public class DesignLinkedListAgain {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(0, 1);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.addAtIndex(2, 3);
        myLinkedList.addAtIndex(3, 4);
        myLinkedList.deleteAtIndex(1);

        for (int i = 0; i < myLinkedList.size; i++) {
            System.out.print(myLinkedList.get(i) + " ");
        }
    }
    

    /**
     *  增加和删除不用关心 index 范围
     *  但是查询需要，前面包含了一个 dummy 节点，如果不 +1 就无法查询到正确的 val
     */
    static class MyLinkedList {
        // 参数
        int size;
        ListNode dummy;

        // 初始化
        public MyLinkedList() {
            size = 0;
            dummy = new ListNode();
        }

        // 增加
        public void addAtIndex(int index, int val){
            if (index > size){
                return;
            }
            if (index < 0){
                index = 0;
            }
            size++;
            ListNode prev = dummy;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            ListNode node = new ListNode(val);
            node.next = prev.next;
            prev.next = node;
        }

        // 查询
        public int get(int index){
            if (index < 0 || index > size - 1){
                return -1;
            }
            ListNode curr = dummy;
            for (int i = 0; i < index + 1; i++) {
                curr = curr.next;
            }
            return curr.val;
        }

        // 删除
        public void deleteAtIndex(int index){
            if (index < 0 || index > size -1){
                return;
            }
            size--;
            ListNode curr = dummy;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
    }
}
