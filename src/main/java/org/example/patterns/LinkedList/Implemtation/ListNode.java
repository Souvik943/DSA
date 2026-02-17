package org.example.patterns.LinkedList.Implemtation;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {}
    public ListNode(int data) {
        this.val = data;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
