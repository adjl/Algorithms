package com.adjl.algorithms.datastructures;

public class LinkedList {

    public static LinkedList head;

    public int item;
    public LinkedList next;

    public LinkedList search(int item) {
        return search(item, head);
    }

    private LinkedList search(int item, LinkedList list) {
        if (list == null) return null;
        if (list.item == item) return list;
        return search(item, list.next);
    }

    public static void insert(int item) {
        LinkedList list = new LinkedList();
        list.item = item;
        list.next = head;
        head = list;
    }

    public LinkedList predecessor(int item) {
        return predecessor(item, head);
    }

    private LinkedList predecessor(int item, LinkedList list) {
        if (list == null || list.next == null) return null;
        if (list.next.item == item) return list;
        return predecessor(item, list.next);
    }

    public void delete(int item) {
        LinkedList list = search(item);
        if (list == null) return;

        LinkedList predecessor = predecessor(item);
        if (predecessor == null) {
            head = list.next;
        } else {
            predecessor.next = list.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        LinkedList.insert(13);
        LinkedList.insert(5);
        LinkedList.insert(1993);

        list = LinkedList.head;
        while (list != null) {
            System.out.print(list.item + " ");
            list = list.next;
        }
        System.out.println();

        list = LinkedList.head;
        System.out.println(list.search(5).item);
        System.out.println(list.predecessor(5).item);

        list.delete(5);

        list = LinkedList.head;
        while (list != null) {
            System.out.print(list.item + " ");
            list = list.next;
        }
        System.out.println();
    }
}
