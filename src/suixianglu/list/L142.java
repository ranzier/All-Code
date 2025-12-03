package suixianglu.list;

public class L142 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = head.next.next;
        ListNode cur = detectCycle(head);
        System.out.print(cur.val);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 找到快慢指针相遇处，判断是否有环
            if (slow == fast) {
                ListNode cur = head;
                // 有环的话，头结点和slow同时往后移动，他们相遇的节点就是环入口
                while (cur != slow) {
                    cur = cur.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
