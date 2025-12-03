package suixianglu.list;

public class MyLinkedList {

    // 双向链表内部类
    class ListNode {
        int val;
        ListNode next, prev;

        public ListNode() {}
        public ListNode(int val) {
            this.val = val;
        }
    }

    // 记录链表容量大小
    private int size;
    // 创建虚拟头尾节点
    private ListNode head, tail;

    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode(0);
        this.tail = new ListNode(0);
        this.head.next = tail;
        this.tail.prev = head;
    }

    // 获取链表中下标为 index 的节点的值
    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        ListNode cur = head.next;
        while (index >= 0) {
            if (index == 0) {
                return cur.val;
            }
            cur = cur.next;
            index--;
        }
        return -1;
    }

    // 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        size++;
    }

    // 将一个值为 val 的节点追加到链表中作为链表的最后一个元素
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        node.prev = tail.prev;
        size++;
    }

    // 将一个值为 val 的节点插入到链表中下标为 index 的节点之前
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0)
            return;

        ListNode cur = head;
        ListNode node = new ListNode(val);

        while (index >= 0) {
            if (index == 0) {
                node.next = cur.next;
                cur.next.prev = node;
                cur.next = node;
                node.prev = cur;
                break;
            }
            index--;
            cur = cur.next;
        }

        size++;
    }

    // 删除链表中下标为 index 的节点
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }

        ListNode cur = head;
        while (index >= 0) {
            if (index == 0) {
                cur.next.next.prev = cur;
                cur.next = cur.next.next;
                break;
            }
            index--;
            cur = cur.next;
        }
        size--;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
        System.out.println(myLinkedList.get(1));          // 返回 2
        myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
        System.out.println(myLinkedList.get(1));             // 返回 3
    }
}
