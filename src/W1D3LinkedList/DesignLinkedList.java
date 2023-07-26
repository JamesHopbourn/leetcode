package W1D3LinkedList;


import common.ListNode;

public class DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(0, 1);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.addAtIndex(2, 3);
        myLinkedList.addAtIndex(3, 4);
        myLinkedList.deleteAtIndex(2);

        for (int i = 0; i < myLinkedList.size; i++) {
            System.out.print(myLinkedList.get(i) + " ");
        }
    }

    
    static class MyLinkedList {
        int size;
        ListNode dummyNode;

        // 初始化链表
        public MyLinkedList(){
            size = 0;
            dummyNode = new ListNode();
        }

        // 在指定位置添加
        public void addAtIndex(int index, int val){
            // 判断不要超出范围
            if (index > size){
                return;
            }
            // 要考虑第一次添加的时候，index = 0
            if (index < 0){
                index = 0;
            }
            // 链表记录长度加一
            size++;
            ListNode prev = dummyNode;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            ListNode listNode = new ListNode(val);
            listNode.next = prev.next;
            prev.next = listNode;
        }

        /**
         * 获取链表元素
         */
        public int get(int index){
            // 范围合法性判断
            if (index < 0 || index > size - 1){
                return -1;
            }
            ListNode curr = dummyNode;
            /*
              特别要注意此处是 i <= index 或者是 i < index + 1
              包含了一个空节点，所以 index 需要加一
             */
            for (int i = 0; i < index + 1; i++) {
                curr = curr.next;
            }
            return curr.val;
        }

        public void deleteAtIndex(int index){
            if (index < 0 || index > size - 1){
                return;
            }
            // 经过上面判断可以进行下一步了，就把 size 减一
            size--;
            ListNode prev = dummyNode;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }
            prev.next = prev.next.next;
        }
    }
}
