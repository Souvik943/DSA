package org.example.patterns.LinkedList.Implemtation;

import org.example.patterns.LinkedList.Implemtation.ListNode;

public class QueueUsingLinkedList {
    // We need stateful pointers, not just a helper class
    private ListNode head;
    private ListNode tail;

    // Enqueue: Add to Back -> O(1)
    public void enqueue(int data) {
        ListNode newNode = new ListNode(data);

        // Case 1: Queue is empty
        if (this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }

        // Case 2: Queue has items
        // 1. Link current tail to new node
        this.tail.next = newNode;
        // 2. Move tail pointer to the new end
        this.tail = newNode;
    }

    // Dequeue: Remove from Front -> O(1)
    public int dequeue() {
        // Edge Case: Empty queue
        if (this.head == null) return -1;

        int value = this.head.val;

        // Move head forward
        this.head = this.head.next;

        // Edge Case: If queue became empty, tail must also be null
        if (this.head == null) {
            this.tail = null;
        }

        return value;
    }

    // Peek: Look at Front -> O(1)
    public int peek() {
        if (this.head == null) return -1;
        return this.head.val;
    }

    // Check if empty
    public boolean isEmpty() {
        return head == null;
    }
}