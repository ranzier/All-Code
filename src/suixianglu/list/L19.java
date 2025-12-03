package suixianglu.list;

public class L19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        ListNode cur = removeNthFromEnd(head, 2);
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建虚拟头结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        // fast要移动n+1步
        while (n >= 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // 此时slow的下一个节点就是要删除的节点
        slow.next = slow.next.next;

        return dummy.next;
    }
}
