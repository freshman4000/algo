package org.example.singlylinkedlist;

public class SinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createSinglyLinkedList(int nodeValue) {
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }
    //insert value in SinglyLinkedList
    public void insertInLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) {
            createSinglyLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >= size) {
            node.next = null;
            tail.next = node;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            Node tempNode2 = tempNode.next;
            tempNode.next = node;
            node.next = tempNode2;
        }
        size++;
    }
    public void traverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node tempNode = head;
        for (int i = 0; i < size; i++) {
            System.out.print(tempNode.value);
            tempNode = tempNode.next;
            if (i != size - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();

    }
    public void searchIndexOfValue(int nodeValue) {
        if (head == null) {
            System.out.println("Lis is empty");
            return;
        }
        Node tempNode = head;
        for (int i = 0; i < size; i++) {
            if (nodeValue == tempNode.value) {
                System.out.println("The value is located at index " + i);
                return;
            }
            tempNode = tempNode.next;
        }
        System.out.println("There is no such value int this list");
    }
    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        } else if (location == 0) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
        } else if (location >= size) {
            Node temp = head;
            for (int i = 0; i < size - 1; i++) {
                temp = temp.next;
            }
            if (temp == head) {
                head = tail = null;
                size--;
                return;
            }
            temp.next = null;
            tail = temp;
            size--;
        } else {
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }
}
