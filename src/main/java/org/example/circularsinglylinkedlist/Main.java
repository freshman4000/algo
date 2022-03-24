package org.example.circularsinglylinkedlist;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>(6);
        list1.add(1, 0);
        //list1.add(7, 0);
        list1.traverse();
        DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>(2);
        list2.add(9, 0);
        list2.add(5, 0);
        list2.traverse();
        sum(list1, list2).traverse();
    }

    public static DoublyLinkedList<Integer> sum(DoublyLinkedList<Integer> list1, DoublyLinkedList<Integer> list2) {
        NodeD<Integer> temp1 = list1.head;
        NodeD<Integer> temp2 = list2.head;
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>((temp1.value + temp2.value) % 10);
        int remainder = (temp1.value + temp2.value) / 10;
        temp1 = temp1.next;
        temp2 = temp2.next;
        while (temp1 != null || temp2 != null) {
            int res = remainder;
            if (temp1 != null) {
                res += temp1.value;
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                res += temp2.value;
                temp2 = temp2.next;
            }
            dll.add(res % 10, dll.size + 1);
            remainder = res / 10;
        }
        return dll;
    }
}
