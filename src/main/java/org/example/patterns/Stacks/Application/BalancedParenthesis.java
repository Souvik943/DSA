package org.example.patterns.Stacks.Application;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParenthesis {
    public boolean isValid(String s) {
        // 1. QUICK CHECK
        // Odd length strings can never be valid pairs
        if(s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        // 2. MAPPING
        // Map closing brackets to their corresponding opening brackets
        Map<Character, Character> parenthesisMap = new HashMap<>();
        parenthesisMap.put(')', '(');
        parenthesisMap.put('}', '{');
        parenthesisMap.put(']', '[');

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            // 3. OPENING BRACKET?
            // If it's an opener, push it onto the stack to wait for a closer
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // 4. CLOSING BRACKET?
                // Check two conditions:
                // a) Stack is NOT empty (meaning there is an opener available)
                // b) The correct opener for this closer is at the top of the stack
                if(!stack.isEmpty() && parenthesisMap.get(c) == stack.peek()) {
                    stack.pop(); // Valid pair found, remove the opener
                } else {
                    return false; // Invalid: Either stack was empty or types didn't match
                }
            }
        }

        // 5. FINAL VERDICT
        // Stack must be empty; otherwise, we have unclosed openers left
        return stack.isEmpty();
    }
}
