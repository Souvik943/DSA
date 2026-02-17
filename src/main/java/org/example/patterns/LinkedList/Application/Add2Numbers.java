package org.example.patterns.LinkedList.Application;

import org.example.patterns.LinkedList.Implemtation.ListNode;

//- **Column Addition:** Just like elementary math, add digits column by column from right to left (head to tail).
//- **Handle Mismatch:** If one list is shorter than the other, treat the missing nodes as `0`.
//- **The "Or" Loop:** Run the loop while `l1` exists **OR** `l2` exists **OR** we have a leftover `carry`. This handles all edge cases in one go.
//- **Trailing Carry:** If the sum of the last two digits is > 9 (e.g., 5 + 5), you must create one extra node at the end for the `1`.

public class Add2Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Placeholder for result start
        ListNode curr = dummyHead; // Pointer to build the new list
        int carry = 0;

        // Run if l1 has nodes OR l2 has nodes OR we still have a carry
        while(l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0; // If l1 is null, use 0
            int val2 = (l2 != null) ? l2.val : 0; // If l2 is null, use 0

            // 1. Calculate Sum
            int sum = val1 + val2 + carry;
            carry = sum / 10;

            // 2. Create new node for the digit (sum % 10)
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            // 3. Move pointers forward if possible
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next; // Return the actual list
    }
}
