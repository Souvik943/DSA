package org.example.patterns.Heaps;

import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        // Create a Min-Heap. By default, Java's PriorityQueue is a Min-Heap.
        // It keeps the smallest element at the top.
        PriorityQueue<Integer> priority_queue = new PriorityQueue<>();

        // Iterate through each number in the input array
        for(int i : nums) {
            // Add the current number to the heap
            priority_queue.add(i);

            // If our heap grows larger than K, we have too many elements.
            // We only care about the top K largest elements.
            if(priority_queue.size() > k) {
                // Remove the top element.
                // Since it's a Min-Heap, this removes the smallest element currently in the heap,
                // leaving only the larger elements behind.
                priority_queue.poll();
            }
        }

        // After the loop, the heap contains exactly the K largest elements.
        // The top of the Min-Heap is the smallest of those K elements,
        // which makes it the Kth largest element overall.
        return priority_queue.peek();
    }
}
