import java.util.HashSet;

public class LinkedList {
    ListNode head;

    public void removeDuplicates() {
        if (head == null) {
            return;
        }

        HashSet<Integer> seen = new HashSet<>();
        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            if (seen.contains(current.value)) {
                // Duplicate found; remove it
                previous.next = current.next;
            } else {
                // Not a duplicate; add it to the set
                seen.add(current.value);
                previous = current;
            }
            current = current.next;
        }
    }

    // Helper method to print the linked list
    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to add nodes to the linked list for testing
    public void add(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2); // Duplicate
        list.add(4);
        list.add(1); // Duplicate

        System.out.println("Original list:");
        list.printList();

        list.removeDuplicates();

        System.out.println("List after removing duplicates:");
        list.printList();
    }
}