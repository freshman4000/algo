package org.example.circularsinglylinkedlist;

import java.util.HashSet;
import java.util.Set;

public class DoublyLinkedList<E> {
    NodeD<E> head;
    NodeD<E> tail;
    int size;

    public DoublyLinkedList (E value) {
        NodeD<E> node = new NodeD<>();
        node.value = value;
        node.previous = null;
        node.next = null;
        head = node;
        tail = node;
        size = 1;
    }

    public boolean add(E value, int location) {
        if (head == null) {
            System.out.println("List does not exist");
            return false;
        }
        NodeD<E> node = new NodeD<>();
        node.value = value;
        if (location == 0) {
            node.previous = null;
            node.next = head;
            head.previous =node;
            head = node;
        } else if (location > size - 1) {
            node.previous = tail;
            tail.next = node;
            node.next = null;
            tail = node;
        } else {
            NodeD<E> temp = head;
            for (int i = 1; i < location; i++) {
                temp = temp.next;
            }
            node.next = temp.next;
            node.next.previous = node;
            node.previous = temp;
            temp.next = node;
        }
        size++;
        return true;
    }

    public void traverse() {
        if (head == null) {
            System.out.println("List does not exist");
        }
        NodeD<E> temp = head;
        for (int i = 0; i < size; i++) {
            System.out.print(temp.value);
            if (i != size - 1) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public void reverseTraversal() {
        if (tail == null) {
            System.out.println("List does not exist");
        }
        NodeD<E> temp = tail;
        for (int i = 0; i < size; i++) {
            System.out.print(temp.value);
            if (i != size - 1) {
                System.out.print(" -> ");
            }
            temp = temp.previous;
        }
        System.out.println();
    }

    public void removeDuplicates() {
        Set<E> set = new HashSet<>();
        NodeD<E> temp = head;
        int dupCounter = 0;
        for (int i = 1; i <= size; i++) {
            set.add(temp.value);
        if (set.size() != i - dupCounter) {
            dupCounter++;
            temp.previous.next = temp.next;
            if (temp.next != null) {
                temp.next.previous = temp.previous;
            }
        }
        temp = temp.next;
        }
        size -= dupCounter;
    }
    public E findNthToLast(int n) {
        int position = size - 1 - n;
        NodeD<E> temp = head;
        int counter = 0;
        while(true) {
            if (position == counter) {
                return temp.value;
            }
            counter++;
            temp = temp.next;
        }
    }
    public E findNthToLast2(int n) {
        NodeD<E> node1 = head;
        NodeD<E> node2 = head;
        for (int i = 0; i < n; i++) {
            if (node2 == null) {
                return null;
            }
            node2 = node2.next;
        }
        while (node2.next != null) {
            node2 = node2.next;
            node1 = node1.next;
        }
        return node1.value;
    }
}