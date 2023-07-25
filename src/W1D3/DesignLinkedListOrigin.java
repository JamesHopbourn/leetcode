package W1D3;


import W1D3.entity.ListNode;

public class DesignLinkedListOrigin {
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(2);
        obj.addAtTail(3);
        obj.addAtIndex(0,1);
        int param_1 = obj.get(2);
        System.out.println("param_1 = " + param_1);
        obj.deleteAtIndex(2);

        for (int i = 0; i < obj.size; i++) {
            System.out.println(obj.get(i));
        }
    }


    static class MyLinkedList {
        // size存储链表元素的个数
        int size;
        // 虚拟头结点
        ListNode dummyHead;
        // 初始化链表
        public MyLinkedList() {
            size = 0;
            dummyHead = new ListNode(0);
        }
        // 获取第index个节点的数值
        public int get(int index) {
            // 如果index非法，返回-1
            if (index < 0 || index > size - 1) {
                return -1;
            }
            ListNode currentNode = dummyHead;
            // 包含一个虚拟头节点，所以查找第 index+1 个节点
            for (int i = 0 ; i <= index ; i++) {
                currentNode = currentNode.next;
            }
            return currentNode.val;
        }
        // 在链表最前面插入一个节点
        public void addAtHead(int val) {
            addAtIndex(0 , val);
        }
        // 在链表的最后插入一个节点
        public void addAtTail(int val) {
            addAtIndex(size , val);
        }
        // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
        // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
        // 如果 index 大于链表的长度，则返回空
        public void addAtIndex(int index , int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            size++;
            // 找到要插入节点的前驱
            ListNode pred = dummyHead;
            for (int i = 0 ; i < index ; i++) {
                pred = pred.next;
            }
            ListNode toAdd = new ListNode(val);
            toAdd.next = pred.next;
            pred.next = toAdd;
        }

        // 删除第index个节点
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            size--;
            ListNode pred = dummyHead;
            for (int i = 0 ; i < index ; i++) {
                pred = pred.next;
            }
            pred.next = pred.next.next;
        }
    }

}
