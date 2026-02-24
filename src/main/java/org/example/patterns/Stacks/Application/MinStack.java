package org.example.patterns.Stacks.Application;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        // Initialize two stacks: one for data, one for tracking minimums
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        // Always push to the main stack
        stack.push(val);

        // Push to minStack ONLY if it's the new minimum (or equal to current min)
        // We use <= to handle duplicate minimums (e.g., pushing 2, then 0, then 0)
        if(minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        // If we are removing the current minimum from the main stack,
        // we must also remove it from the minStack to keep them in sync.
        // Use .equals() for object comparison!
        if(!stack.isEmpty() && stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        // Always pop from the main stack
        stack.pop();
    }

    public int top() {
        // View the top of the main stack
        return stack.peek();
    }

    public int getMin() {
        // BUG FIX: Use peek(), not pop(). We want to SEE the min, not remove it.
        return minStack.peek();
    }
}
