package org.example.singlylinkedlist;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList sLL = new SinglyLinkedList();
        sLL.createSinglyLinkedList(5);
        sLL.insertInLinkedList(6, 10);
        sLL.insertInLinkedList(-3, 0);
        sLL.insertInLinkedList(100, 2);
        sLL.searchIndexOfValue(100);
        sLL.traverse();
        sLL.deleteNode(3);
        sLL.traverse();
        sLL.deleteNode(0);
        sLL.traverse();
        sLL.deleteNode(100);
        sLL.traverse();
    }
}
