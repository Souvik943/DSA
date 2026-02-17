package org.example.patterns.LinkedList.Application;

import org.example.patterns.LinkedList.Implemtation.ListNode;

//**Intuition** :
//
//The intuition using the "Two Pointer Gap" strategy.
//
//- Send the `curr` (fast) pointer `n` steps ahead of the `node` (slow) pointer to create a fixed window size.
//- Move both pointers forward at the same speed until the fast pointer hits the end (`null`).
//- Because of the gap, the slow pointer will stop exactly at the node **before** the target node.
//- Change the slow pointer's `next` reference to skip the target node, effectively removing it.

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy Node: Handles the edge case where we need to delete the Head itself
        ListNode dummyNode = new ListNode(0, head);
        ListNode left = dummyNode; // Slow pointer (starts at dummy)
        ListNode right = head;     // Fast pointer (starts at head)

        // 1. Create the gap of size N
        // Move 'right' pointer N steps forward
        for(int i=0; i<n; i++) {
            right = right.next;
        }

        // 2. Slide the window until 'right' hits the end
        // This maintains the gap so 'left' lands right before the target
        while(right != null) {
            right = right.next;
            left = left.next;
        }

        // 3. Delete the target node
        // 'left' is now just before the node to be removed
        left.next = left.next.next;

        return dummyNode.next;
    }
}
