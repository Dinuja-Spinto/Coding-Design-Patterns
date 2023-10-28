package codingPatterns;

public class InPlaceReversalPattern {
    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {
            next = current.next; // Store the next node

            // Reverse the link
            current.next = previous;

            // Move to the next nodes
            previous = current;
            current = next;
        }

        // Update the head to the last node
        head = previous;

        return head;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        InPlaceReversalPattern reversalPattern = new InPlaceReversalPattern();

        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original Linked List:");
        printLinkedList(head);

        head = reversalPattern.reverse(head);

        System.out.println("Reversed Linked List:");
        printLinkedList(head);
    }
}
