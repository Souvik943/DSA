package org.example.patterns.LinkedList.Application;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    Node head = new Node();
    Node tail = new Node();
    int capacity; // This needs to be set!
    Map<Integer, Node> nodeMap;

    public LRUCache(int capacity) {
        this.capacity = capacity; // FIX: Assign parameter to the field
        nodeMap = new HashMap<>(capacity);

        // Connect the sentinels: head <-> tail
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);

            // REFRESH: Move accessed node to the front (MRU position)
            delete(node);
            add(node);

            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);

            // UPDATE: Change value and move to front
            node.val = value;
            delete(node);
            add(node);
        } else {
            // INSERT: Check capacity first
            if(nodeMap.size() == capacity) {
                // EVICT: Remove the "Least Recently Used" (node before tail)
                Node lru = tail.prev;
                nodeMap.remove(lru.key); // Remove from Map
                delete(lru);             // Remove from List
            }

            // Create and add new node
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;

            add(newNode); // Add to front
            nodeMap.put(key, newNode); // Add to map
        }
    }

    // Helper: Always adds right after Head (Most Recently Used position)
    public void add(Node node) {
        Node nextNode = head.next;

        // Link node to head and nextNode
        node.next = nextNode;
        node.prev = head;

        // Fix the pointers of head and nextNode
        head.next = node;
        nextNode.prev = node;
    }

    // Helper: Unlink a node from its current position
    public void delete(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        // "Heal" the gap
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    class Node {
        Node prev;
        Node next;
        int key;
        int val;
    }
}
