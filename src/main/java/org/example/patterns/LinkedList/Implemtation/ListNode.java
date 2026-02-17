package org.example.patterns.LinkedList.Implemtation;

public class ListNode {
    int val;
    public ListNode next;

    ListNode() {}
    ListNode(int data) {
        this.val = data;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
