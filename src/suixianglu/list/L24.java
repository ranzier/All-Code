package suixianglu.list;

public class L24 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        ListNode cur = swapPairs(head);
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
    }


    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0); // 虚拟头结点
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next; // 要交换的第一个节点
            ListNode end = cur.next.next;  // 要交换的第二个节点

            first.next = end.next;
            cur.next = end;
            end.next = first;
            cur = first;
        }
        return dummy.next;
    }
}
