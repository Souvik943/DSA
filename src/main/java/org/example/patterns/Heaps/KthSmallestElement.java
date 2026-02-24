package org.example.patterns.Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static int kthSmallest(int n, int k, int[] arr) {
        // Create a Max-Heap by passing Comparator.reverseOrder().
        // It keeps the largest element at the top.
        PriorityQueue<Integer> priority_queue = new PriorityQueue<>(Comparator.reverseOrder());

        // Iterate through each number in the input array
        for(int i : arr) {
            // Add the current number to the heap
            priority_queue.add(i);

            // If our heap grows larger than K, we have too many elements.
            if(priority_queue.size() > k) {
                // Remove the top element.
                // Since it's a Max-Heap, this pops the largest element currently in the heap,
                // effectively tossing out the big numbers and keeping the K smallest ones.
                priority_queue.poll();
            }
        }

        // The heap now contains exactly the K smallest elements.
        // The top of the Max-Heap is the largest of those K elements,
        // making it the Kth smallest element overall.
        return priority_queue.poll(); // .peek() works exactly the same here!
    }
}
