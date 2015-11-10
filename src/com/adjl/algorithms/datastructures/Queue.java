package com.adjl.algorithms.datastructures;

public class Queue {

    public static Queue head;
    public static Queue tail;

    public int item;
    public Queue next;

    public static void enqueue(int item) {
        Queue queue = new Queue();
        queue.item = item;
        queue.next = head;
        head = queue;
        if (queue.next == null) {
            tail = queue;
        }
    }

    public int dequeue() {
        Queue queue = tail;
        tail = predecessor(tail.item);
        return queue.item;
    }

    private Queue predecessor(int item) {
        return predecessor(item, head);
    }

    private Queue predecessor(int item, Queue queue) {
        if (queue == null || queue.next == null) return null;
        if (queue.next.item == item) return queue;
        return predecessor(item, queue.next);
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        Queue.enqueue(13);
        Queue.enqueue(5);
        Queue.enqueue(1993);

        queue = Queue.head;
        while (queue != null) {
            System.out.print(queue.item + " ");
            queue = queue.next;
        }
        System.out.println();

        queue = Queue.head;
        while (queue != null) {
            System.out.println(queue.dequeue());
            queue = queue.next;
        }
    }
}
