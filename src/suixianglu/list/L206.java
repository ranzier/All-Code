package suixianglu.list;

public class L206 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        ListNode cur = reverseList(head);
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
    }


    public static ListNode reverseList(ListNode head) {
        ListNode cur = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = cur;
            cur = head;
            head = nextNode;
        }
        return cur;
    }
}