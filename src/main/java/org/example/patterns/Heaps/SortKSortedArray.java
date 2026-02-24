package org.example.patterns.Heaps;

import java.util.PriorityQueue;

public class SortKSortedArray {
    public static int[] nearlySorted(int[] array, int n, int k) {
        // Create a Min-Heap.
        // We will use this to find the minimum element in our current "window" of size K+1.
        PriorityQueue<Integer> priority_queue = new PriorityQueue<>();

        int[] result = new int[n];
        int c = 0; // Pointer for the next available slot in our result array

        // Iterate through the nearly sorted array
        for(int i : array) {
            // Add the current element to the heap
            priority_queue.add(i);

            // If the heap size goes beyond K (meaning it has K+1 elements),
            // the smallest element in the heap is GUARANTEED to be the correct
            // element for index 'c' because elements can only move at most K steps.
            if(priority_queue.size() > k) {
                result[c] = priority_queue.poll(); // Lock it into its final sorted position
                c++; // Move to the next slot in the result array
            }
        }

        // The array is fully processed, but we still have K elements left in the heap.
        // Because it's a Min-Heap, popping them will naturally yield them in sorted order.
        while(!priority_queue.isEmpty()) {
            result[c] = priority_queue.poll();
            c++;
        }

        return result;
    }
}
