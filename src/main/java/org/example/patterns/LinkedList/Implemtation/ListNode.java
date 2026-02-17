package org.example.patterns.LinkedList.Implemtation;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int data) {
        this.val = data;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
