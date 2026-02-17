package org.example.patterns.LinkedList.Implemtation;

public class SLL {

    // ----------------- Insertions -----------------

    public ListNode insertAtStart(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        // Link new node to current head
        newNode.next = head;
        // Return new node as the new head
        return newNode;
    }

    public ListNode insertAtEnd(ListNode head, int data) {
        ListNode newNode = new ListNode(data);

        // Edge Case: List is empty, new node is the head
        if (head == null) return newNode;

        ListNode currNode = head;
        // Traverse to the very last node
        while(currNode.next != null) {
            currNode = currNode.next;
        }

        // Link last node to new node
        currNode.next = newNode;
        return head;
    }

    public ListNode insertAtPos(ListNode head, int pos, int data) {
        // Edge Case: Insert at start (index 0)
        if (pos == 0) return insertAtStart(head, data);

        // Edge Case: List is empty but pos > 0 (Invalid, but handle gracefully)
        if (head == null) return null;

        ListNode newNode = new ListNode(data);
        ListNode currNode = head;

        // Stop at the node BEFORE the position (pos - 1)
        for(int i = 0; i < pos - 1 && currNode != null; i++) {
            currNode = currNode.next;
        }

        // Safety: If pos was out of bounds
        if (currNode == null) return head;

        // Link: prev -> newNode -> next
        newNode.next = currNode.next;
        currNode.next = newNode;

        return head;
    }

    // ----------------- Deletions -----------------

    public ListNode deleteFromStart(ListNode head) {
        // Edge Case: Empty list
        if (head == null) return null;

        // Move head to the next node, effectively deleting the first
        return head.next;
    }

    public ListNode deleteFromEnd(ListNode head) {
        // Edge Case 1: Empty list
        if (head == null) return null;

        // Edge Case 2: Only one node (delete it -> list becomes empty)
        if (head.next == null) return null;

        ListNode currNode = head;
        // Stop at the SECOND to last node
        while(currNode.next.next != null) {
            currNode = currNode.next;
        }

        // Remove reference to the last node
        currNode.next = null;
        return head;
    }

    public ListNode deleteFromPos(ListNode head, int pos) {
        // Edge Case: Empty list
        if (head == null) return null;

        // Edge Case: Delete start (index 0)
        if (pos == 0) return deleteFromStart(head);

        ListNode currNode = head;
        // Stop at the node BEFORE the target (pos - 1)
        for(int i = 0; i < pos - 1 && currNode.next != null; i++) {
            currNode = currNode.next;
        }

        // Safety: If pos is out of bounds or target is null
        if (currNode.next == null) return head;

        // Link: prev -> next.next (Skip the target node)
        currNode.next = currNode.next.next;

        return head;
    }
}