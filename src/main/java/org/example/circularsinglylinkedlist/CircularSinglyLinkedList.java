package org.example.circularsinglylinkedlist;

public class CircularSinglyLinkedList<E> {
    Node<E> head;
    Node<E> tail;
    int size;

    public CircularSinglyLinkedList(E value) {
        Node<E> node = new Node<>();
        this.head = node;
        this.tail = node;
        node.value = value;
        node.next = node;
        this.size = 1;
    }

    public boolean add(E value, int location) {
        if (head == null) return false;
        Node<E> node = new Node<>();
        node.value = value;
        if (location == 0) {
            node.next = head;
            head = node;
            tail.next = node;
        } else if (location >= size) {
            tail.next = node;
            node.next = head;
            tail = node;
        } else {
            Node<E> temp = head;
            for (int i = 1; i < location; i++) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }
        size++;
        return true;
    }

    public void traverse() {
        if (head == null) {
            System.out.println("List does not exist");
            return;
        }
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            System.out.print(temp.value);
            if (i != size - 1) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.print("\n");
    }

    public boolean delete(int location) {
        if (head == null) {
            System.out.println("List does not exist");
            return false;
        }
        if (location == 0) {
            if (size == 1) {
                head = null;
                tail.next = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
        } else if (location >= size - 1) {
            if (size == 1) {
                head = null;
                tail.next = null;
                tail = null;
            } else {
                Node<E> temp = head;
               for (int i = 1; i < size - 1; i++) {
                   temp = temp.next;
               }
               temp.next = tail.next;
               tail = temp;
            }
        } else {
            Node<E> temp = head;
            for (int i = 1; i < location; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        size--;
        return true;
    }
}
