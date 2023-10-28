package codingPatterns;

public class FastSlowPointersPattern {
    public int findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // Move slow one step
            fast = fast.next.next;   // Move fast two steps
        }

        assert slow != null;
        return slow.val; // Return the value of the middle element
    }

    public static void main(String[] args) {
        FastSlowPointersPattern fastSlowPointers = new FastSlowPointersPattern();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int middle = fastSlowPointers.findMiddle(head);
        System.out.println("Middle element: " + middle);
    }
}
