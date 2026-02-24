package org.example.patterns.LinkedList.Application;

import org.example.patterns.LinkedList.Implemtation.ListNode;

public class ReverseKNodesInAGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 1. CHECK LENGTH
        // See if we have at least k nodes left
        int count = 0;
        ListNode temp = head;
        while(count < k) {
            if(temp == null) {
                return head; // Base case: Less than k nodes, don't reverse
            }
            temp = temp.next;
            count++;
        }

        // 2. RECURSION
        // 'temp' is now at the (k+1)th node.
        // Recursively solve for the rest of the list first.
        // 'reversedHead' initially holds the head of the *next* reversed group.
        ListNode reversedHead = reverseKGroup(temp, k);

        // 3. REVERSE CURRENT GROUP
        // We use 'reversedHead' as our 'prev' pointer here
        temp = head;
        count = 0;
        while(count < k) {
            ListNode nextNode = temp.next;

            // Link current node to the 'prev' (which starts as the next group's head)
            temp.next = reversedHead;

            // Move 'prev' forward to current node
            reversedHead = temp;

            // Move current forward
            temp = nextNode;
            count++;
        }

        // Return the new head of this reversed group
        return reversedHead;
    }
}
