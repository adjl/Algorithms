package com.adjl.algorithms.datastructures;

public class Stack {

    public static Stack head;

    public int item;
    public Stack next;

    public static void push(int item) {
        Stack stack = new Stack();
        stack.item = item;
        stack.next = head;
        head = stack;
    }

    public static int pop() {
        Stack stack = head;
        head = head.next;
        return stack.item;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        Stack.push(13);
        Stack.push(5);
        Stack.push(1993);

        stack = Stack.head;
        while (stack != null) {
            System.out.print(stack.item + " ");
            stack = stack.next;
        }
        System.out.println();

        stack = Stack.head;
        while (stack != null) {
            System.out.println(Stack.pop());
            stack = stack.next;
        }
    }
}
