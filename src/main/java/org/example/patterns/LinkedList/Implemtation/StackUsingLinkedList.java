package org.example.patterns.LinkedList.Implemtation;

public class StackUsingLinkedList {
    SLL linkedList = new SLL();

    // Push: Add to the START (Head) -> O(1)
    public ListNode push(ListNode head, int data) {
        return linkedList.insertAtStart(head, data);
    }

    // Pop: Remove from the START (Head) -> O(1)
    public ListNode pop(ListNode head) {
        return linkedList.deleteFromStart(head);
    }

    // Peek: Just look at the Head's value -> O(1)
    public int peek(ListNode head) {
        if (head == null) return -1;
        return head.val;
    }
}
