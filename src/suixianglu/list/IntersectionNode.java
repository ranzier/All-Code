package suixianglu.list;

public class IntersectionNode {
    public static void main(String[] args) {
        ListNode headA = new ListNode(0);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(2);
        headA.next.next.next = new ListNode(3);

        ListNode headB = new ListNode(9);
        headB.next = headA.next.next;

        ListNode cur = getIntersectionNode(headA, headB);
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode list1 = headA;
        ListNode list2 = headB;

        while (list1 != list2) {
            if (list1 == null)
                list1 = headB;
            else list1 = list1.next;
            if (list2 == null)
                list2 = headA;
            else list2 = list2.next;
        }

        return list1;
    }
}
