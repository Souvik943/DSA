package org.example.patterns.Heaps;

import java.util.PriorityQueue;

public class KLargestElements {
    public int[] kLargest(int[] arr, int n, int k) {
        // Step 1: Create a Min-Heap to track the K largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Step 2: Process the array
        for(int i : arr) {
            minHeap.add(i);

            // If we have more than K elements, toss out the smallest one
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Step 3: Extract the elements into an array
        // We need an array of size K to store our result
        int[] result = new int[k];

        // Since we want non-decreasing (ascending) order, we can just pop directly.
        // The Min-Heap will give us the smallest of the K elements first,
        // then the next smallest, all the way to the absolute largest element.
        for(int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
